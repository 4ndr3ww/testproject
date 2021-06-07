package com.test.project.nconding.repositories;

import java.util.ArrayList;
import java.util.Optional;

import com.test.project.nconding.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    // public abstract ArrayList<UserModel> findByName(String name);
    public abstract Optional<UserModel> findByFirstName(String firstName);
}
