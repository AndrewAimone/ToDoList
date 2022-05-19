package com.br.todolist.controllers;

import com.br.todolist.models.dto.TodolistDTO;
import com.br.todolist.models.entity.TodolistEntity;
import com.br.todolist.services.TodolistService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/todolist")
public class TodolistController {

    @Autowired
    TodolistService todolistService;


    @PostMapping
    public ResponseEntity<Object> saveTodolist(@RequestBody @Valid TodolistDTO todolistDTO){

        var todolistEntity = new TodolistEntity();
        BeanUtils.copyProperties(todolistDTO, todolistEntity);
        todolistEntity.setCreatedAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        return ResponseEntity.status(HttpStatus.CREATED).body(todolistService.save(todolistEntity));
    }

    @GetMapping
    public ResponseEntity<Page<TodolistEntity>> getAllTodolist(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(todolistService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTodolist(@PathVariable(value = "id")UUID id){
        Optional<TodolistEntity> todolistEntityOptional = todolistService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(todolistEntityOptional.get());
    }



    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTodolist(@PathVariable(value = "id")UUID id, @RequestBody @Valid TodolistDTO todolistDTO){

        Optional<TodolistEntity> todolistEntityOptional = todolistService.findById(id);

        var todolistEntity = new TodolistEntity();
        BeanUtils.copyProperties(todolistDTO, todolistEntity);
        todolistEntity.setId(todolistEntityOptional.get().getId());
        todolistEntity.setCreatedAt(todolistEntityOptional.get().getCreatedAt());

        return ResponseEntity.status(HttpStatus.OK).body(todolistService.save(todolistEntity));
    }

}
