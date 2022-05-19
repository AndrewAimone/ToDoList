package com.br.todolist.services;

import com.br.todolist.models.entity.TodolistEntity;
import com.br.todolist.repositories.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodolistService {

    @Autowired
    TodolistRepository todolistRepository;

    public Object save(TodolistEntity todolistEntity) {
        return todolistRepository.save(todolistEntity);
    }
}
