package com.longxia.mybatis.entities;
// default package

import java.sql.Timestamp;


/**
 * Reply entity. @author MyEclipse Persistence Tools
 */

public class Reply  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Bar bar;
     private Thread thread;
     private User user;
     private String content;
     private Timestamp replytime;


    // Constructors

    /** default constructor */
    public Reply() {
    }

    
    /** full constructor */
    public Reply(Bar bar, Thread thread, User user, String content, Timestamp replytime) {
        this.bar = bar;
        this.thread = thread;
        this.user = user;
        this.content = content;
        this.replytime = replytime;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Bar getBar() {
        return this.bar;
    }
    
    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Thread getThread() {
        return this.thread;
    }
    
    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getReplytime() {
        return this.replytime;
    }
    
    public void setReplytime(Timestamp replytime) {
        this.replytime = replytime;
    }
   








}