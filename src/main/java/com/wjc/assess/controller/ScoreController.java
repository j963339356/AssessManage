package com.wjc.assess.controller;

import com.alibaba.fastjson.JSON;
import com.wjc.assess.entity.AssessManage;
import com.wjc.assess.service.ScoreService;
import com.wjc.assess.utils.controller.MessageHelp;
import com.wjc.assess.utils.controller.dto.CommonRequest;
import com.wjc.assess.utils.controller.dto.ReturnList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 分数管理
 */
//所有后台都用/api路径
@RestController
@RequestMapping("/api/Score")
public class ScoreController extends BaseController{
    @Autowired
    ScoreService scoreService;

    @PostMapping("/getList")
    //查询
    public Object getList(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest request = getCommonRequest(httpServletRequest);
        AssessManage manage = JSON.parseObject(request.getBody().toString(),AssessManage.class);

        ReturnList result = scoreService.getList(manage);
        return MessageHelp.Result(result);
    }
}
