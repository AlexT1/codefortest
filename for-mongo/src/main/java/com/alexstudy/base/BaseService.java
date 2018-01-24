package com.alexstudy.base;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AlexTong
 * @ClassName BaseService
 * @Description TODO()
 * @date 2018/1/18 10:28:04
 */
public class BaseService {


    public static void main(String[] args) {
        Map<String, Integer> addMap = new HashMap<String,Integer>();
        addMap.put("test1",2);
        addMap.put("test2",3);
        addMap.put("test3",4);
        Map<String, Integer> addMap2 = new HashMap<String,Integer>();
        addMap2.put("test2",3);
        addMap2.put("test3",4);
        ResultBean resultBean = new ResultBean();
        resultBean.setCalls(addMap);
        System.out.println(addMap.entrySet().size());
        resultBean.setNets(addMap2);
        System.out.println(resultBean.getNets().size());
        System.out.println(resultBean.getNets().get("test3"));
        String result = "{\"calls\":{},\"nets\":{}}";
        result = JSON.toJSONString(resultBean);
        String[] ts = result.split(",");
        System.out.println(result + "length " + result.split(",").length + " 01 : " + ts[0]
         + "02  :" + ts[3]);

    }
}
class ResultBean {
    private Map<String, Integer> calls;

    private Map<String, Integer> nets;

    public Map<String, Integer> getCalls() {
        return calls;
    }

    public void setCalls(Map<String, Integer> calls) {
        this.calls = calls;
    }

    public Map<String, Integer> getNets() {
        return nets;
    }

    public void setNets(Map<String, Integer> nets) {
        this.nets = nets;
    }
}