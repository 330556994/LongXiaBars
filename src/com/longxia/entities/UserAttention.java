package com.longxia.entities;
// default package



/**
 * UserAttention entity. @author MyEclipse Persistence Tools
 */

public class UserAttention  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private User userByCoverattentionuserid;
     private User userByAttentionuserid;


    // Constructors

    /** default constructor */
    public UserAttention() {
    }

    
    /** full constructor */
    public UserAttention(User userByCoverattentionuserid, User userByAttentionuserid) {
        this.userByCoverattentionuserid = userByCoverattentionuserid;
        this.userByAttentionuserid = userByAttentionuserid;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserByCoverattentionuserid() {
        return this.userByCoverattentionuserid;
    }
    
    public void setUserByCoverattentionuserid(User userByCoverattentionuserid) {
        this.userByCoverattentionuserid = userByCoverattentionuserid;
    }

    public User getUserByAttentionuserid() {
        return this.userByAttentionuserid;
    }
    
    public void setUserByAttentionuserid(User userByAttentionuserid) {
        this.userByAttentionuserid = userByAttentionuserid;
    }
   








}