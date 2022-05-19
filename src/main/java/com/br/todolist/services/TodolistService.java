package com.br.todolist.services;

import com.br.todolist.models.entity.TodolistEntity;
import com.br.todolist.repositories.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodolistService {

    @Autowired
    TodolistRepository todolistRepository;

    public Page<TodolistEntity> findAll(Pageable pageable) {
        return todolistRepository.findAll(pageable);
    }

    @Transactional
    public Object save(TodolistEntity todolistEntity) {
        return todolistRepository.save(todolistEntity);
    }


    public Optional<TodolistEntity> findId(UUID id) {
        return todolistRepository.findById(id);
    }
}
