package com.alexstudy.designmodel.FactoryPattern;

import com.alexstudy.util.FeeType;
import com.alexstudy.util.SourceType;

import java.util.Map;

/**
 * @author AlexTong
 * @ClassName ChannelStrategy
 * @Description TODO()
 * @date 2018/6/8 16:46:56
 */
public interface ChannelStrategy {
    Map<SourceType,FeeType> setChannelRepayOrder();
    Map<String,Integer> setChannelRankSequence();
}
