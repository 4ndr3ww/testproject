package com.test.project.nconding.services;

import java.util.ArrayList;
import java.util.Optional;

import com.test.project.nconding.models.CourseModel;
import com.test.project.nconding.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    
    @Autowired
    CourseRepository courseRepository;

    public ArrayList<CourseModel> getCourses() {
        return (ArrayList<CourseModel>) courseRepository.findAll();
    }

    public CourseModel saveCourse(CourseModel course) {
        return courseRepository.save(course);
    }

    public Optional<CourseModel> getCourseById(Long id){
        return courseRepository.findById(id);
    }

    public boolean deleteCourse(Long id){
        try {
            courseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public CourseModel editCourse(Long id, CourseModel course){
        Optional<CourseModel> courseEdited = courseRepository.findById(id);
        courseEdited.get().setDescription(course.getDescription());
        courseEdited.get().setName(course.getName());
        return courseRepository.save(courseEdited.get());
    }

}
