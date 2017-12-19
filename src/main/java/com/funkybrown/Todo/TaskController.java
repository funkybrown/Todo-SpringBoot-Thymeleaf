/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funkybrown.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

   /*  @RequestMapping(value = "/task/{_id}", method= RequestMethod.POST)
    public String updateToTasklist(@PathVariable("_id") String _id, Task task){
        Task one = taskRepository.findOne(_id);
        
        if (one.get_id().equals(_id))   
        {
            // map hidden fields, replace everything from post
            task.setCompleteTime(LocalDateTime.MIN);Id(one.getId());
            art.set_id(_id);
            artListRepository.save(art);
        }
        
        return "redirect:/";
    }*/
}

