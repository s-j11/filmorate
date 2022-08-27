package controllers;

import exseptions.InvalidUserBirthdayException;
import exseptions.InvalidUserEmailException;
import exseptions.InvalidUserLoginException;
import exseptions.UserAlreadyExistException;
import models.User;
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

    @GetMapping
    public List<User> findAll() {

        List<User> inventoryUsers = new ArrayList<>();
        for (Map.Entry<Integer, User> entry : users.entrySet()){
            inventoryUsers.add(entry.getValue());
        }
        return inventoryUsers;
    }

    @PostMapping
    @RequestMapping("/user")
    public User addUser(@RequestBody User user) {

        for (Map.Entry<Integer, User> entry : users.entrySet()){
            try {
                if(entry.equals(user)) {
                    throw new UserAlreadyExistException("Пользователь уже существует");

                }else if(user.getEmail().equals(null)){
                    throw new InvalidUserEmailException("E-mail не введен");
                }else if(user.getEmail().contains("@")){
                    throw new InvalidUserEmailException("E-mail должен содержать символ @");
                }else if(user.getLogin().equals(null)){
                    throw new InvalidUserLoginException("Логин не введен");
                }else if(user.getLogin().contains(" ")){
                    throw new InvalidUserLoginException("Логин не должен содержать пробелы");
                }else if(user.getName().isBlank()){
                    user.setName(user.getLogin());
                }else if(user.getBirthday().isAfter(LocalDate.now())){
                    throw new InvalidUserBirthdayException("Дата рождение не может быть в будущем");
                } else {
                    users.put(user.getId(),user);
                }
            }catch (UserAlreadyExistException | InvalidUserEmailException | InvalidUserLoginException |
                    InvalidUserBirthdayException e){
                e.getMessage();}
        }
        return user;
    }

    @PutMapping
    @RequestMapping("/user")
    public User updateUsers(@RequestBody User user){
        try {
            if(user.getEmail().equals(null)){
                throw new InvalidUserEmailException("E-mail не введен");
            }else {
                users.put(user.getId(),user);
            }
        } catch (InvalidUserEmailException e) {
            e.getMessage();
        }
        return user;
    }
}