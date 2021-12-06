package com.example.simpletodoserver.service


import com.example.simpletodoserver.controller.TodoControllerInterface
import com.example.simpletodoserver.model.NewTodo
import com.example.simpletodoserver.model.Todo
import org.springframework.stereotype.Service

@Service
class TodoService(private val todoRepository: TodoServiceInterface) : TodoControllerInterface {
    override fun allTodo(): List<Todo> {
        return todoRepository.allTodo()
    }

    override fun createTodo(newTodo: NewTodo): Todo {
        return todoRepository.createTodo(newTodo)
    }
}