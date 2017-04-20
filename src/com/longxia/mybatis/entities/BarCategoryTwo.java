package com.longxia.mybatis.entities;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * BarCategorTwo entity. @author MyEclipse Persistence Tools
 */

public class BarCategoryTwo  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String categoryName;
     private Integer categoryId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
     
     
}