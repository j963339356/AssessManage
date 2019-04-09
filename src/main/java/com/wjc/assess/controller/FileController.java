package com.wjc.assess.controller;


import com.wjc.assess.Enum.ExceptionEnum;
import com.wjc.assess.Exception.CustomException;
import com.wjc.assess.dao.EvaluateReportManageMapper;
import com.wjc.assess.entity.EvaluateReportManage;
import com.wjc.assess.service.FileService;
import com.wjc.assess.utils.controller.MessageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * 文件服务
 */
@RestController
@RequestMapping("/api/File")
public class FileController extends BaseController{

    @Autowired
    EvaluateReportManageMapper dao;

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    //文件上传
    public Object upload(@RequestParam("file") MultipartFile multipartFile){
        String fileName = fileService.upload(multipartFile);
        return MessageHelp.Result(fileName);
    }

    @GetMapping("/download")
    //下载
    public Object download(String ids, HttpServletResponse response){
        fileService.download(ids,response);
        return MessageHelp.Result(true);
    }

    @GetMapping("/delete")
    //文件删除
    public Object delete(String ids){
        fileService.delete(ids);
        return MessageHelp.Result("删除成功");
    }
}
