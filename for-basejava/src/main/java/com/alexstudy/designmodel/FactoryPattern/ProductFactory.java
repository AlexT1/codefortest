package com.alexstudy.designmodel.FactoryPattern;

/**
 * @author AlexTong
 * @ClassName ProductFactory
 * @Description TODO()
 * @date 2018/6/7 13:44:03
 */
public class ProductFactory {
    public ChannelStrategy getChannelStrategy(String channelType){
        if(channelType == null){
            return null;
        }
        if(channelType.equalsIgnoreCase("JinRong")){
            return new JinRong();
        } else if(channelType.equalsIgnoreCase("JinShang")){
            return new JinShang();
        }
        return null;
    }
}
