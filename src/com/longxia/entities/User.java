package com.longxia.entities;
// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String nickname;
     private Integer sex;
     private Integer age;
     private String headimage;
     private String username;
     private String password;
     private Timestamp createtime;
     private Integer fanscount;
     private Integer attentioncount;
     private Set attentionBars = new HashSet(0);
     private Set userAttentionsForCoverattentionuserid = new HashSet(0);
     private Set replies = new HashSet(0);
     private Set levelNames = new HashSet(0);
     private Set bars = new HashSet(0);
     private Set attentionThreads = new HashSet(0);
     private Set threads = new HashSet(0);
     private Set userAttentionsForAttentionuserid = new HashSet(0);


    // Constructors

    /** default constructor */
    public User() {
    }

	/** minimal constructor */
    public User(String nickname, Integer sex, Integer age, String username, String password, Timestamp createtime, Integer fanscount, Integer attentioncount) {
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.username = username;
        this.password = password;
        this.createtime = createtime;
        this.fanscount = fanscount;
        this.attentioncount = attentioncount;
    }
    
    /** full constructor */
    public User(String nickname, Integer sex, Integer age, String headimage, String username, String password, Timestamp createtime, Integer fanscount, Integer attentioncount, Set attentionBars, Set userAttentionsForCoverattentionuserid, Set replies, Set levelNames, Set bars, Set attentionThreads, Set threads, Set userAttentionsForAttentionuserid) {
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.headimage = headimage;
        this.username = username;
        this.password = password;
        this.createtime = createtime;
        this.fanscount = fanscount;
        this.attentioncount = attentioncount;
        this.attentionBars = attentionBars;
        this.userAttentionsForCoverattentionuserid = userAttentionsForCoverattentionuserid;
        this.replies = replies;
        this.levelNames = levelNames;
        this.bars = bars;
        this.attentionThreads = attentionThreads;
        this.threads = threads;
        this.userAttentionsForAttentionuserid = userAttentionsForAttentionuserid;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeadimage() {
        return this.headimage;
    }
    
    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Integer getFanscount() {
        return this.fanscount;
    }
    
    public void setFanscount(Integer fanscount) {
        this.fanscount = fanscount;
    }

    public Integer getAttentioncount() {
        return this.attentioncount;
    }
    
    public void setAttentioncount(Integer attentioncount) {
        this.attentioncount = attentioncount;
    }

    public Set getAttentionBars() {
        return this.attentionBars;
    }
    
    public void setAttentionBars(Set attentionBars) {
        this.attentionBars = attentionBars;
    }

    public Set getUserAttentionsForCoverattentionuserid() {
        return this.userAttentionsForCoverattentionuserid;
    }
    
    public void setUserAttentionsForCoverattentionuserid(Set userAttentionsForCoverattentionuserid) {
        this.userAttentionsForCoverattentionuserid = userAttentionsForCoverattentionuserid;
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

    public Set getBars() {
        return this.bars;
    }
    
    public void setBars(Set bars) {
        this.bars = bars;
    }

    public Set getAttentionThreads() {
        return this.attentionThreads;
    }
    
    public void setAttentionThreads(Set attentionThreads) {
        this.attentionThreads = attentionThreads;
    }

    public Set getThreads() {
        return this.threads;
    }
    
    public void setThreads(Set threads) {
        this.threads = threads;
    }

    public Set getUserAttentionsForAttentionuserid() {
        return this.userAttentionsForAttentionuserid;
    }
    
    public void setUserAttentionsForAttentionuserid(Set userAttentionsForAttentionuserid) {
        this.userAttentionsForAttentionuserid = userAttentionsForAttentionuserid;
    }
   








}