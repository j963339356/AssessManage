package com.wjc.assess.controller;


import com.alibaba.fastjson.JSON;
import com.wjc.assess.entity.EvaluateReportManage;
import com.wjc.assess.entity.User;
import com.wjc.assess.service.ReportService;
import com.wjc.assess.utils.controller.MessageHelp;
import com.wjc.assess.utils.controller.dto.CommonRequest;
import com.wjc.assess.utils.controller.dto.ReturnList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 考核报告管理
 */
//所有后台都用/api路径
@RestController
@RequestMapping("/api/ReportManage")
public class ReportController extends BaseController{

    @Autowired
    ReportService reportService;

    @PostMapping("/getList")
    //查询
    public Object getList(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        EvaluateReportManage reportManage = JSON.parseObject(request.getBody().toString(),EvaluateReportManage.class);

        int page = request.getPage();
        int rows = request.getRows();
        ReturnList result = reportService.getList(reportManage,page,rows);

        return MessageHelp.Result(result);
    }

    @PostMapping("/add")
    //创建
    public Object add(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        EvaluateReportManage reportManage = JSON.parseObject(request.getBody().toString(),EvaluateReportManage.class);
        reportService.add(reportManage,user);
        return MessageHelp.Result(true);
    }

    @PostMapping("/update")
    //修改
    public Object update(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        EvaluateReportManage reportManage = JSON.parseObject(request.getBody().toString(),EvaluateReportManage.class);
        reportService.update(reportManage,user);
        return MessageHelp.Result(true);
    }

    //查看
    @PostMapping("/get")
    public Object get(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        String id = request.getBody().toString();
        return MessageHelp.Result(reportService.get(id,user));
    }

    @PostMapping("/delete")
    //删除
    public Object delete(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        List<String> ids = JSON.parseArray(request.getBody().toString(), String.class);
        reportService.delete(ids,user);
        return MessageHelp.Result(true);
    }

    //删除报告文件
    @GetMapping("/deleteFile")
    public Object deleteFile(String id,String fileName){
        reportService.deleteFile(id,fileName);
        return MessageHelp.Result(true);
    }
}
