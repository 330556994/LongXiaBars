package com.longxia.entities;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Bar entity. @author MyEclipse Persistence Tools
 */

public class Bar  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private BarCategorTwo barCategorTwo;
     private User user;
     private String name;
     private Set replies = new HashSet(0);
     private Set levelNames = new HashSet(0);
     private Set threads = new HashSet(0);
     private Set attentionBars = new HashSet(0);


    // Constructors

    /** default constructor */
    public Bar() {
    }

	/** minimal constructor */
    public Bar(BarCategorTwo barCategorTwo, User user, String name) {
        this.barCategorTwo = barCategorTwo;
        this.user = user;
        this.name = name;
    }
    
    /** full constructor */
    public Bar(BarCategorTwo barCategorTwo, User user, String name, Set replies, Set levelNames, Set threads, Set attentionBars) {
        this.barCategorTwo = barCategorTwo;
        this.user = user;
        this.name = name;
        this.replies = replies;
        this.levelNames = levelNames;
        this.threads = threads;
        this.attentionBars = attentionBars;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public BarCategorTwo getBarCategorTwo() {
        return this.barCategorTwo;
    }
    
    public void setBarCategorTwo(BarCategorTwo barCategorTwo) {
        this.barCategorTwo = barCategorTwo;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getReplies() {
        return this.replies;
    }
    
    public void setReplies(Set replies) {
        this.replies = replies;
    }

    public Set getLevelNames() {
        return this.levelNames;
    }
    
    public void setLevelNames(Set levelNames) {
        this.levelNames = levelNames;
    }

    public Set getThreads() {
        return this.threads;
    }
    
    public void setThreads(Set threads) {
        this.threads = threads;
    }

    public Set getAttentionBars() {
        return this.attentionBars;
    }
    
    public void setAttentionBars(Set attentionBars) {
        this.attentionBars = attentionBars;
    }
   








}