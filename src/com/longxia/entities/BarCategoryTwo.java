package com.longxia.entities;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * BarCategorTwo entity. @author MyEclipse Persistence Tools
 */

public class BarCategoryTwo  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private BarCategory barCategory;
     private String categoryname;
     private Set bars = new HashSet(0);


    // Constructors

    /** default constructor */
    public BarCategoryTwo() {
    }

	/** minimal constructor */
    public BarCategoryTwo(BarCategory barCategory, String categoryname) {
        this.barCategory = barCategory;
        this.categoryname = categoryname;
    }
    
    /** full constructor */
    public BarCategoryTwo(BarCategory barCategory, String categoryname, Set bars) {
        this.barCategory = barCategory;
        this.categoryname = categoryname;
        this.bars = bars;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public BarCategory getBarCategory() {
        return this.barCategory;
    }
    
    public void setBarCategory(BarCategory barCategory) {
        this.barCategory = barCategory;
    }

    public String getCategoryname() {
        return this.categoryname;
    }
    
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Set getBars() {
        return this.bars;
    }
    
    public void setBars(Set bars) {
        this.bars = bars;
    }
   








}