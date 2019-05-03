package com.wjc.assess.service;


import com.wjc.assess.dao.AssessManageMapper;
import com.wjc.assess.dao.AssessScoreMapper;
import com.wjc.assess.entity.AssessManage;
import com.wjc.assess.entity.AssessScore;
import com.wjc.assess.entity.AssessScoreExample;
import com.wjc.assess.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 导出文件
 */
@Service
@Transactional  //开启事务
public class ExportService {
    @Autowired
    AssessManageMapper manageDao;   //管理
    @Autowired
    AssessScoreMapper scoreDao; //分数

    //导出报表
    public void exportReport(List<AssessManage> manageList, User user){
        //要导出的数据
        List<List<AssessScore>> exportList = new ArrayList<>();
        //sheet名称
        List<String> sheetName = new ArrayList<>();
        //表头
        List<String> tableTitle = new ArrayList<>();
        tableTitle.add("指标名称");
        tableTitle.add("计量单位");
        tableTitle.add("县级填报结果");
        tableTitle.add("市级核定结果");
        tableTitle.add("省级核定结果");

        for(int l=0; l<manageList.size(); l++){
            AssessManage curManage = manageList.get(l);
            AssessScoreExample example = new AssessScoreExample();
            AssessScoreExample.Criteria criteria = example.createCriteria();
            criteria.andSysStatusEqualTo(1);
            criteria.andYearEqualTo(curManage.getYear());  //年度
            criteria.andCityEqualTo(curManage.getCity());  //市
            criteria.andCountyEqualTo(curManage.getCounty());  //县

            AssessManage manage = manageDao.selectByPrimaryKey(curManage.getId());  //获取考核总分
            List<AssessScore> scoreList = scoreDao.selectByExample(example);//获取评价分值
            List<AssessScore> addList = new ArrayList<>(43);  //要添加的每一列的数据
            addList.add(0,new AssessScore("总评价分值","分",manage.getCountyScore(),manage.getCityScore(),manage.getProvinceScore()));

            //获取每个表格分数
            int p1=0,p2=0,p3=0,p4=0,p5=0,p6=0,p7=0,p8=0,p9=0;
            int p11=0,p12=0,p13=0,p14=0,p15=0,p16=0,p17=0,p18=0,p19=0;
            int p21=0,p22=0,p23=0,p24=0,p25=0,p26=0,p27=0,p28=0,p29=0;
            for(int i=0; i<scoreList.size(); i++){
                AssessScore assessScore = scoreList.get(i);
                if(assessScore.getP().equals("p1") && assessScore.getName().equals("行政村公路通畅率")){
                    addList.add(2,assessScore);
                }
                else if(assessScore.getP().equals("p1") && assessScore.getName().equals("行政村总数")){
                    addList.add(3,assessScore);
                }
                else if(assessScore.getP().equals("p1") && assessScore.getName().equals("其中：已通路行政村数量")){
                    addList.add(4,assessScore);
                }
                else if(assessScore.getP().equals("p2") && assessScore.getName().equals("行政村通客车率")){
                    addList.add(6,assessScore);
                }
                else if(assessScore.getP().equals("p2") && assessScore.getName().equals("行政村总数")){
                    addList.add(7,assessScore);
                }
                else if(assessScore.getP().equals("p2") && assessScore.getName().equals("其中：通客运车辆行政村数量")){
                    addList.add(8,assessScore);
                }
                else if(assessScore.getP().equals("p3") && assessScore.getName().equals("城乡道路客运车辆公交化比率")){
                    addList.add(10,assessScore);
                }
                else if(assessScore.getP().equals("p3") && assessScore.getName().equals("城乡道路客运车辆数")){
                    addList.add(11,assessScore);
                }
                else if(assessScore.getP().equals("p3") && assessScore.getName().equals("其中：城市公交车辆数")){
                    addList.add(12,assessScore);
                }
                else if(assessScore.getP().equals("p3") && assessScore.getName().equals("其中：公交化运营的农村客运车辆数")){
                    addList.add(13,assessScore);
                }
                else if(assessScore.getP().equals("p4") && assessScore.getName().equals("城乡道路客运车辆交通责任事故万车死亡率")){
                    addList.add(15,assessScore);
                }
                else if(assessScore.getP().equals("p4") && assessScore.getName().equals("城乡道路客运车辆数")){
                    addList.add(16,assessScore);
                }
                else if(assessScore.getP().equals("p4") && assessScore.getName().equals("城乡道路客运车辆交通责任事故死亡人数")){
                    addList.add(17,assessScore);
                }
                else if(assessScore.getP().equals("p5") && assessScore.getName().equals("新建、改扩建农村公路项目数")){
                    addList.add(19,assessScore);
                }
                else if(assessScore.getP().equals("p5") && assessScore.getName().equals("其中：与农村客运站点同步设计、建设、交付使用的项目数")){
                    addList.add(20,assessScore);
                }
                else if(assessScore.getP().equals("p5") && assessScore.getName().equals("行政村总数")){
                    addList.add(21,assessScore);
                }
                else if(assessScore.getP().equals("p5") && assessScore.getName().equals("其中：2公里范围内建成了农村客运站点的行政村数")){
                    addList.add(22,assessScore);
                }
                else if(assessScore.getP().equals("p5") && assessScore.getName().equals("等级三级以上道路客运站场数")){
                    addList.add(23,assessScore);
                }
                else if(assessScore.getP().equals("p5") && assessScore.getName().equals("其中：与城市公交站点的换乘距离小于300m的站场数")){
                    addList.add(24,assessScore);
                }
                else if(assessScore.getP().equals("p6") && assessScore.getName().equals("城乡道路客运信息是否通过互联网对外动态发布")){
                    addList.add(26,assessScore);
                }
                else if(assessScore.getP().equals("p6") && assessScore.getName().equals("等级三级以上道路客运站是否公布可换乘的城市公交线路信息")){
                    addList.add(27,assessScore);
                }
                else if(assessScore.getP().equals("p6") && assessScore.getName().equals("是否开通了统一的交通运输服务监督电话，并保持良好运转")){
                    addList.add(28,assessScore);
                }
                else if(assessScore.getP().equals("p6") && assessScore.getName().equals("是否全面实现道路客运联网售票或网络售票")){
                    addList.add(29,assessScore);
                }
                else if(assessScore.getP().equals("p7") && assessScore.getName().equals("市县级行政区域是否建立了“一城一交”的综合交通管理体制和城乡道路客运一体化多部门联合推进机制")){
                    addList.add(31,assessScore);
                }
                else if(assessScore.getP().equals("p7") && assessScore.getName().equals("市县级人民政府是否编制了市县级行政区城乡道路客运一体化发展规划及场站专项规划，主要指标纳入城乡规划统筹实施")){
                    addList.add(32,assessScore);
                }
                else if(assessScore.getP().equals("p7") && assessScore.getName().equals("市县级人民政府是否统一了公交化运行的农村客运与城市公交在税费、财政补贴等方面的政策")){
                    addList.add(33,assessScore);
                }
                else if(assessScore.getP().equals("p7") && assessScore.getName().equals("市县级人民政府是否出台了支持城乡道路客运一体化发展的政策")){
                    addList.add(34,assessScore);
                }
                else if(assessScore.getP().equals("p8") && assessScore.getName().equals("镇村公共交通开通率")){
                    addList.add(36,assessScore);
                }
                else if(assessScore.getP().equals("p8") && assessScore.getName().equals("乡镇总数")){
                    addList.add(37,assessScore);
                }
                else if(assessScore.getP().equals("p8") && assessScore.getName().equals("其中：已开通镇村公交的乡镇数")){
                    addList.add(38,assessScore);
                }
                else if(assessScore.getP().equals("p9") && assessScore.getName().equals("农村客运班车公司化率")){
                    addList.add(40,assessScore);
                }
                else if(assessScore.getP().equals("p9") && assessScore.getName().equals("农村客运班车总数")){
                    addList.add(41,assessScore);
                }
                else if(assessScore.getP().equals("p9") && assessScore.getName().equals("其中：公司经营管理的农村客运班车数")){
                    addList.add(42,assessScore);
                }
            }
            p1 = scoreList.get(2).getCountyScore();
            p11 = scoreList.get(2).getCityScore();
            p21 = scoreList.get(2).getProvinceScore();
            addList.add(1,new AssessScore("P1分值","分",p1,p11,p21));
            p2 = scoreList.get(6).getCountyScore()*100/200;
            p12 = scoreList.get(6).getCityScore()*100/200;
            p22 = scoreList.get(6).getProvinceScore()*100/200;
            addList.add(5,new AssessScore("P2分值","分",p2,p12,p22));
            p3 = scoreList.get(10).getCountyScore()*100/150;
            p13 = scoreList.get(10).getCityScore()*100/150;
            p23 = scoreList.get(10).getProvinceScore()*100/150;
            addList.add(9,new AssessScore("P3分值","分",p3,p13,p23));
            p4 = 100 - scoreList.get(15).getCountyScore();
            p14 = 100 - scoreList.get(15).getCityScore();
            p24 = 100 - scoreList.get(15).getProvinceScore();
            addList.add(14,new AssessScore("P4分值","分",p4,p14,p24));
            p5 = scoreList.get(20).getCountyScore()*50/scoreList.get(19).getCountyScore()
                    +scoreList.get(22).getCountyScore()*50/scoreList.get(21).getCountyScore()
                    +scoreList.get(24).getCountyScore()*50/scoreList.get(23).getCountyScore();
            p15 = scoreList.get(20).getCityScore()*50/scoreList.get(19).getCityScore()
                    +scoreList.get(22).getCityScore()*50/scoreList.get(21).getCityScore()
                    +scoreList.get(24).getCityScore()*50/scoreList.get(23).getCityScore();
            p25 = scoreList.get(20).getProvinceScore()*50/scoreList.get(19).getProvinceScore()
                    +scoreList.get(22).getProvinceScore()*50/scoreList.get(21).getProvinceScore()
                    +scoreList.get(24).getProvinceScore()*50/scoreList.get(23).getProvinceScore();
            addList.add(18,new AssessScore("P5分值","分",p5,p15,p25));
            p6 = scoreList.get(26).getCountyScore()==0?0:30
                    +scoreList.get(27).getCountyScore()==0?0:30
                    +scoreList.get(28).getCountyScore()==0?0:40
                    +scoreList.get(29).getCountyScore()==0?0:50;
            p16 = scoreList.get(26).getCityScore()==0?0:30
                    +scoreList.get(27).getCityScore()==0?0:30
                    +scoreList.get(28).getCityScore()==0?0:40
                    +scoreList.get(29).getCityScore()==0?0:50;
            p26 = scoreList.get(26).getProvinceScore()==0?0:30
                    +scoreList.get(27).getProvinceScore()==0?0:30
                    +scoreList.get(28).getProvinceScore()==0?0:40
                    +scoreList.get(29).getProvinceScore()==0?0:50;
            addList.add(25,new AssessScore("P6分值","分",p6,p16,p26));
            p7 = scoreList.get(31).getCountyScore()==0?0:30
                    +scoreList.get(32).getCountyScore()==0?0:30
                    +scoreList.get(33).getCountyScore()==0?0:40
                    +scoreList.get(34).getCountyScore()==0?0:50;
            p17 = scoreList.get(31).getCityScore()==0?0:30
                    +scoreList.get(32).getCityScore()==0?0:30
                    +scoreList.get(33).getCityScore()==0?0:40
                    +scoreList.get(34).getCityScore()==0?0:50;
            p27 = scoreList.get(31).getProvinceScore()==0?0:30
                    +scoreList.get(32).getProvinceScore()==0?0:30
                    +scoreList.get(33).getProvinceScore()==0?0:40
                    +scoreList.get(34).getProvinceScore()==0?0:50;
            addList.add(30,new AssessScore("P7分值","分",p7,p17,p27));
            p8 = scoreList.get(36).getCountyScore();
            p18 = scoreList.get(36).getCityScore();
            p28 = scoreList.get(36).getProvinceScore();
            addList.add(35,new AssessScore("P8分值","分",p8,p18,p28));
            p9 = scoreList.get(40).getCountyScore();
            p19 = scoreList.get(40).getCityScore();
            p29 = scoreList.get(40).getProvinceScore();
            addList.add(39,new AssessScore("P9分值","分",p9,p19,p29));
            exportList.add(addList);    //加入内容，和sheet名一一对应
            sheetName.add(l+". "+manage.getOrgName());  //sheet名
        }
        exportExcel(sheetName,tableTitle,exportList);
    }

    //导出Excel,sheet名称，表头，内容
    public void exportExcel(List sheetNames,List tableTitles,List<List<AssessScore>> erportList){

    }
}
