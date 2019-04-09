package com.wjc.assess.service;


import com.wjc.assess.Enum.ExceptionEnum;
import com.wjc.assess.Exception.CustomException;
import com.wjc.assess.entity.EvaluateReportManage;
import com.wjc.assess.utils.controller.MessageHelp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * 文件管理
 */
@Service
@Transactional  //开启事务
public class FileService {

    //设置文件路径
    private String filePath = "C:\\Users\\xiaofa\\Desktop\\lj\\";

    //上传
    public String upload(MultipartFile multipartFile){
        //获取文件名
        String fileName = multipartFile.getOriginalFilename();
        fileName = UUID.randomUUID().toString()+fileName;
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        try {
            //保存文件
            multipartFile.transferTo(new File(filePath+fileName));
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"上传文件出错");
        }
    }

    //下载
    public void download(String fileName, HttpServletResponse response){
        if (fileName != null) {
            File file = new File(filePath , fileName);
            if (file.exists()) {
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fileName = fileName.substring(36);
                    fileName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
                    response.setContentType("application/octet-stream");// 二进制流
                    response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"文件下载出错");
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    //删除
    public Boolean delete(String fileName){
        if (fileName != null) {
            File file = new File(filePath,fileName);
            if (file.exists()) {
                if (file.delete()) {
                    return true;
                } else {
                    throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"删除失败");
                }
            } else {
                throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"文件不存在！");
            }
        }
        return false;
    }

}
