package com.alexstudy.designmodel.FactoryPattern;

import com.alexstudy.util.FeeType;
import com.alexstudy.util.SourceType;

import java.util.Map;

/**
 * @author AlexTong
 * @ClassName JinShang
 * @Description TODO()
 * @date 2018/6/8 17:01:16
 */
public class JinShang implements ChannelStrategy{
   public Map<SourceType,FeeType> setChannelRepayOrder() {
       System.out.println("jinshang setChannelRepayOrder");
       return null;
    }
    public Map<String,Integer> setChannelRankSequence(){
       System.out.println("jinshang setChannelRankSequence");
       return null;
    }
}
