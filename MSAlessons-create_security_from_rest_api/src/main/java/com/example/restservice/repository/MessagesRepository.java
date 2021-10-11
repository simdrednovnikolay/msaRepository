package com.example.restservice.repository;

import com.example.restservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessagesRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    Optional<User> findById(Long id);

}
