package com.wjc.assess.dto;

//统计分析的情况
public class SituationDto {
    private String city;    //市
    private String county;  //县
    private String level;   //评价等级
    private int score;      //总评分值
    private int pScore;     //某个p的分值
    private int rate;    //比率
    private int name1;     //如：城乡客运车辆数
    private int name2;     //其中:城市公交车辆数
    private int name3;     //其中：公交化运营的农村客运车辆数

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getpScore() {
        return pScore;
    }

    public void setpScore(int pScore) {
        this.pScore = pScore;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getName1() {
        return name1;
    }

    public void setName1(int name1) {
        this.name1 = name1;
    }

    public int getName2() {
        return name2;
    }

    public void setName2(int name2) {
        this.name2 = name2;
    }

    public int getName3() {
        return name3;
    }

    public void setName3(int name3) {
        this.name3 = name3;
    }
}
