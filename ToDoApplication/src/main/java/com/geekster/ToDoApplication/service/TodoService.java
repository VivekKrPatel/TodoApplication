package com.geekster.ToDoApplication.service;

import com.geekster.ToDoApplication.repository.TodoDao;
import com.geekster.ToDoApplication.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoDao todoDao;

    public List<Todo> getAllTodoFromService() {
        return todoDao.getAllTodosFromRepo();
    }

    public Todo getTodoFromService(String id) {
        List<Todo> todoList = getAllTodoFromService();
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return new Todo();
    }

    public String sendTodoInService(Todo todo) {
        boolean check = todoDao.sendTodoInRepo(todo);
        if (check) {
            return "Todo Saved successfully...!!!";
        }
        return "Failed...!!!!";
    }

    public String removeTodoById(String id) {
        boolean Response = false;
        String status;

        if (id != null) {
            List<Todo> filteredList = todoDao.getAllTodosFromRepo();

            for (Todo todoObj : filteredList) {
                if (todoObj.getId().equals(id)) {
                    Response = todoDao.remove(todoObj);
                    if (Response) {
                        status = "Delete Succesfully";
                    } else {
                        status = "Not deleted";
                    }
                    return status;
                }
            }
            return "id does not Exist";
        } else {
            return "invalid id";
        }
    }

    public String updateTodoById(String id, boolean status) {
        List<Todo> filteredList = todoDao.getAllTodosFromRepo();

        for (Todo todoObj : filteredList) {
            if (todoObj.getId().equals(id)) {
                todoDao.update(id, status);
                return "updated successfully";
            }
        }
        return "Invalid id";
    }
}
