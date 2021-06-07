package com.test.project.nconding.controllers;

import java.util.List;
import java.util.Optional;

import com.test.project.nconding.models.CourseModel;
import com.test.project.nconding.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    public CourseModel saveCourse(@RequestBody CourseModel course) {
        return this.courseService.saveCourse(course);
    }

    @GetMapping
    public List<CourseModel> getCourses() {
        return this.courseService.getCourses();
    }

    @GetMapping(path = "{id}")
    public Optional<CourseModel> getCourse(@PathVariable Long id) {
        return this.courseService.getCourseById(id);
    }

    @DeleteMapping(path = "{id}")
    public String deleteCourse(@PathVariable Long id) {
        if (this.courseService.deleteCourse(id)) {
            return "Course with id " + id + " has been deleted";
        } else {
            return "Not found the Course with id " + id;
        }
    }

    @PutMapping(path = "{id}")
    public CourseModel editCourse(@PathVariable Long id, @RequestBody CourseModel course) {
         return this.courseService.editCourse(id, course);
    }
}
