package com.wjc.assess.controller;


import com.alibaba.fastjson.JSON;
import com.wjc.assess.entity.AssessManage;
import com.wjc.assess.entity.User;
import com.wjc.assess.service.ExportService;
import com.wjc.assess.utils.controller.MessageHelp;
import com.wjc.assess.utils.controller.dto.CommonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 导出报告
 */
//所有后台都用/api路径
@RestController
@RequestMapping("/api/Export")
public class ExportController extends BaseController{

    @Autowired
    ExportService exportService;

    //导出报表
    @RequestMapping("/exportReport")
    public Object exportReport(String[] ids,HttpServletRequest httpServletRequest, HttpServletResponse response){
        //获取请求对象
//        CommonRequest request = getCommonRequest(httpServletRequest);
//        List<String> ids = JSON.parseArray(request.getBody().toString(), String.class);

        exportService.exportReport(ids,response);
        return MessageHelp.Result(true);
    }

    //导出报表
    @RequestMapping("/exportPublic")
    public Object exportPublic(String[] ids,HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception{
        //获取请求对象
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/octet-stream");
        // 下载文件的默认名称
        String filename = new String("公示情况.xls".getBytes("UTF-8"),"iso-8859-1");
        response.setHeader("Content-Disposition", "attachment;filename="+filename);

        OutputStream os = response.getOutputStream();
        exportService.exportPublic(ids,os);
        return MessageHelp.Result(true);
    }

}
