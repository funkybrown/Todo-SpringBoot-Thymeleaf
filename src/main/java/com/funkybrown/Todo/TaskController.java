/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funkybrown.Todo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    
    @RequestMapping(value = "/task/{id}", method= RequestMethod.POST)
    public String completeTask(@PathVariable("id") String id){
       taskRepository.completeOneTask("tasks", id);
        return "redirect:/tasks";
    }
    
    @RequestMapping(value = "/delete/{id}", method= RequestMethod.GET)
    public String DeleteFromTaskList(@PathVariable("id") String id){
        taskRepository.delete(id);
        return "redirect:/tasks";
    }

}

