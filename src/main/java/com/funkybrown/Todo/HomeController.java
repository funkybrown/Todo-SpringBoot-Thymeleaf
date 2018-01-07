/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funkybrown.Todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ben
 */
@Controller
public class HomeController {
    
    // this should really be in a home controller.
    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("content", "home");     
        return "index"; 
    }
    
}
