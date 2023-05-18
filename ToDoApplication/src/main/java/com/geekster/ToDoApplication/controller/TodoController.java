package com.geekster.ToDoApplication.controller;

import com.geekster.ToDoApplication.service.TodoService;
import com.geekster.ToDoApplication.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping(value = "/getAllTodos")
    public List<Todo> getAllTodo(){
        return todoService.getAllTodoFromService();
    }

    @GetMapping(value = "/getTodo/{id}")
    public Todo setPath(@PathVariable String id){
        return todoService.getTodoFromService(id);
    }

    @PostMapping(value ="/postTodos")
    public String sendTodoInServices(@RequestBody Todo todo){
        return todoService.sendTodoInService(todo);
    }

    @DeleteMapping(value = "/deleteTodoById/{id}")
    public String deleteTodoById(@PathVariable String id){
        return todoService.removeTodoById(id);
    }

    @PutMapping(value = "/updateTodoById/{id}/{status}")
    public String updateTodoById(@PathVariable String id,@PathVariable boolean status){
        return todoService.updateTodoById(id,status);
    }
}
