package com.wjc.assess.controller;

import com.alibaba.fastjson.JSON;
import com.wjc.assess.entity.AssessTargetManage;
import com.wjc.assess.entity.User;
import com.wjc.assess.service.TargetManageService;
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
 * 指标管理
 */
//所有后台都用/api路径
@RestController
@RequestMapping("/api/TargetManage")
public class TargetManageController extends BaseController{
    @Autowired
    TargetManageService targetManageService;

    @PostMapping("/getList")
    //查询
    public Object getList(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        AssessTargetManage targetManage = JSON.parseObject(request.getBody().toString(),AssessTargetManage.class);

        int page = request.getPage();
        int rows = request.getRows();
        ReturnList result = targetManageService.getList2(targetManage,page,rows);

        return MessageHelp.Result(result);
    }

    @PostMapping("/add")
    //创建
    public Object add(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessTargetManage targetManage = JSON.parseObject(request.getBody().toString(),AssessTargetManage.class);
        targetManageService.add(targetManage,user);
        return MessageHelp.Result(true);
    }

    @PostMapping("/update")
    //修改
    public Object update(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

//        AssessTargetManage targetManage = JSON.parseObject(request.getBody().toString(),AssessTargetManage.class);
//        List<AssessTargetManage> list = (List<AssessTargetManage>)request.getBody();
//        targetManageService.update(list,user);
        return MessageHelp.Result(true);
    }

    @PostMapping("/delete")
    //删除
    public Object delete(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        List<String> ids = JSON.parseArray(request.getBody().toString(), String.class);
        targetManageService.delete(ids,user);
        return MessageHelp.Result(true);
    }

    @PostMapping("/get")
    //查看
    public Object get(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        String id = (String)request.getBody();
        AssessTargetManage result = targetManageService.get(id);
        return MessageHelp.Result(result);
    }

    @PostMapping("/usingTarget")
    //指标启用
    public Object usingTarget(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        List<String> ids = JSON.parseArray(request.getBody().toString(), String.class);
        targetManageService.usingTarget(ids,user);
        return MessageHelp.Result(true);
    }

    @PostMapping("/unUsingTarget")
    //指标停用
    public Object unUsingTarget(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        List<String> ids = JSON.parseArray(request.getBody().toString(), String.class);
        targetManageService.unUsingTarget(ids,user);
        return MessageHelp.Result(true);
    }

    //获取维度列表
    @PostMapping("/dimensionList")
    public Object dimensionList(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        String id = (String)request.getBody();
        ReturnList result = targetManageService.dimensionList(id);

        return MessageHelp.Result(result);
    }

    //删除维度
    @PostMapping("/dimensionDelete")
    public Object dimensionDelete(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        List<String> ids = JSON.parseArray(request.getBody().toString(), String.class);
        targetManageService.dimensionDelete(ids,user);
        return MessageHelp.Result(true);
    }
}
