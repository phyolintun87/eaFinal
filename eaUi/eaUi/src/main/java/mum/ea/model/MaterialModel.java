/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.ea.model;

/**
 *
 * @author umurinan
 */
public class MaterialModel {
     
    private Long id;
    private String name;
    private LessonModel lesson;

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

    public LessonModel getLesson() {
        return lesson;
    }

    public void setLesson(LessonModel lesson) {
        this.lesson = lesson;
    }
}
