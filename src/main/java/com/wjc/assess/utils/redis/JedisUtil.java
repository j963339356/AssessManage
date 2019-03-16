package com.wjc.assess.utils.redis;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wjc.assess.Exception.CustomException;
import com.wjc.assess.Enum.ExceptionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis辅助类
 */
@Component
public class JedisUtil {

    //默认有效时间15分钟
    private long timeout = 15;
    @Autowired
    private RedisTemplate redisTemplate;

    /*****     字符串操作opsForValue   ******/
    public Boolean set(String key,String value){
        try{
            ValueOperations redis = redisTemplate.opsForValue();
            set(key,value,timeout);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException(ExceptionEnum.COMPONENT.getCode(),"redis存储出错");
        }
    }

    //键，值，有效时间（分钟）
    public Boolean set(String key, String value, long l){
        try{
            redisTemplate.opsForValue().set(key,value,l,TimeUnit.MINUTES);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException(ExceptionEnum.COMPONENT.getCode(),"redis存储出错");
        }
    }

    //一次性设置多个<键,值>
    public Boolean set(Map map){
        try{
            redisTemplate.opsForValue().multiSet(map);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException(ExceptionEnum.COMPONENT.getCode(),"redis存储出错");
        }
    }

    //获取值
    public Object get(String key){
        ValueOperations redis = redisTemplate.opsForValue();
        return redis.get(key);
    }

    /*****     hash操作opsForHash   ******/
    //设置键值对
    public Boolean set(String key,Map map){
        try {
            redisTemplate.opsForHash().putAll(key,map);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException(ExceptionEnum.COMPONENT.getCode(),"redis存储出错");
        }
    }

    /*****     List操作opsForList   ******/
    /*****     Set操作opsForSet   ******/
    /*****     有序Set操作opsForZSet   ******/
    /*****     公共操作        ******/
    //获取过期时间
    public long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.MINUTES);
    }
    //获取指定单位的过期时间
    public long getExpire(String key,TimeUnit timeUnit){
        return redisTemplate.getExpire(key,timeUnit);
    }

    //删除指定key
    public Boolean delete(String key){
        return redisTemplate.delete(key);
    }
    //删除多个key
    public long deleteMulte(Collection collection){
        return redisTemplate.delete(collection);
    }

    //检查key是否存在
    public Boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }

    //设置过期时间（分钟）
    public Boolean expire(String key){
        return expire(key,timeout);
    }
    public Boolean expire(String key,long timeout){
        return expire(key,timeout,TimeUnit.MINUTES);
    }
    //设置指定单位的过期时间
    public Boolean expire(String key,long timeout,TimeUnit timeUnit){
        return redisTemplate.expire(key,timeout,timeUnit);
    }
}
