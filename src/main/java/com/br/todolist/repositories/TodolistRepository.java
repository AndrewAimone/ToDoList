package com.br.todolist.repositories;

import com.br.todolist.models.entity.TodolistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodolistRepository extends JpaRepository<TodolistEntity, UUID> {


}
