package com.example.javaexercises5.designpatterns.Task01;

/* Class meet the requirements of Singleton design pattern */
public class AppConfig {
    private String host;
    private int port;
    private String servletPrefix;

    /* static field */
    private static AppConfig INSTANCE;

    /* private constructor */
    private AppConfig(String host, int port, String servletPrefix) {
        this.host = host;
        this.port = port;
        this.servletPrefix = servletPrefix;
    }

    public static AppConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppConfig("instance-1", 8080, "/admin");
        }
        return INSTANCE;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getServletPrefix() {
        return servletPrefix;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
