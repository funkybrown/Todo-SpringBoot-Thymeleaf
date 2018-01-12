/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funkybrown.Todo;


import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author ben
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TodoApplication.class)
@WebAppConfiguration
public class MockMvcWebTests {
    
    @Autowired
    private WebApplicationContext webContext;
    
    private MockMvc mockMvc;
    
    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
    }
    
    @Test
    public void homePage() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("content"));
    }
    
    @Test
    public void TasksPage() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("tasks"));
                //.andExpect(MockMvcResultMatchers.model().attribute("tasks", Matchers.is(Matchers.empty())));
    }
    
    @Test
    public void CompletedTasksPage() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/completed"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("tasks"));
                //.andExpect(MockMvcResultMatchers.model().attribute("tasks", Matchers.is(Matchers.empty())));
    }
    
    @Test
    public void PostTask() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/tasks")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Test Task12345"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/tasks"));
        
        Task expectedTask = new Task();
        expectedTask.setName("Test Task12345");
        
        mockMvc.perform(MockMvcRequestBuilders.get("/task/Test Task12345"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"))
            .andExpect(model().attributeExists("tasks"))
            .andExpect(model().attribute("tasks", hasSize(greaterThan(0))));
    }
    
}
