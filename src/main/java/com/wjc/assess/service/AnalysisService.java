package com.wjc.assess.service;

import com.wjc.assess.dao.AssessManageMapper;
import com.wjc.assess.dao.AssessScoreMapper;
import com.wjc.assess.dto.AnalyScoreDto;
import com.wjc.assess.dto.AnalysisDto;
import com.wjc.assess.dto.AnalysisWholeDto;
import com.wjc.assess.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 统计分析管理
 */
@Service
@Transactional  //开启事务
public class AnalysisService {
    @Autowired
    AssessManageMapper manageDao;

    @Autowired
    AssessScoreMapper scoreDao;

    //评价等级统计
    public List<AnalysisDto> level(AssessManage manage, User user){
        AssessManageExample example = new AssessManageExample();
        AssessManageExample.Criteria criteria = example.createCriteria();
        criteria.andSysStatusEqualTo(1);
        criteria.andYearEqualTo(manage.getYear());
        criteria.andProvinceEqualTo(manage.getProvince());
        example.setOrderByClause("'city' asc");

        //计算各个市的平均值
        List<AssessManage> list = manageDao.selectByExample(example);
        List<String> amlist = new ArrayList<>();
        String temp = "";
        //获取不同的市
        for (int i=0; i<list.size(); i++){
            String city = list.get(i).getCity();
            if(city!=temp && !amlist.contains(city)){
                amlist.add(city);
            }
            temp = city;
        }
        //计算不同市的平均分值
        List<AnalysisDto> result = new ArrayList<>();
        for(int j=0; j<amlist.size(); j++) {
            int sum = 0;
            int avg = 0;
            //弄出同样的市
            List<AssessManage> city = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCity().equals(amlist.get(j))){
                    city.add(list.get(i));
                }
            }
            //计算平均值
            for(int i=0; i<city.size(); i++){
                sum += city.get(i).getProvinceScore();
            }
            avg = sum / city.size();
            AnalysisDto analysisDto = new AnalysisDto();
            analysisDto.setCity(amlist.get(j));
            analysisDto.setScore(avg);
            result.add(analysisDto);
        }
        return result;
    }

    //评价分值统计
    public List<AnalyScoreDto> score(AssessManage manage, User user){
        AssessScoreExample example = new AssessScoreExample();
        AssessScoreExample.Criteria criteria = example.createCriteria();
        criteria.andSysStatusEqualTo(1);
        criteria.andYearEqualTo(manage.getYear());
        criteria.andProvinceEqualTo(user.getProvince());

        List<AssessScore> list = scoreDao.selectByExample(example);

        List<String> amlist = new ArrayList<>();
        List<String> citylist = new ArrayList<>();
        String temp = "";
        String temp2 = "";
        for (int i=0; i<list.size(); i++){
            //获取不同的县
            String county = list.get(i).getCounty();
            String city = list.get(i).getCity();
            if(county!=temp && !amlist.contains(county)){
                amlist.add(county);
            }
            //获取不同的市
            if(city!=temp2 && !citylist.contains(city)){
                citylist.add(city);
            }
            temp = county;
            temp2 = city;
        }

        //计算不同县的分值
        List<AnalyScoreDto> countyResult = new ArrayList<>();
        for(int j=0; j<amlist.size(); j++) {
            int sum = 0, avg = 0;
            AnalyScoreDto analyScoreDto = new AnalyScoreDto();
            //弄出同样的市
            List<AssessScore> county = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCounty().equals(amlist.get(j))) {
                    county.add(list.get(i));
                    analyScoreDto.setCity(list.get(i).getCity());
                }
            }
            //算出p1~p4平均分
            for (int i = 0; i < county.size(); i++) {
                AssessScore assessScore = county.get(i);
                if(assessScore.getP().equals("p1") && assessScore.getLevel()==1){
                    analyScoreDto.setP1(assessScore.getProvinceScore());
                }
                if(assessScore.getP().equals("p2") && assessScore.getLevel()==1){
                    analyScoreDto.setP2(assessScore.getProvinceScore());
                }
                if(assessScore.getP().equals("p3") && assessScore.getLevel()==1){
                    analyScoreDto.setP3(assessScore.getProvinceScore());
                }
                if(assessScore.getP().equals("p4") && assessScore.getLevel()==1){
                    analyScoreDto.setP4(100-assessScore.getProvinceScore());
                }
                if(assessScore.getP().equals("p8") && assessScore.getLevel()==1){
                    analyScoreDto.setP8(assessScore.getProvinceScore());
                }
                if(assessScore.getP().equals("p9") && assessScore.getLevel()==1){
                    analyScoreDto.setP9(assessScore.getProvinceScore());
                }
            }
            //算出p5分
            int p51 = 0, p511 = 0;
            int p52 = 0, p521 = 0;
            int p53 = 0, p531 = 0;
            for (int i = 0; i < county.size(); i++) {
                if (county.get(i).getName().equals("新建、改扩建农村公路项目数")) {
                    p51 = county.get(i).getProvinceScore();
                }
                if (county.get(i).getName().equals("其中：与农村客运站点同步设计、建设、交付使用的项目数")) {
                    p511 = county.get(i).getProvinceScore();
                }
                if (county.get(i).getName().equals("行政村总数")) {
                    p52 = county.get(i).getProvinceScore();
                }
                if (county.get(i).getName().equals("其中：2公里范围内建成了农村客运站点的行政村数")) {
                    p521 = county.get(i).getProvinceScore();
                }
                if (county.get(i).getName().equals("等级三级以上道路客运站场数")) {
                    p53 = county.get(i).getProvinceScore();
                }
                if (county.get(i).getName().equals("其中：与城市公交站点的换乘距离小于300m的站场数")) {
                    p531 = county.get(i).getProvinceScore();
                }
            }
            avg = p511*50/p51 + p521*50/p52 + p531*50/p53;
            analyScoreDto.setP5(avg);
            //算出p6
            sum = 0;
            avg = 0;
            for (int i = 0; i < county.size(); i++) {
                AssessScore assessScore = county.get(i);
                if (assessScore.getP().equals("p6")) {
                    if (assessScore.getName().equals("城乡道路客运信息是否通过互联网对外动态发布")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 30;
                        }
                    }
                    if (assessScore.getName().equals("等级三级以上道路客运站是否公布可换乘的城市公交线路信息")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 30;
                        }
                    }
                    if (assessScore.getName().equals("是否开通了统一的交通运输服务监督电话，并保持良好运转")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 40;
                        }
                    }
                    if (assessScore.getName().equals("是否全面实现道路客运联网售票或网络售票")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 50;
                        }
                    }
                }
            }
            avg = sum;
            analyScoreDto.setP6(avg);
            //计算p7
            sum = 0;
            avg = 0;
            for (int i = 0; i < county.size(); i++) {
                AssessScore assessScore = county.get(i);
                if (assessScore.getP().equals("p7")) {
                    if (assessScore.getName().equals("市县级行政区域是否建立了“一城一交”的综合交通管理体制和城乡道路客运一体化多部门联合推进机制")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 30;
                        }
                    }
                    if (assessScore.getName().equals("市县级人民政府是否编制了市县级行政区城乡道路客运一体化发展规划及场站专项规划，主要指标纳入城乡规划统筹实施")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 30;
                        }
                    }
                    if (assessScore.getName().equals("市县级人民政府是否统一了公交化运行的农村客运与城市公交在税费、财政补贴等方面的政策")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 40;
                        }
                    }
                    if (assessScore.getName().equals("市县级人民政府是否出台了支持城乡道路客运一体化发展的政策")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 50;
                        }
                    }
                }
            }
            avg = sum ;
            analyScoreDto.setP7(avg);
            countyResult.add(analyScoreDto);
        }

        //计算每个市平均分
        List<AnalyScoreDto> result = new ArrayList<>();
        for (int i=0; i<citylist.size(); i++){
            int count=0;
            int p1=0,p2=0,p3=0,p4=0,p5=0,p6=0,p7=0,p8=0,p9=0;
            for(int j=0; j<countyResult.size(); j++){
                AnalyScoreDto tempdto = countyResult.get(j);
                //如果是同一个市
                if(tempdto.getCity().equals(citylist.get(i))){
                    count++;
                    p1 += tempdto.getP1();
                    p2 += tempdto.getP2();
                    p3 += tempdto.getP3();
                    p4 += tempdto.getP4();
                    p5 += tempdto.getP5();
                    p6 += tempdto.getP6();
                    p7 += tempdto.getP7();
                    p8 += tempdto.getP8();
                    p9 += tempdto.getP9();
                }
            }
            AnalyScoreDto resdto = new AnalyScoreDto();
            resdto.setCity(citylist.get(i));
            resdto.setP1(p1/count);
            resdto.setP2(p2/count);
            resdto.setP3(p3/count);
            resdto.setP4(p4/count);
            resdto.setP5(p5/count);
            resdto.setP6(p6/count);
            resdto.setP7(p7/count);
            resdto.setP8(p8/count);
            resdto.setP9(p9/count);
            result.add(resdto);
        }
        return result;
    }

    //总体情况评价等级统计
    public AnalysisWholeDto whole(AssessManage manage, User user){
        AssessManageExample example = new AssessManageExample();
        AssessManageExample.Criteria criteria = example.createCriteria();
        criteria.andSysStatusEqualTo(1);
        criteria.andYearEqualTo(manage.getYear());
        if(manage.getProvince()!=null && !manage.getProvince().equals("")){
            criteria.andProvinceEqualTo(manage.getProvince());
        }
        if(manage.getCity()!=null && !manage.getCity().equals("")){
            criteria.andCityEqualTo(manage.getCity());
        }
        example.setOrderByClause("'city' asc");
        List<AssessManage> list = manageDao.selectByExample(example);

        //各个县的成绩
        List<AnalysisDto> analysisDtos = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            AnalysisDto asdto = new AnalysisDto();
            asdto.setCity(list.get(i).getCounty());
            asdto.setScore(list.get(i).getProvinceScore());
            analysisDtos.add(asdto);
        }

        //行政村公路各客车通畅率
        AssessScoreExample example1 = new AssessScoreExample();
        AssessScoreExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andSysStatusEqualTo(1);
        criteria1.andYearEqualTo(manage.getYear());
        if(manage.getProvince()!=null && !manage.getProvince().equals("")){
            criteria1.andProvinceEqualTo(manage.getProvince());
        }
        if(manage.getCity()!=null && !manage.getCity().equals("")){
            criteria1.andCityEqualTo(manage.getCity());
        }
        example1.setOrderByClause("'city' asc");
        List<AssessScore> assessScoreList = scoreDao.selectByExample(example1);

        //弄出不同样的县
        List<String> countylist = new ArrayList<>();
        String temp = "";
        for (int i=0; i<assessScoreList.size(); i++){
            String county = assessScoreList.get(i).getCounty();
            //获取不同的市
            if(county!=temp && !countylist.contains(county)){
                countylist.add(county);
            }
            temp = county;
        }

        List<AnalyScoreDto> analyScoreDtos = new ArrayList<>();
        for(int j=0; j<countylist.size(); j++) {
            AnalyScoreDto asdto = new AnalyScoreDto();
            asdto.setCity(countylist.get(j));
            for (int i = 0; i < assessScoreList.size(); i++) {
                AssessScore tempas = assessScoreList.get(i);
                if(tempas.getCounty().equals(countylist.get(j))) {  //同一个县
                    if (tempas.getName().equals("行政村公路通畅率")) {
                        asdto.setP1(tempas.getProvinceScore());
                    }
                    if (tempas.getName().equals("行政村通客车率")) {
                        asdto.setP2(tempas.getProvinceScore());
                    }
//                    if (tempas.getP().equals("p1") && tempas.getLevel() == 1) {
//                    }
//                }
//                if(tempas.getCounty().equals(countylist.get(j))) {  //同一个县
//                    if (tempas.getP().equals("p2") && tempas.getLevel() == 1) {
//                    }
                }
            }
            analyScoreDtos.add(asdto);
        }

        //返回
        AnalysisWholeDto result = new AnalysisWholeDto();
        result.setPie(analysisDtos);
        result.setBar(analyScoreDtos);

        return result;
    }

    /**
     * 总评评价分值统计
     */
    public List<AnalyScoreDto> wholescore(AssessManage manage, User user) {
        AssessScoreExample example = new AssessScoreExample();
        AssessScoreExample.Criteria criteria = example.createCriteria();
        criteria.andSysStatusEqualTo(1);
        criteria.andYearEqualTo(manage.getYear());
        criteria.andProvinceEqualTo(user.getProvince());
        if(manage.getCity()!=null && !manage.getCity().equals("")){
            criteria.andCityEqualTo(manage.getCity());
        }

        List<AssessScore> list = scoreDao.selectByExample(example);

        List<String> amlist = new ArrayList<>();
        List<String> citylist = new ArrayList<>();
        String temp = "";
        String temp2 = "";
        for (int i = 0; i < list.size(); i++) {
            //获取不同的县
            String county = list.get(i).getCounty();
            String city = list.get(i).getCity();
            if (county != temp && !amlist.contains(county)) {
                amlist.add(county);
            }
            //获取不同的市
            if (city != temp2 && !citylist.contains(city)) {
                citylist.add(city);
            }
            temp = county;
            temp2 = city;
        }

        //计算不同县的分值
        List<AnalyScoreDto> countyResult = new ArrayList<>();
        for (int j = 0; j < amlist.size(); j++) {
            int sum = 0, avg = 0;
            AnalyScoreDto analyScoreDto = new AnalyScoreDto();
            //弄出同样的市
            List<AssessScore> county = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCounty().equals(amlist.get(j))) {
                    county.add(list.get(i));
                    analyScoreDto.setCity(list.get(i).getCity());
                    analyScoreDto.setCounty(list.get(i).getCounty());
                }
            }
            //算出p1~p4平均分
            for (int i = 0; i < county.size(); i++) {
                AssessScore assessScore = county.get(i);
                if (assessScore.getP().equals("p1") && assessScore.getLevel() == 1) {
                    analyScoreDto.setP1(assessScore.getProvinceScore());
                }
                if (assessScore.getP().equals("p2") && assessScore.getLevel() == 1) {
                    analyScoreDto.setP2(assessScore.getProvinceScore());
                }
                if (assessScore.getP().equals("p3") && assessScore.getLevel() == 1) {
                    analyScoreDto.setP3(assessScore.getProvinceScore());
                }
                if (assessScore.getP().equals("p4") && assessScore.getLevel() == 1) {
                    analyScoreDto.setP4(100 - assessScore.getProvinceScore());
                }
                if (assessScore.getP().equals("p8") && assessScore.getLevel() == 1) {
                    analyScoreDto.setP8(assessScore.getProvinceScore());
                }
                if (assessScore.getP().equals("p9") && assessScore.getLevel() == 1) {
                    analyScoreDto.setP9(assessScore.getProvinceScore());
                }
            }
            //算出p5分
            int p51 = 0, p511 = 0;
            int p52 = 0, p521 = 0;
            int p53 = 0, p531 = 0;
            for (int i = 0; i < county.size(); i++) {
                if (county.get(i).getName().equals("新建、改扩建农村公路项目数")) {
                    p51 = county.get(i).getProvinceScore();
                }
                if (county.get(i).getName().equals("其中：与农村客运站点同步设计、建设、交付使用的项目数")) {
                    p511 = county.get(i).getProvinceScore();
                }
                if (county.get(i).getName().equals("行政村总数")) {
                    p52 = county.get(i).getProvinceScore();
                }
                if (county.get(i).getName().equals("其中：2公里范围内建成了农村客运站点的行政村数")) {
                    p521 = county.get(i).getProvinceScore();
                }
                if (county.get(i).getName().equals("等级三级以上道路客运站场数")) {
                    p53 = county.get(i).getProvinceScore();
                }
                if (county.get(i).getName().equals("其中：与城市公交站点的换乘距离小于300m的站场数")) {
                    p531 = county.get(i).getProvinceScore();
                }
            }
            avg = p511 * 50 / p51 + p521 * 50 / p52 + p531 * 50 / p53;
            analyScoreDto.setP5(avg);
            //算出p6
            sum = 0;
            avg = 0;
            for (int i = 0; i < county.size(); i++) {
                AssessScore assessScore = county.get(i);
                if (assessScore.getP().equals("p6")) {
                    if (assessScore.getName().equals("城乡道路客运信息是否通过互联网对外动态发布")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 30;
                        }
                    }
                    if (assessScore.getName().equals("等级三级以上道路客运站是否公布可换乘的城市公交线路信息")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 30;
                        }
                    }
                    if (assessScore.getName().equals("是否开通了统一的交通运输服务监督电话，并保持良好运转")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 40;
                        }
                    }
                    if (assessScore.getName().equals("是否全面实现道路客运联网售票或网络售票")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 50;
                        }
                    }
                }
            }
            avg = sum;
            analyScoreDto.setP6(avg);
            //计算p7
            sum = 0;
            avg = 0;
            for (int i = 0; i < county.size(); i++) {
                AssessScore assessScore = county.get(i);
                if (assessScore.getP().equals("p7")) {
                    if (assessScore.getName().equals("市县级行政区域是否建立了“一城一交”的综合交通管理体制和城乡道路客运一体化多部门联合推进机制")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 30;
                        }
                    }
                    if (assessScore.getName().equals("市县级人民政府是否编制了市县级行政区城乡道路客运一体化发展规划及场站专项规划，主要指标纳入城乡规划统筹实施")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 30;
                        }
                    }
                    if (assessScore.getName().equals("市县级人民政府是否统一了公交化运行的农村客运与城市公交在税费、财政补贴等方面的政策")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 40;
                        }
                    }
                    if (assessScore.getName().equals("市县级人民政府是否出台了支持城乡道路客运一体化发展的政策")) {
                        if (assessScore.getProvinceScore() == 1) {
                            sum += 50;
                        }
                    }
                }
            }
            avg = sum;
            analyScoreDto.setP7(avg);
            sum = analyScoreDto.getP1()+analyScoreDto.getP2()+analyScoreDto.getP3()+analyScoreDto.getP4()+
                    analyScoreDto.getP5()+analyScoreDto.getP6()+analyScoreDto.getP7()+analyScoreDto.getP8()+
                    analyScoreDto.getP9();
            analyScoreDto.setTotal(sum);
            if(sum>900) {
                analyScoreDto.setLevel("AAAAA");
            }else if (sum>=800 && sum<900){
                analyScoreDto.setLevel("AAAA");
            }else if (sum>=600 && sum<800){
                analyScoreDto.setLevel("AAA");
            }else if (sum>=600 && sum<700){
                analyScoreDto.setLevel("AA");
            }else if (sum<500){
                analyScoreDto.setLevel("A");
            }
            countyResult.add(analyScoreDto);
        }
        return countyResult;
    }
}
