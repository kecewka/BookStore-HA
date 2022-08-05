package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.dto.UserDto;
import kz.halykacademy.bookstore.dto.UserPostDto;
import kz.halykacademy.bookstore.mapper.MapStructMapper;
import kz.halykacademy.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MapStructMapper mapStructMapper;

    @GetMapping("/users")
    public List<UserDto> showAllUsers() {
        List<UserDto> allUsers = mapStructMapper.userToDtos(userService.getAllUsers());
        return allUsers;
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable int id) {
        UserDto user = mapStructMapper.userToDto(userService.getUser(id));
        return user;
    }

    @PostMapping("/users")
    public UserPostDto addNewUser(@RequestBody UserPostDto user) {
        userService.saveUser(mapStructMapper.dtoToUser(user));
        return user;
    }

    @PutMapping("/users")
    public UserPostDto updateUser(@RequestBody UserPostDto user) {
        userService.saveUser(mapStructMapper.dtoToUser(user));
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        UserDto user = mapStructMapper.userToDto(userService.getUser(id));
        userService.deleteUser(id);
        return "user: " + user.getLogin() + " was deleted";
    }

    @GetMapping(value = "/users/")
    public List<UserDto> findAllNotBlockedStatus(){
        List<UserDto> users = mapStructMapper.userToDtos(userService.findAllNotBlockedStatus());
        return users;
    }
}
