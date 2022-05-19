package com.br.todolist.services;

import com.br.todolist.repositories.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TodolistService {

    @Autowired
    TodolistRepository todolistRepository;

}
