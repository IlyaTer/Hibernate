package com.mycompany.dzjdbchibernate.hibernate.tests;

import org.springframework.context.ApplicationContext;


public class TasksGeneral {
    
    private ApplicationContext context;

    public TasksGeneral(ApplicationContext context) {
        this.context = context;
    }
    
    public void start()
    {
        TasksTwo task = new TasksTwo(context);
        task.start();
        
        TasksThree task1 = new TasksThree(context);
        task1.start();
        
        TasksFour task2 = new TasksFour(context);
        task2.start();
        
        TasksFive task3 = new TasksFive(context);
        task3.start();
    }
    
}//end TasksGeneral
