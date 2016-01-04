package ${package}.web.listener;

import ${package}.init.EntityRegistrar;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // Register all entities for Objectify
        EntityRegistrar.registerEntities();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
