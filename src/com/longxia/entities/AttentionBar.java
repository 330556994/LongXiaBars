package com.longxia.entities;
// default package



/**
 * AttentionBar entity. @author MyEclipse Persistence Tools
 */

public class AttentionBar  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Bar bar;
     private User user;


    // Constructors

    /** default constructor */
    public AttentionBar() {
    }

    
    /** full constructor */
    public AttentionBar(Bar bar, User user) {
        this.bar = bar;
        this.user = user;
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

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
   








}