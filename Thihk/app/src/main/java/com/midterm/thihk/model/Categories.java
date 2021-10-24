package com.midterm.thihk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categories implements Serializable {
    @SerializedName("idCate")
    @Expose
    private String idCate;
    @SerializedName("nameCate")
    @Expose
    private String nameCate;
    @SerializedName("cateThumb")
    @Expose
    private String cateThumb;
    @SerializedName("cateDescription")
    @Expose
    private String cateDescription;

    public Categories(String idCate, String nameCate, String cateThumb, String cateDescription) {
        this.idCate = idCate;
        this.nameCate = nameCate;
        this.cateThumb = cateThumb;
        this.cateDescription = cateDescription;
    }

    public String getIdCate() {
        return idCate;
    }

    public void setIdCate(String idCate) {
        this.idCate = idCate;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    public String getCateThumb() {
        return cateThumb;
    }

    public void setCateThumb(String cateThumb) {
        this.cateThumb = cateThumb;
    }

    public String getCateDescription() {
        return cateDescription;
    }

    public void setCateDescription(String cateDescription) {
        this.cateDescription = cateDescription;
    }
}
