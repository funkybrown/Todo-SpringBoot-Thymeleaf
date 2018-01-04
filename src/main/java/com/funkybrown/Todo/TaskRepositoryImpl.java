package com.funkybrown.Todo;

import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/*
    spring-data mongodb custom implementation PropertyReferenceException

    The problem is solved. This error appears when the Impl class is named incorrectly. The Impl class has to be named according to the repository class. 
    So the names have to be following for this example:
    com....service.UserRepositoryInterface.java (main repository)
    com....service.UserRepositoryInterfaceImpl.java (implementation of custom repository methods)
    com....service.UserRepositoryInterfaceCustom.java (interface with custom methods)
*/

//Impl postfix of the name on it compared to the core repository interface
public class TaskRepositoryImpl implements CustomTaskRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public boolean completeOneTask(String domain, String id) {

        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("completed", true);

        WriteResult result = mongoTemplate.updateFirst(query, update, domain);

        return result!=null; //result.getN();

    }
}