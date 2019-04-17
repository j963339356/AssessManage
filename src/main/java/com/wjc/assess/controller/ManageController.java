package com.wjc.assess.controller;

import com.alibaba.fastjson.JSON;
import com.wjc.assess.dto.ManageDto;
import com.wjc.assess.entity.AssessManage;
import com.wjc.assess.entity.User;
import com.wjc.assess.service.ManageService;
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
 * 考核管理
 */
//所有后台都用/api路径
@RestController
@RequestMapping("/api/Manage")
public class ManageController extends BaseController{

    @Autowired
    ManageService manageService;

    @PostMapping("/getList")
    //查询
    public Object getList(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);

        int page = request.getPage();
        int rows = request.getRows();
        ReturnList result = manageService.getList(manage,page,rows);

        return MessageHelp.Result(result);
    }

    @PostMapping("/provinceNoticeList")
    //省级公示信息查询
    public Object provinceNoticeList(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        User user = getUser(httpServletRequest);

        int page = request.getPage();
        int rows = request.getRows();
        ReturnList result = manageService.noticeList(manage,page,rows,1);
        return MessageHelp.Result(result);
    }

    @PostMapping("/cityNoticeList")
    //市级公示信息查询
    public Object cityNoticeList(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        User user = getUser(httpServletRequest);

        int page = request.getPage();
        int rows = request.getRows();
        ReturnList result = manageService.noticeList(manage,page,rows,2);
        return MessageHelp.Result(result);
    }

    @PostMapping("/cityReportList")
    //市级已公示列表
    public Object cityReportList(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        User user = getUser(httpServletRequest);

        int page = request.getPage();
        int rows = request.getRows();
        ReturnList result = manageService.cityReportList(manage,page,rows);
        return MessageHelp.Result(result);
    }

    @PostMapping("/add")
    //创建
    public Object add(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        ManageDto manageDto = JSON.parseObject(request.getBody().toString(),ManageDto.class);
        manageService.add(manageDto,user);
        return MessageHelp.Result(true);
    }

    @PostMapping("/countyReport")
    //县级上报
    public Object countyReport(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        ManageDto manageDto = JSON.parseObject(request.getBody().toString(),ManageDto.class);
        manageService.countyReport(manageDto,user);
        return MessageHelp.Result(true);
    }

    @PostMapping("/cityReport")
    //市级上报
    public Object cityReport(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        List<String> ids = JSON.parseArray(request.getBody().toString(), String.class);
        manageService.cityReport(ids,user);
        return MessageHelp.Result(true);
    }

    //公示
    @PostMapping("/Publicity")
    public Object publicity(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        List<String> ids = JSON.parseArray(request.getBody().toString(), String.class);
        manageService.publicity(ids,user);
        return MessageHelp.Result(true);
    }

    //市级上报删除县级考核信息
    @PostMapping("/deleteCounty")
    public Object deleteCounty(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        List<String> ids = JSON.parseArray(request.getBody().toString(), String.class);
        manageService.deleteCounty(ids,user);
        return MessageHelp.Result(true);
    }

    /**   * 工作项*     */

    @PostMapping("/waittaskList")
    //工作项待处理列表
    public Object waittaskList(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        User user = getUser(httpServletRequest);

        int page = request.getPage();
        int rows = request.getRows();
        ReturnList result = manageService.waittaskList(manage,page,rows,user);

        return MessageHelp.Result(result);
    }

    @PostMapping("/cityAssess")
    //市级核定
    public Object cityAssess(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        ManageDto manageDto = JSON.parseObject(request.getBody().toString(),ManageDto.class);
        manageService.cityAssess(manageDto,user);
        return MessageHelp.Result(true);
    }

    @PostMapping("/provinceAssess")
    //省级核定
    public Object provinceAssess(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        ManageDto manageDto = JSON.parseObject(request.getBody().toString(),ManageDto.class);
        manageService.provinceAssess(manageDto,user);
        return MessageHelp.Result(true);
    }

    @PostMapping("/cityBack")
    //市级退回到省级
    public Object cityBack(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        manageService.cityBack(manage,user);
        return MessageHelp.Result(true);
    }

    @PostMapping("/provinceBack")
    //市级退回到省级
    public Object provinceBack(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        User user = getUser(httpServletRequest);

        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);
        manageService.provinceBack(manage,user);
        return MessageHelp.Result(true);
    }
}
