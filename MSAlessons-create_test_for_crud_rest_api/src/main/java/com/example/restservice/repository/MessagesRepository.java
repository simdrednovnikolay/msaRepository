package com.example.restservice.repository;

import com.example.restservice.model.MessageFromMsa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessagesRepository extends CrudRepository<MessageFromMsa, Long> {

    List<MessageFromMsa> findAll();

    Optional<MessageFromMsa> findById(Long id);

}
