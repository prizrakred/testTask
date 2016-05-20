package ru.kolvah;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dmitriik on 19.05.2016.
 */
public class SpringContext {
    private static final ApplicationContext context = new ClassPathXmlApplicationContext("testTaskModuleContext.xml");

    public static ApplicationContext getContext() {
        return context;
    }
}
