package com.wjc.assess.controller;


import com.alibaba.fastjson.JSON;
import com.wjc.assess.dto.AnalyScoreDto;
import com.wjc.assess.dto.AnalysisDto;
import com.wjc.assess.dto.AnalysisWholeDto;
import com.wjc.assess.dto.SituationDto;
import com.wjc.assess.entity.AssessManage;
import com.wjc.assess.entity.User;
import com.wjc.assess.service.AnalysisService;
import com.wjc.assess.utils.controller.MessageHelp;
import com.wjc.assess.utils.controller.dto.CommonRequest;
import com.wjc.assess.utils.controller.dto.ReturnList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 统计管理
 */
//所有后台都用/api路径
@RestController
@RequestMapping("/api/Analysis")
public class AnalysisController extends BaseController{
    @Autowired
    AnalysisService analysisService;

    @PostMapping("/level")
    //评价等级统计
    public Object level(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        List<AnalysisDto> result = analysisService.level(manage,user);
        return MessageHelp.Result(result);
    }

    @PostMapping("/score")
    public Object score(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        List<AnalyScoreDto> result = analysisService.score(manage,user);
        ReturnList returnlist = new ReturnList(result.size(),result);
        return MessageHelp.Result(returnlist);
    }

    @PostMapping("/whole")
    //总体情况评价等级统计
    public Object whole(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        AnalysisWholeDto result = analysisService.whole(manage,user);
        return MessageHelp.Result(result);
    }

    @PostMapping("/wholescore")
    //总体情况评价列表
    public Object wholescore(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        List<AnalyScoreDto> result = analysisService.wholescore(manage,user);
        ReturnList returnlist = new ReturnList(result.size(),result);
        return MessageHelp.Result(returnlist);
    }

    @PostMapping("/gltcqk")
    //行政村公路通畅情况
    public Object gltcqk(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        List<SituationDto> result = analysisService.gltcqk(manage,user);
        ReturnList returnlist = new ReturnList(result.size(),result);
        return MessageHelp.Result(returnlist);
    }

    @PostMapping("/kctcqk")
    //行政村客车通畅情况
    public Object kctcqk(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        List<SituationDto> result = analysisService.kctcqk(manage,user);
        ReturnList returnlist = new ReturnList(result.size(),result);
        return MessageHelp.Result(returnlist);
    }

    @PostMapping("/kcgjhqk")
    //城乡客运公交化情况
    public Object kcgjhqk(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        List<SituationDto> result = analysisService.kcgjhqk(manage,user);
        ReturnList returnlist = new ReturnList(result.size(),result);
        return MessageHelp.Result(returnlist);
    }

    @PostMapping("/kyjqsgqk")
    //城乡客运交通事故死亡情况
    public Object kyjqsgqk(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        List<SituationDto> result = analysisService.kyjqsgqk(manage,user);
        ReturnList returnlist = new ReturnList(result.size(),result);
        return MessageHelp.Result(returnlist);
    }

    @PostMapping("/kyjcssqk")
    //城乡客运基础设施情况
    public Object kyjcssqk(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        List<SituationDto> result = analysisService.kyjcssqk(manage,user);
        ReturnList returnlist = new ReturnList(result.size(),result);
        return MessageHelp.Result(returnlist);
    }

    @PostMapping("/kyxxfwqk")
    //城乡客运信息服务情况
    public Object kyxxfwqk(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        List<SituationDto> result = analysisService.kyxxfwqk(manage,user);
        ReturnList returnlist = new ReturnList(result.size(),result);
        return MessageHelp.Result(returnlist);
    }

    @PostMapping("/kyfzzcqk")
    //城乡客运发展政策情况
    public Object kyfzzcqk(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        List<SituationDto> result = analysisService.kyfzzcqk(manage,user);
        ReturnList returnlist = new ReturnList(result.size(),result);
        return MessageHelp.Result(returnlist);
    }
}
