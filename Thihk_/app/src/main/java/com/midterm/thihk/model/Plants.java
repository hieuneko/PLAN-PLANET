package com.midterm.thihk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Plants {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("idCate")
    @Expose
    private String idCate;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("stepCare1")
    @Expose
    private String stepCare1;
    @SerializedName("stepCare2")
    @Expose
    private String stepCare2;
    @SerializedName("stepCare3")
    @Expose
    private String stepCare3;
    @SerializedName("stepCare4")
    @Expose
    private String stepCare4;
    @SerializedName("stepCare5")
    @Expose
    private String stepCare5;

    public Plants(String id, String name, String idCate, String area, String description, String thumb, String stepCare1, String stepCare2, String stepCare3, String stepCare4, String stepCare5) {
        this.id = id;
        this.name = name;
        this.idCate = idCate;
        this.area = area;
        this.description = description;
        this.thumb = thumb;
        this.stepCare1 = stepCare1;
        this.stepCare2 = stepCare2;
        this.stepCare3 = stepCare3;
        this.stepCare4 = stepCare4;
        this.stepCare5 = stepCare5;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCate() {
        return idCate;
    }

    public void setIdCate(String idCate) {
        this.idCate = idCate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getStepCare1() {
        return stepCare1;
    }

    public void setStepCare1(String stepCare1) {
        this.stepCare1 = stepCare1;
    }

    public String getStepCare2() {
        return stepCare2;
    }

    public void setStepCare2(String stepCare2) {
        this.stepCare2 = stepCare2;
    }

    public String getStepCare3() {
        return stepCare3;
    }

    public void setStepCare3(String stepCare3) {
        this.stepCare3 = stepCare3;
    }

    public String getStepCare4() {
        return stepCare4;
    }

    public void setStepCare4(String stepCare4) {
        this.stepCare4 = stepCare4;
    }

    public String getStepCare5() {
        return stepCare5;
    }

    public void setStepCare5(String stepCare5) {
        this.stepCare5 = stepCare5;
    }



}
