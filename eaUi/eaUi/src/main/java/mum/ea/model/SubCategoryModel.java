/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.ea.model;

import java.util.List;

/**
 *
 * @author umurinan
 */
public class SubCategoryModel {
    
    private Long id;
    private String name;
    private CategoryModel category;
    private List<CourseModel> courseList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public List<CourseModel> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseModel> courseList) {
        this.courseList = courseList;
    }
}
