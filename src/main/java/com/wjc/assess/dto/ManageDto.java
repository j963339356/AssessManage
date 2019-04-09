package com.wjc.assess.dto;

import com.wjc.assess.entity.AssessScore;

import java.util.List;

public class ManageDto {
    private String level;

    private String county;

    private String city;

    private Integer countyScore;

    private Integer cityScore;

    private Integer provinceScore;

    private List<AssessScore> scoreList;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getCountyScore() {
        return countyScore;
    }

    public void setCountyScore(Integer countyScore) {
        this.countyScore = countyScore;
    }

    public Integer getCityScore() {
        return cityScore;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCityScore(Integer cityScore) {
        this.cityScore = cityScore;
    }

    public Integer getProvinceScore() {
        return provinceScore;
    }

    public void setProvinceScore(Integer provinceScore) {
        this.provinceScore = provinceScore;
    }

    public List<AssessScore> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<AssessScore> scoreList) {
        this.scoreList = scoreList;
    }
}
