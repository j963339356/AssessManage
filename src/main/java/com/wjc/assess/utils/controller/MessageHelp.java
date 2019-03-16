package com.wjc.assess.utils.controller;

import com.alibaba.fastjson.JSON;
import com.wjc.assess.Enum.ExceptionEnum;
import com.wjc.assess.Exception.CustomException;
import com.wjc.assess.utils.controller.dto.CommonRequest;
import com.wjc.assess.utils.controller.dto.CommonResponse;
import com.wjc.assess.utils.controller.dto.ResponseHead;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 传输的json数据辅助类
*/
public class MessageHelp {
    private static final DateFormat dateFormat =new SimpleDateFormat("yyyyMMddHHmmss");

    //创建请求报文
    //创建响应报文
    public static CommonResponse createCommonResponse(String id,String service){
        String time = dateFormat.format(new Date());
        //创建响应头
        ResponseHead head = new ResponseHead();
        head.setId(id);
        head.setService(service);
        head.setStaticCode(0);
        head.setMessage("");
        head.setTime(time);

        CommonResponse response = new CommonResponse();
        response.setResponse(head);

        return response;
    }

    //组装响应报文
    public static <T>CommonResponse Result(T o){
        CommonResponse response = new CommonResponse();
        response.getResponse()
                .setStaticCode(ExceptionEnum.SUCCESS.getCode())
                .setMessage(ExceptionEnum.SUCCESS.getMessage());
        if(response != null){
            response.setBody(o);
        }
        return response;
    }
    public static <T>CommonResponse Result(CommonResponse response,T o){
        if(response != null){
            response.setBody(o);
        }
        return response;
    }

    //读取流数据
    public static CommonRequest getCommonRequest(HttpServletRequest httpRequest){
        CommonRequest request = null;
        try {
            String charEncoding = httpRequest.getCharacterEncoding();
            if(charEncoding == null){
                charEncoding = "UTF-8";
            }
            String httpRequestStr = IOUtils.toString(httpRequest.getInputStream(),"UTF-8");
            httpRequestStr = decode(httpRequestStr);
            request = JSON.parseObject(httpRequestStr,CommonRequest.class);
            //如果creq为空，说明报文不符合格式
            if(request == null){
                throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"数据格式不正确！没有找到数据");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return request;
    }

    //转码，转成json格式
    public static String decode(String httpBody){
        String ret = null;
        try {
            ret = URLDecoder.decode(httpBody,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ret = StringUtils.trim(ret);
        if (ret!=null && ret.length()>0){
            if(ret.charAt(0) == '='){
                ret = ret.substring(1);   //去掉开头的=号
            }
            if(ret.charAt(0) == '"'){
                ret = ret.substring(1);   //去掉开头的"号
            }
            if(ret.charAt(ret.length()-1) == '"'){
                ret = ret.substring(0,ret.length()-1);    //去掉结尾的"
            }
        }
        //去掉\
        ret = ret.replaceAll("\\\\","");
        return ret;
    }

    //创建

}
