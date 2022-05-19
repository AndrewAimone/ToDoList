package com.br.todolist.controllers;

import com.br.todolist.services.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;

public class TodolistController {

    @Autowired
    TodolistService todolistService;

}
