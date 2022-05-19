package com.br.todolist.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class TodolistDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private String done;

    private String deadline;
}
