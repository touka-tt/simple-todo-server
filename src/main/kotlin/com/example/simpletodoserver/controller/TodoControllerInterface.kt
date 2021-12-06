package com.example.simpletodoserver.controller

import com.example.simpletodoserver.model.NewTodo
import com.example.simpletodoserver.model.Todo

interface TodoControllerInterface {
    fun allTodo(): List<Todo>
    fun createTodo(newTodo: NewTodo): Todo
}