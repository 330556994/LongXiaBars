package com.longxia.entities;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * BarCategory entity. @author MyEclipse Persistence Tools
 */

public class BarCategory  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String categoryname;
     private Set barCategorTwos = new HashSet(0);


    // Constructors

    /** default constructor */
    public BarCategory() {
    }

	/** minimal constructor */
    public BarCategory(String categoryname) {
        this.categoryname = categoryname;
    }
    
    /** full constructor */
    public BarCategory(String categoryname, Set barCategorTwos) {
        this.categoryname = categoryname;
        this.barCategorTwos = barCategorTwos;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryname() {
        return this.categoryname;
    }
    
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Set getBarCategorTwos() {
        return this.barCategorTwos;
    }
    
    public void setBarCategorTwos(Set barCategorTwos) {
        this.barCategorTwos = barCategorTwos;
    }
   








}