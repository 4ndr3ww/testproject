package com.test.project.nconding.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.test.project.nconding.models.CourseModel;
import com.test.project.nconding.models.UserModel;
import com.test.project.nconding.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping()
    public ArrayList<UserModel> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getUserById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        if (this.userService.deleteUser(id)) {
            return "User with id " + id + " has been deleted";
        } else {
            return "Not found the user with id " + id;
        }
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUser(@PathVariable("id") Long id, @RequestBody UserModel user) {
        return this.userService.editUser(id, user);
    }

    @GetMapping("query")
    public Optional<UserModel> getFisrtByName(@RequestParam("firstName") String firstName) {
        return this.userService.getUserByFirstName(firstName);
    }

    @GetMapping(path = "{userId}/courses")
    public ArrayList<CourseModel> getUserCourses(@PathVariable Long userId) {
        return this.userService.getUserCourses(userId);
    }

    @PostMapping(path = "{userId}/courses")
    public UserModel registerUserToCourse(@PathVariable Long userId, @RequestBody CourseModel course) {
        return this.userService.registerUserToCourse(userId, course);
    }

    @DeleteMapping(path = "{userId}/courses/{courseId}")
    public UserModel unregisterUserToCourse(@PathVariable Long userId, @PathVariable Long courseId) {
        return this.userService.unregisterUserToCourse(userId, courseId);
    }

}
