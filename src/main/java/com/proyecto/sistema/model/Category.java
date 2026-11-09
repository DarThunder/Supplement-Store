
package com.proyecto.sistema.model;

public class Category {

    private Integer idCategory;
    private String name;
    private String desc;

    public Category() {
    }

    public Category(Integer idCategory, String name, String desc) {
        this.idCategory = idCategory;
        this.name = name;
        this.desc = desc;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
