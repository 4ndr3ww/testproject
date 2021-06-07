package com.test.project.nconding.repositories;

import com.test.project.nconding.models.CourseModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<CourseModel, Long> {

}
