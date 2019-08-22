package com.wjc.assess.service;


import com.wjc.assess.Enum.ExceptionEnum;
import com.wjc.assess.Exception.CustomException;
import com.wjc.assess.dao.AssessManageMapper;
import com.wjc.assess.dao.AssessScoreMapper;
import com.wjc.assess.entity.AssessManage;
import com.wjc.assess.entity.AssessScore;
import com.wjc.assess.entity.AssessScoreExample;
import com.wjc.assess.entity.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
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
    public void exportReport(String[] ids, HttpServletResponse response){
        // 下载文件的默认名称
        String filename = null;
        try {
            // 告诉浏览器用什么软件可以打开此文件
            filename = new String("考核评价报告.xls".getBytes("UTF-8"),"iso-8859-1");
            response.setHeader("content-Type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename="+filename);
            OutputStream out = response.getOutputStream();  //输出流

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

            for(int l=0; l<ids.length; l++){
                String id = ids[l];
                AssessManage manage = manageDao.selectByPrimaryKey(id);  //获取考核总分

                AssessScoreExample example = new AssessScoreExample();
                AssessScoreExample.Criteria criteria = example.createCriteria();
                criteria.andSysStatusEqualTo(1);
                criteria.andYearEqualTo(manage.getYear());  //年度
                criteria.andCityEqualTo(manage.getCity());  //市
                criteria.andCountyEqualTo(manage.getCounty());  //县

                List<AssessScore> scoreList = scoreDao.selectByExample(example);//获取评价分值
                List<AssessScore> addList = new ArrayList<>(43);  //要添加的每一列的数据
                //初始化
                for(int i=0; i<43; i++){
                    addList.add(new AssessScore());
                }
                addList.set(0,new AssessScore("总评价分值","分","p",manage.getCountyScore(),manage.getCityScore(),manage.getProvinceScore()));

                //获取每个表格分数
                Integer p1=0,p2=0,p3=0,p4=0,p5=0,p6=0,p7=0,p8=0,p9=0;
                Integer p11=0,p12=0,p13=0,p14=0,p15=0,p16=0,p17=0,p18=0,p19=0;
                Integer p21=0,p22=0,p23=0,p24=0,p25=0,p26=0,p27=0,p28=0,p29=0;
                for(int i=0; i<scoreList.size(); i++){
                    AssessScore assessScore = scoreList.get(i);
                    if(assessScore.getP().equals("p1") && assessScore.getName().equals("行政村公路通畅率")){
                        addList.set(2,assessScore);
                    }
                    else if(assessScore.getP().equals("p1") && assessScore.getName().equals("行政村总数")){
                        addList.set(3,assessScore);
                    }
                    else if(assessScore.getP().equals("p1") && assessScore.getName().equals("其中：已通路行政村数量")){
                        addList.set(4,assessScore);
                    }
                    else if(assessScore.getP().equals("p2") && assessScore.getName().equals("行政村通客车率")){
                        addList.set(6,assessScore);
                    }
                    else if(assessScore.getP().equals("p2") && assessScore.getName().equals("行政村总数")){
                        addList.set(7,assessScore);
                    }
                    else if(assessScore.getP().equals("p2") && assessScore.getName().equals("其中：通客运车辆行政村数量")){
                        addList.set(8,assessScore);
                    }
                    else if(assessScore.getP().equals("p3") && assessScore.getName().equals("城乡道路客运车辆公交化比率")){
                        addList.set(10,assessScore);
                    }
                    else if(assessScore.getP().equals("p3") && assessScore.getName().equals("城乡道路客运车辆数")){
                        addList.set(11,assessScore);
                    }
                    else if(assessScore.getP().equals("p3") && assessScore.getName().equals("其中：城市公交车辆数")){
                        addList.set(12,assessScore);
                    }
                    else if(assessScore.getP().equals("p3") && assessScore.getName().equals("其中：公交化运营的农村客运车辆数")){
                        addList.set(13,assessScore);
                    }
                    else if(assessScore.getP().equals("p4") && assessScore.getName().equals("城乡道路客运车辆交通责任事故万车死亡率")){
                        addList.set(15,assessScore);
                    }
                    else if(assessScore.getP().equals("p4") && assessScore.getName().equals("城乡道路客运车辆数")){
                        addList.set(16,assessScore);
                    }
                    else if(assessScore.getP().equals("p4") && assessScore.getName().equals("城乡道路客运车辆交通责任事故死亡人数")){
                        addList.set(17,assessScore);
                    }
                    else if(assessScore.getP().equals("p5") && assessScore.getName().equals("新建、改扩建农村公路项目数")){
                        addList.set(19,assessScore);
                    }
                    else if(assessScore.getP().equals("p5") && assessScore.getName().equals("其中：与农村客运站点同步设计、建设、交付使用的项目数")){
                        addList.set(20,assessScore);
                    }
                    else if(assessScore.getP().equals("p5") && assessScore.getName().equals("行政村总数")){
                        addList.set(21,assessScore);
                    }
                    else if(assessScore.getP().equals("p5") && assessScore.getName().equals("其中：2公里范围内建成了农村客运站点的行政村数")){
                        addList.set(22,assessScore);
                    }
                    else if(assessScore.getP().equals("p5") && assessScore.getName().equals("等级三级以上道路客运站场数")){
                        addList.set(23,assessScore);
                    }
                    else if(assessScore.getP().equals("p5") && assessScore.getName().equals("其中：与城市公交站点的换乘距离小于300m的站场数")){
                        addList.set(24,assessScore);
                    }
                    else if(assessScore.getP().equals("p6") && assessScore.getName().equals("城乡道路客运信息是否通过互联网对外动态发布")){
                        addList.set(26,assessScore);
                    }
                    else if(assessScore.getP().equals("p6") && assessScore.getName().equals("等级三级以上道路客运站是否公布可换乘的城市公交线路信息")){
                        addList.set(27,assessScore);
                    }
                    else if(assessScore.getP().equals("p6") && assessScore.getName().equals("是否开通了统一的交通运输服务监督电话，并保持良好运转")){
                        addList.set(28,assessScore);
                    }
                    else if(assessScore.getP().equals("p6") && assessScore.getName().equals("是否全面实现道路客运联网售票或网络售票")){
                        addList.set(29,assessScore);
                    }
                    else if(assessScore.getP().equals("p7") && assessScore.getName().equals("市县级行政区域是否建立了“一城一交”的综合交通管理体制和城乡道路客运一体化多部门联合推进机制")){
                        addList.set(31,assessScore);
                    }
                    else if(assessScore.getP().equals("p7") && assessScore.getName().equals("市县级人民政府是否编制了市县级行政区城乡道路客运一体化发展规划及场站专项规划，主要指标纳入城乡规划统筹实施")){
                        addList.set(32,assessScore);
                    }
                    else if(assessScore.getP().equals("p7") && assessScore.getName().equals("市县级人民政府是否统一了公交化运行的农村客运与城市公交在税费、财政补贴等方面的政策")){
                        addList.set(33,assessScore);
                    }
                    else if(assessScore.getP().equals("p7") && assessScore.getName().equals("市县级人民政府是否出台了支持城乡道路客运一体化发展的政策")){
                        addList.set(34,assessScore);
                    }
                    else if(assessScore.getP().equals("p8") && assessScore.getName().equals("镇村公共交通开通率")){
                        addList.set(36,assessScore);
                    }
                    else if(assessScore.getP().equals("p8") && assessScore.getName().equals("乡镇总数")){
                        addList.set(37,assessScore);
                    }
                    else if(assessScore.getP().equals("p8") && assessScore.getName().equals("其中：已开通镇村公交的乡镇数")){
                        addList.set(38,assessScore);
                    }
                    else if(assessScore.getP().equals("p9") && assessScore.getName().equals("农村客运班车公司化率")){
                        addList.set(40,assessScore);
                    }
                    else if(assessScore.getP().equals("p9") && assessScore.getName().equals("农村客运班车总数")){
                        addList.set(41,assessScore);
                    }
                    else if(assessScore.getP().equals("p9") && assessScore.getName().equals("其中：公司经营管理的农村客运班车数")){
                        addList.set(42,assessScore);
                    }
                }
                p1 = addList.get(2).getCountyScore();
                p11 = addList.get(2).getCityScore();
                p21 = addList.get(2).getProvinceScore();
                addList.set(1,new AssessScore("P1分值","分","p1",p1,p11,p21));
                p2 = addList.get(6).getCountyScore()==null?null:addList.get(6).getCountyScore() *100/200;
                p12 = addList.get(6).getCityScore()==null?null:addList.get(6).getCountyScore() *100/200;
                p22 = addList.get(6).getProvinceScore()==null?null:addList.get(6).getCountyScore() *100/200;
                addList.set(5,new AssessScore("P2分值","分","p2",p2,p12,p22));
                p3 = addList.get(10).getCountyScore()==null?null:addList.get(6).getCountyScore() *100/150;
                p13 = addList.get(10).getCityScore()==null?null:addList.get(6).getCountyScore() *100/150;
                p23 = addList.get(10).getProvinceScore()==null?null:addList.get(6).getCountyScore() *100/150;
                addList.set(9,new AssessScore("P3分值","分","p3",p3,p13,p23));
                if(addList.get(15).getCountyScore()!=null){
                    p4 = 100 - addList.get(15).getCountyScore();
                }
                p4 = addList.get(15).getCountyScore()==null?null:100 - addList.get(15).getCountyScore();
                p14 = addList.get(15).getCityScore()==null?null:100 - addList.get(15).getCityScore();
                p24 = addList.get(15).getProvinceScore()==null?null:100 - addList.get(15).getProvinceScore();
                addList.set(14,new AssessScore("P4分值","分","p4",p4,p14,p24));
                p5 = addList.get(19).getCountyScore()==null?null:
                        (addList.get(19).getCountyScore()==0?0:addList.get(20).getCountyScore()*50/addList.get(19).getCountyScore())
                                +(addList.get(21).getCountyScore()==0?0:addList.get(22).getCountyScore()*50/addList.get(21).getCountyScore())
                                +(addList.get(23).getCountyScore()==0?0:addList.get(24).getCountyScore()*50/addList.get(23).getCountyScore());
                p15 = addList.get(20).getCityScore()==null?null:
                        (addList.get(20).getCityScore()==0?0:addList.get(20).getCityScore()*50/addList.get(19).getCityScore())
                                +(addList.get(21).getCityScore()==0?0:addList.get(22).getCityScore()*50/addList.get(21).getCityScore())
                                +(addList.get(23).getCityScore()==0?0:addList.get(24).getCityScore()*50/addList.get(23).getCityScore());
                p25 = addList.get(20).getProvinceScore()==null?null:
                        (addList.get(20).getProvinceScore()==0?0:addList.get(20).getProvinceScore()*50/addList.get(19).getProvinceScore())
                                +(addList.get(21).getProvinceScore()==0?0:addList.get(22).getProvinceScore()*50/addList.get(21).getProvinceScore())
                                +(addList.get(23).getProvinceScore()==0?0:addList.get(24).getProvinceScore()*50/addList.get(23).getProvinceScore());
                addList.set(18,new AssessScore("P5分值","分","p5",p5,p15,p25));
                p6 = addList.get(26).getCountyScore()==null?null:
                        (addList.get(26).getCountyScore()==0?0:30)
                                +(addList.get(27).getCountyScore()==0?0:30)
                                +(addList.get(28).getCountyScore()==0?0:40)
                                +(addList.get(29).getCountyScore()==0?0:50);
                p16 = addList.get(26).getCityScore()==null?null:
                        (addList.get(26).getCityScore()==0?0:30)
                                +(addList.get(27).getCityScore()==0?0:30)
                                +(addList.get(28).getCityScore()==0?0:40)
                                +(addList.get(29).getCityScore()==0?0:50);
                p26 = addList.get(26).getProvinceScore()==null?null:
                        (addList.get(26).getProvinceScore()==0?0:30)
                                +(addList.get(27).getProvinceScore()==0?0:30)
                                +(addList.get(28).getProvinceScore()==0?0:40)
                                +(addList.get(29).getProvinceScore()==0?0:50);
                addList.set(25,new AssessScore("P6分值","分","p6",p6,p16,p26));
                p7 = addList.get(31).getCountyScore()==null?null:
                        (addList.get(31).getCountyScore()==0?0:30)
                                +(addList.get(32).getCountyScore()==0?0:30)
                                +(addList.get(33).getCountyScore()==0?0:40)
                                +(addList.get(34).getCountyScore()==0?0:50);
                p17 = addList.get(31).getCityScore()==null?null:
                        (addList.get(31).getCityScore()==0?0:30)
                                +(addList.get(32).getCityScore()==0?0:30)
                                +(addList.get(33).getCityScore()==0?0:40)
                                +(addList.get(34).getCityScore()==0?0:50);
                p27 = addList.get(31).getProvinceScore()==null?null:
                        (addList.get(31).getProvinceScore()==0?0:30)
                                +(addList.get(32).getProvinceScore()==0?0:30)
                                +(addList.get(33).getProvinceScore()==0?0:40)
                                +(addList.get(34).getProvinceScore()==0?0:50);
                addList.set(30,new AssessScore("P7分值","分","p7",p7,p17,p27));
                p8 = addList.get(36).getCountyScore();
                p18 = addList.get(36).getCityScore();
                p28 = addList.get(36).getProvinceScore();
                addList.set(35,new AssessScore("P8分值","分","p8",p8,p18,p28));
                p9 = addList.get(40).getCountyScore();
                p19 = addList.get(40).getCityScore();
                p29 = addList.get(40).getProvinceScore();
                addList.set(39,new AssessScore("P9分值","分","p9",p9,p19,p29));
                exportList.add(addList);    //加入内容，和sheet名一一对应
                sheetName.add(l+". "+manage.getOrgName());  //sheet名
            }
            List<List<List<String>>> list = new ArrayList<>();
            //把内容转换成String类型
            for(int i=0; i<exportList.size(); i++){
                List<List<String>> sheetList = new ArrayList<>();
                for(int j=0; j<exportList.get(i).size(); j++){
                    AssessScore temp = exportList.get(i).get(j);
                    List<String> scoreList = new ArrayList<>();
                    scoreList.add(temp.getName());
                    scoreList.add(temp.getMeansure());
                    if(!temp.getName().equals("P6分值")&&!temp.getName().equals("P7分值")&&(temp.getP().equals("p6")||temp.getP().equals("p7"))){
                        scoreList.add(temp.getCountyScore() == null ? "" : temp.getCountyScore()==1 ? "是":"否");
                        scoreList.add(temp.getCityScore() == null ? "" : temp.getCityScore()==1 ? "是":"否");
                        scoreList.add(temp.getProvinceScore() == null ? "" : temp.getProvinceScore()==1 ? "是":"否");
                    }else {
                        scoreList.add(temp.getCountyScore() == null ? "" : temp.getCountyScore().toString());
                        scoreList.add(temp.getCityScore() == null ? "" : temp.getCityScore().toString());
                        scoreList.add(temp.getProvinceScore() == null ? "" : temp.getProvinceScore().toString());
                    }
                    sheetList.add(scoreList);
                }
                list.add(sheetList);
            }
            //创建EXCEL表格
            HSSFWorkbook workbook = new HSSFWorkbook();
            List<Integer> widths = new ArrayList<>();   //列宽
            widths.add(103*256);
            widths.add(14*256);
            widths.add(14*256);
            widths.add(14*256);
            widths.add(14*256);
            //创建sheet
            for(int i=0; i<sheetName.size(); i++){
                HSSFSheet sheet = workbook.createSheet(sheetName.get(i));   //sheet名
                createTitle(workbook,sheet,tableTitle,widths);     //表头
                createValue(workbook,sheet,list.get(i));           //内容
            }
            workbook.write(out);
            out.flush();
            out.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"文件下载出错");
        }
    }

    //导出公示
    public void exportPublic(String[] ids, OutputStream out){
        // 下载文件的默认名称
        String filename = null;
        try {
            //要导出的数据
            List<AssessManage> exportList = new ArrayList<>();
            //sheet名称
            List<String> sheetName = new ArrayList<>();
            //表头
            List<String> tableTitle = new ArrayList<>();
            tableTitle.add("考核年度");
            tableTitle.add("辖区市");
            tableTitle.add("辖区县");
            tableTitle.add("单位名称");
            tableTitle.add("评价分值");
            //获取数据
            for(int l=0; l<ids.length; l++) {
                String id = ids[l];
                AssessManage manage = manageDao.selectByPrimaryKey(id);  //获取考核总分
                exportList.add(manage);
            }

            sheetName.add("总列表");
            List<List<String>> list = new ArrayList<>();    //实际内容
            //把内容转换成String类型
            for(int i=0; i<exportList.size(); i++) {
                List<String> sheetList = new ArrayList<>();
                AssessManage temp = exportList.get(i);
                sheetList.add(temp.getYear().toString());
                sheetList.add(temp.getCity());
                sheetList.add(temp.getCounty());
                sheetList.add(temp.getOrgName());
                sheetList.add(temp.getCityScore().toString());
                list.add(sheetList);
            }
            //创建EXCEL表格
            HSSFWorkbook workbook = new HSSFWorkbook();
            List<Integer> widths = new ArrayList<>();   //列宽
            widths.add(25*256);
            widths.add(25*256);
            widths.add(25*256);
            widths.add(25*256);
            widths.add(25*256);
            //创建sheet
            for(int i=0; i<sheetName.size(); i++){
                HSSFSheet sheet = workbook.createSheet(sheetName.get(i));   //sheet名
                createTitle(workbook,sheet,tableTitle,widths);     //表头
                createValue(workbook,sheet,list);           //内容


            }
            workbook.write(out);
            out.flush();
            out.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"文件下载出错");
        }
    }

    //创建表头
    public void createTitle(HSSFWorkbook workbook, HSSFSheet sheet,List<String> tableTitles,List<Integer> widths){
        HSSFRow row = sheet.createRow(0);   //创建第一行
        for(int i=0; i<tableTitles.size(); i++){
            HSSFCell cell = row.createCell(i);  //创建列
            cell.setCellValue(tableTitles.get(i));  //设置值
            sheet.setColumnWidth(i,widths.get(i));  //设置列宽
        }
    }

    //创建内容
    public void createValue(HSSFWorkbook workbook,HSSFSheet sheet,List<List<String>> erportList){
        for(int i=0; i<erportList.size(); i++){
            HSSFRow row = sheet.createRow(i+1);   //创建第行
            for(int j=0; j<erportList.get(i).size(); j++){
                HSSFCell cell = row.createCell(j);  //创建列
                cell.setCellValue(erportList.get(i).get(j));  //设置值
            }
        }
    }
}
