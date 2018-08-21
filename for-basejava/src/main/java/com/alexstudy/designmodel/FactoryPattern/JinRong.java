package com.alexstudy.designmodel.FactoryPattern;

import com.alexstudy.util.FeeType;
import com.alexstudy.util.SourceType;

import java.util.Map;

/**
 * @author AlexTong
 * @ClassName JinRong
 * @Description TODO()
 * @date 2018/6/8 17:02:34
 */
public class JinRong implements ChannelStrategy {
    public Map<SourceType,FeeType> setChannelRepayOrder() {
        System.out.println("JinRong setChannelRepayOrder");
        return null;
    }
    public Map<String,Integer> setChannelRankSequence(){
        System.out.println("JinRong setChannelRankSequence");
        return null;
    }
}
