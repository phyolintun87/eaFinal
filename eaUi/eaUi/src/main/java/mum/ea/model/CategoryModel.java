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
public class CategoryModel {

    private Long id;
    private String name;
    private List<SubCategoryModel> subCategoryList;

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

    public List<SubCategoryModel> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<SubCategoryModel> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
