package com.es.phoneshop;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class PhoneshopMain {

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.valueOf(webPort));

        String contextPath = "/phoneshop";
        String warFilePath = "..\\target\\phoneshop-servlet-api.war";

        tomcat.getHost().setAppBase(".");

        tomcat.addWebapp(contextPath, warFilePath);


        tomcat.enableNaming();
        tomcat.getConnector();


        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        tomcat.getServer().await();
    }
}