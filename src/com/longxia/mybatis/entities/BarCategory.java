package com.longxia.mybatis.entities;
// default package

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;


/**
 * BarCategory entity. @author MyEclipse Persistence Tools
 */
public class BarCategory  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String categoryname;
    // Constructors

    /** default constructor */
    public BarCategory() {
    }

	/** minimal constructor */
    public BarCategory(String categoryname) {
        this.categoryname = categoryname;
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


}