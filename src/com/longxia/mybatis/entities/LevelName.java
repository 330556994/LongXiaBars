package com.longxia.mybatis.entities;
// default package



/**
 * LevelName entity. @author MyEclipse Persistence Tools
 */

public class LevelName  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Bar bar;
     private User user;
     private String levelname;
     private Integer level;


    // Constructors

    /** default constructor */
    public LevelName() {
    }

    
    /** full constructor */
    public LevelName(Bar bar, User user, String levelname, Integer level) {
        this.bar = bar;
        this.user = user;
        this.levelname = levelname;
        this.level = level;
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

    public String getLevelname() {
        return this.levelname;
    }
    
    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public Integer getLevel() {
        return this.level;
    }
    
    public void setLevel(Integer level) {
        this.level = level;
    }
   








}