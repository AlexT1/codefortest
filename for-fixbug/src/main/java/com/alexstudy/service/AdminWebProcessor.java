package com.alexstudy.service;

import com.alexstudy.dao.ResultInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author AlexTong
 * @ClassName AdminWebProcessor
 * @Description TODO()
 * @date 2018/2/7 14:52:03
 */
public class AdminWebProcessor {
    private static final Logger logger = Logger.getLogger(AdminWebProcessor.class);
    private static final String ADMINWEB_USER = "ADMINWEB_USER_";
    private static final Long LIVETIME = 60*30L;
    @Autowired
    RedisService redisService;

    public String put(JSONObject param){
        Long userId = param.getLong("user_id");
        String userInfo = param.getString("user_info");
        ResultInfo rs = new ResultInfo();
        if(userId==null || StringUtils.isEmpty(userInfo)){
            logger.error("参数错误");
            rs.setResult_code(2501);
            rs.setResult_detail("参数错误");
            return JSON.toJSONString(rs);
        }
        String key = ADMINWEB_USER+userId;
        redisService.set(key , userInfo,LIVETIME);
        rs.setResult_code(0);
        rs.setResult_detail("success");
        return JSON.toJSONString(rs);
    }

    public String get(JSONObject param){
        Long userId = param.getLong("user_id");
        String key = ADMINWEB_USER+userId;
        ResultInfo  rs = new ResultInfo();
        String user = redisService.get(key);
        rs.setResult_code(0);
        rs.setResult_detail("success");
        rs.setResult_data(user);
        return JSON.toJSONString(rs);
    }

    public String delete(JSONObject param){
        Long userId = param.getLong("user_id");
        String key = ADMINWEB_USER+userId;
        ResultInfo  rs = new ResultInfo();
        long isDel = redisService.del(key);
        rs.setResult_code(0);
        rs.setResult_detail("success");
        return JSON.toJSONString(rs);
    }
}
