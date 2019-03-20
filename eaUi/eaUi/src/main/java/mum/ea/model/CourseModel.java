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
public class CourseModel {
    
    private Long id;
    private String name;
    private String description;
    private List<LessonModel> lessonList;
    private MemberModel instructor;
    private List<MemberModel> joinedMembers;
    private SubCategoryModel subCategory;

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

    public List<LessonModel> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<LessonModel> lessonList) {
        this.lessonList = lessonList;
    }

    public MemberModel getInstructor() {
        return instructor;
    }

    public void setInstructor(MemberModel instructor) {
        this.instructor = instructor;
    }

    public List<MemberModel> getJoinedMembers() {
        return joinedMembers;
    }

    public void setJoinedMembers(List<MemberModel> joinedMembers) {
        this.joinedMembers = joinedMembers;
    }

    public SubCategoryModel getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategoryModel subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
