package com.example.mbboard.listener;

import org.springframework.stereotype.Component;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@Component
public class ContectBootListener implements ServletContextListener {


    public ContectBootListener() {

    }

    public void contextInitialized(ServletContextEvent sce)  {
    	// 외부저장공간 : DB
    	// WAS(Tomcat)안에 저장공간 : application, session, request
    	// 웹브라우즈안에 저장 공간 : cookie, api
    	ServletContext sc = sce.getServletContext();
    	sc.setAttribute("currentConnectCount", 0);
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }
	
}
