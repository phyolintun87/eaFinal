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
public class LessonModel {
 
    private Long id;
    private String name;
    private String description;
    private CourseModel course;
    private List<MaterialModel> materialList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourseModel getCourse() {
        return course;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }

    public List<MaterialModel> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<MaterialModel> materialList) {
        this.materialList = materialList;
    }
}
