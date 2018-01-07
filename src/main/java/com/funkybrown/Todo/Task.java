/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funkybrown.Todo;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author ben
 */

@Document(collection = "tasks")
public class Task {
    
    public Task(){}
    
    @Id
    public String _id;
    
    private String name;
        
    private String _csrf;

    private LocalDateTime createTime;

    private boolean completed;

    private LocalDateTime completeTime;


    // _id
    public String get_id() {
        return _id;
    }
    
    public void set_id(String _id) {
        this._id = _id;
    }
    
    // name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // _csrf
    public String get_csrf() {
        return _csrf;
    }
    public void set_csrf(String _csrf ) {
        this._csrf = _csrf;
    }

    // createTime
    public LocalDateTime getCreateTime() {
        return createTime; 
    }
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    // completeTime
    public LocalDateTime getCompleteTime() {
        return completeTime;
    }
    public void setCompleteTime(LocalDateTime completeTime) {
        this.completeTime  = completeTime;
    }
    
     // completed
    public boolean getCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed  = completed;
    }
}
    




    
