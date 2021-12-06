package com.example.simpletodoserver.repository

import com.example.simpletodoserver.model.NewTodo
import com.example.simpletodoserver.model.Todo
import com.example.simpletodoserver.service.TodoServiceInterface
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.sql.Statement

@Repository
class TodoRepository(private val jdbcTemplate: JdbcTemplate) : TodoServiceInterface {
    override fun allTodo(): List<Todo> {
        return jdbcTemplate.query(
            """select id, title, is_completed from todo order by id"""
        ) { rs: ResultSet, _: Int ->
            Todo(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getBoolean("is_completed")
            )
        }
    }

    override fun createTodo(newTodo: NewTodo): Todo {
        val keyHolder = GeneratedKeyHolder()
        jdbcTemplate.update({ connection ->
            val statement = connection.prepareStatement(
                """insert into todo(title, is_completed) values (?, false)""", Statement.RETURN_GENERATED_KEYS
            )
            statement.setString(1, newTodo.title)
            statement
        }, keyHolder)
        return Todo(
            keyHolder.keys!!["id"] as Int,
            keyHolder.keys!!["title"] as String,
            keyHolder.keys!!["is_completed"] as Boolean
        )
    }
}