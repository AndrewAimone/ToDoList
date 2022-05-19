package com.br.todolist.repositories;

import com.br.todolist.models.entity.TodolistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodolistRepository extends JpaRepository<TodolistEntity, UUID> {


}
