/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funkybrown.Todo;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List; 

@Controller
public class TaskListController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskListController(TaskRepository taskRepository){
        this.taskRepository = taskRepository; 
    }
    
    @RequestMapping(value = "/tasks", method= RequestMethod.GET)
    public String tasklist(Model model){
        List<Task> taskList = taskRepository.findByCompleted(false);
         
        if (taskList != null){
            model.addAttribute("tasks", taskList);
        }
        
        model.addAttribute("content", "taskList");     
        return "index"; 
    }
    
    @RequestMapping(value = "/completed", method= RequestMethod.GET)
    public String compltedTasklist(Model model){
        List<Task> taskList = taskRepository.findByCompleted(true);

        if (taskList != null){
            model.addAttribute("tasks", taskList);
        }  
         
        model.addAttribute("content", "completedTasks");     

        return "index"; 
    }    
    
    @RequestMapping(value = "/tasks", method= RequestMethod.POST)
    public String addToTasklist(Task task){
        task.setCreateTime(LocalDateTime.now());
        taskRepository.insert(task);
        return "redirect:/tasks"; 
    }
   
}