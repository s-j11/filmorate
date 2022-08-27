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
@RequestMapping("/users")
public class UserController {
    private Map<Integer, User> users = new HashMap<>();

    private final static Logger log = LoggerFactory.getLogger(UserController.class);
    @GetMapping
    public List<User> findAll() {

        List<User> inventoryUsers = new ArrayList<>();
        for (Map.Entry<Integer, User> entry : users.entrySet()){
            inventoryUsers.add(entry.getValue());
        }
        return inventoryUsers;
    }

    @PostMapping
    //@RequestMapping("/user")
    public User addUser(@RequestBody User user) {
        log.error("Ошибка при добовление пользователя");
        for (Map.Entry<Integer, User> entry : users.entrySet()){
            try {
                if(entry.equals(user)) {
                    throw new ValidationException("Пользователь уже существует");
                }else if(user.getEmail().equals(null)){
                    throw new ValidationException("E-mail не введен");
                }else if(user.getEmail().contains("@")){
                    throw new ValidationException("E-mail должен содержать символ @");
                }else if(user.getLogin().equals(null)){
                    throw new ValidationException("Логин не введен");
                }else if(user.getLogin().contains(" ")){
                    throw new ValidationException("Логин не должен содержать пробелы");
                }else if(user.getName().isBlank()){
                    user.setName(user.getLogin());
                }else if(user.getBirthday().isAfter(LocalDate.now())){
                    throw new ValidationException("Дата рождение не может быть в будущем");
                } else {
                    users.put(user.getId(),user);
                }
            }catch (ValidationException e){
                e.getMessage();
            }
        }
        return user;
    }

    @PutMapping
    //@RequestMapping("/user")
    public User updateUsers(@RequestBody User user) {
        log.error("Ошибка при обновление пользователя");
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            try {
                if (entry.equals(user)) {
                    throw new ValidationException("Пользователь уже существует");
                } else if (user.getEmail().equals(null)) {
                    throw new ValidationException("E-mail не введен");
                } else if (user.getEmail().contains("@")) {
                    throw new ValidationException("E-mail должен содержать символ @");
                } else if (user.getLogin().equals(null)) {
                    throw new ValidationException("Логин не введен");
                } else if (user.getLogin().contains(" ")) {
                    throw new ValidationException("Логин не должен содержать пробелы");
                } else if (user.getName().isBlank()) {
                    user.setName(user.getLogin());
                } else if (user.getBirthday().isAfter(LocalDate.now())) {
                    throw new ValidationException("Дата рождение не может быть в будущем");
                } else {
                    users.put(user.getId(), user);
                }
            } catch (ValidationException e) {
                e.getMessage();
            }
        }
            return user;
    }
}