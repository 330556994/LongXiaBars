package com.longxia.mybatis.entities;
// default package



/**
 * AttentionThread entity. @author MyEclipse Persistence Tools
 */

public class AttentionThread  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Thread thread;
     private User user;


    // Constructors

    /** default constructor */
    public AttentionThread() {
    }

    
    /** full constructor */
    public AttentionThread(Thread thread, User user) {
        this.thread = thread;
        this.user = user;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
   








}