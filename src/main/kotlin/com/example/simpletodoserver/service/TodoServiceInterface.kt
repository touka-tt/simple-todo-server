package com.example.simpletodoserver.service

import com.example.simpletodoserver.model.NewTodo
import com.example.simpletodoserver.model.Todo

interface TodoServiceInterface {
    fun allTodo(): List<Todo>
    fun createTodo(newTodo: NewTodo): Todo
}