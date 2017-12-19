/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funkybrown.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskListController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskListController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    
    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String tasklist(Model model){
        List<Task> taskList = taskRepository.findByCompleted(false);

        if (taskList != null){
            model.addAttribute("tasks", taskList);
        }

        return "taskList";
    }
    
    @RequestMapping(value = "/completed/", method= RequestMethod.GET)
    public String compltedTasklist(Model model){
        List<Task> taskList = taskRepository.findByCompleted(true);

        if (taskList != null){
            model.addAttribute("tasks", taskList);
        }

        return "taskList";
    }
    
    @RequestMapping(value = "/", method= RequestMethod.POST)
    public String addToTasklist(Task task){
        taskRepository.insert(task);
        return "redirect:/";
    }
    
     @RequestMapping(value = "/delete/{id}", method= RequestMethod.GET)
    public String DeleteFromTaskList(@PathVariable("id") String id){
        taskRepository.delete(id);
        return "redirect:/";
    }
   
}

