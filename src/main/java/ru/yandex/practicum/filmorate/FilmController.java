package ru.yandex.practicum.filmorate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/films")
public class FilmController {
    private Map<Integer, Film> films = new HashMap<>();

    private final static Logger log = LoggerFactory.getLogger(FilmController.class);
    @GetMapping
    public List<Film> findAll() {

        List<Film> inventoryFilms = new ArrayList<>();
        for (Map.Entry<Integer, Film> entry : films.entrySet()){
            inventoryFilms.add(entry.getValue());
        }
        return inventoryFilms;
    }

    @PostMapping
    //@RequestMapping("/film")
    public Film addFilm(@RequestBody Film film) {
        LocalDate date = LocalDate.of(1895,12,28);
        log.error("Ошибки валидации при добавление фильма");
        for (Map.Entry<Integer, Film> entry : films.entrySet()){
            try {
                if(entry.equals(film)) {
                    throw new ValidationException("Фильм уже добавлен в хранилище");
                }else if(film.getName().equals(null)) {
                    throw new ValidationException("Название фильма не указано");
                }else if(film.getDescription().length() > 200){
                    throw new ValidationException("Опесание фильно вышло за границы 200 символов");
                }else if(film.getReleaseData().isBefore(date)){
                    throw new ValidationException("Дата релиза не может быть ранее 28 декабря 1895 года");
                }else if(film.getDuration() > 0){
                    throw new ValidationException("Продолжительность фильма в минутах должна быль " +
                            "неотрицательной и больше 0");
                } else {
                    films.put(film.getId(),film);
                }
            }catch (ValidationException e){
                e.getMessage();
            }
        }
        return film;
    }

    @PutMapping
    //@RequestMapping("/film")
    public Film updateFilm(@RequestBody Film film) {
        LocalDate date = LocalDate.of(1895, 12, 28);
        log.error("Ошибки валидации при обновление фильма");

        for (Map.Entry<Integer, Film> entry : films.entrySet()) {
            try {
                if (entry.equals(film)) {
                    throw new ValidationException("Фильм уже добавлен в хранилище");
                } else if (film.getName().equals(null)) {
                    throw new ValidationException("Название фильма не указано");
                } else if (film.getDescription().length() > 200) {
                    throw new ValidationException("Опесание фильно вышло за границы 200 символов");
                } else if (film.getReleaseData().isBefore(date)) {
                    throw new ValidationException("Дата релиза не может быть ранее 28 декабря 1895 года");
                } else if (film.getDuration() > 0) {
                    throw new ValidationException("Продолжительность фильма в минутах должна быль " +
                            "неотрицательной и больше 0");
                } else {
                    films.put(film.getId(), film);
                }
            } catch (ValidationException e) {
                e.getMessage();
            }
        }
        return film;
    }
}
