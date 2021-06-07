package com.test.project.nconding.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.test.project.nconding.models.CourseModel;
import com.test.project.nconding.models.UserModel;
import com.test.project.nconding.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UserModel> getUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public UserModel editUser(Long id, UserModel user) {
        Optional<UserModel> userEdited = userRepository.findById(id);
        userEdited.get().setAge(user.getAge());
        userEdited.get().setFirstName(user.getFirstName());
        userEdited.get().setLastName(user.getLastName());
        return userRepository.save(userEdited.get());
    }

    public ArrayList<CourseModel> getUserCourses(Long userId) {
        Optional<UserModel> user = userRepository.findById(userId);
        return new ArrayList<CourseModel>(user.get().getCourses());
    }

    public UserModel registerUserToCourse(Long userId, CourseModel course) {
        Optional<UserModel> user = userRepository.findById(userId);
        List<CourseModel> courses = user.get().getCourses();
        courses.add(course);
        user.get().setCourses(courses);
        return userRepository.save(user.get());
    }

    public UserModel unregisterUserToCourse(Long userId, Long courseId) {
        Optional<UserModel> user = userRepository.findById(userId);
        List<CourseModel> courses = user.get().getCourses();
        courses.removeIf((course) -> courseId == course.getId());
        user.get().setCourses(courses);
        return userRepository.save(user.get());
    }
}
