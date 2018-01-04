package com.funkybrown.Todo;

/**
 *
 * @author ben
 */
public interface CustomTaskRepository {
    
    boolean completeOneTask(String domain, String id);
    
}
