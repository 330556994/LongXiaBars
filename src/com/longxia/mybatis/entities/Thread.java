package com.longxia.mybatis.entities;
// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Thread entity. @author MyEclipse Persistence Tools
 */

public class Thread  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Bar bar;
     private User user;
     private String title;
     private String content;
     private String image;
     private Timestamp createdate;
     private Integer isTop;
     private Integer replycount;
     private Set replies = new HashSet(0);
     private Set attentionThreads = new HashSet(0);


    // Constructors

    /** default constructor */
    public Thread() {
    }

	/** minimal constructor */
    public Thread(Bar bar, User user, String title, Timestamp createdate, Integer isTop, Integer replycount) {
        this.bar = bar;
        this.user = user;
        this.title = title;
        this.createdate = createdate;
        this.isTop = isTop;
        this.replycount = replycount;
    }
    
    /** full constructor */
    public Thread(Bar bar, User user, String title, String content, String image, Timestamp createdate, Integer isTop, Integer replycount, Set replies, Set attentionThreads) {
        this.bar = bar;
        this.user = user;
        this.title = title;
        this.content = content;
        this.image = image;
        this.createdate = createdate;
        this.isTop = isTop;
        this.replycount = replycount;
        this.replies = replies;
        this.attentionThreads = attentionThreads;
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

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreatedate() {
        return this.createdate;
    }
    
    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public Integer getIsTop() {
        return this.isTop;
    }
    
    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getReplycount() {
        return this.replycount;
    }
    
    public void setReplycount(Integer replycount) {
        this.replycount = replycount;
    }

    public Set getReplies() {
        return this.replies;
    }
    
    public void setReplies(Set replies) {
        this.replies = replies;
    }

    public Set getAttentionThreads() {
        return this.attentionThreads;
    }
    
    public void setAttentionThreads(Set attentionThreads) {
        this.attentionThreads = attentionThreads;
    }
   








}