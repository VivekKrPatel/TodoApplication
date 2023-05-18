package com.geekster.ToDoApplication.repository;

import com.geekster.ToDoApplication.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoDao {

    private List<Todo> todoList = new ArrayList<>();

//    Todo todo;

    public TodoDao(){
        Todo todo = new Todo("1","this is -1",true);
        todoList.add(todo);
    }

    public List<Todo> getAllTodosFromRepo(){
        return todoList;
    }

    public boolean sendTodoInRepo(Todo todo){
        todoList.add(todo);
        return true;
    }

    public boolean remove(Todo todo){
        todoList.remove(todo);
        return true;
    }

    public boolean update(String id, boolean status) {
        for(Todo todoObj : todoList){
            if(todoObj.getId().equals(id)){
                //remove from original
                if(remove(todoObj)) {
                    //set
                    todoObj.setTodoStatus(status);
                    //add
                    todoList.add(todoObj);
                    return true;

                }else{
                    return false;
                }

            }
        }
        return false;
    }
}
