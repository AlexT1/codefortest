package com.alexstudy.designmodel.FactoryPattern;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author AlexTong
 * @ClassName FactoryPatternDemo
 * @Description TODO()
 * @date 2018/6/8 17:06:49
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();

        //获取 JinRong 的对象，并调用它的 setChannelRankSequence 方法
        ChannelStrategy jinRong = productFactory.getChannelStrategy("JinRong");

        //调用 JinRong 的 setChannelRankSequence 方法
        jinRong.setChannelRankSequence();

        //获取 JinShang 的对象，并调用它的 setChannelRankSequence 方法
        ChannelStrategy jinShang = productFactory.getChannelStrategy("JinShang");

        //调用 JinShang 的 setChannelRankSequence 方法
        jinShang.setChannelRankSequence();

    }
    public static SimpleDateFormat formatDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Date getFormatDate(String date,String formatStr){
        formatDateStr = new SimpleDateFormat(formatStr);
        Date resultDate = null;
        try {
            if(StringUtils.isBlank(date)){
                return resultDate;
            }
            resultDate = formatDateStr.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("result date: " + resultDate);
        return resultDate;
    }
    public static void main2(String[] args) {
        Date curDate = new Date();
        try {
            BigDecimal big = new BigDecimal(54);
            BigDecimal big2 = new BigDecimal(62954.38567).setScale(2,BigDecimal.ROUND_DOWN);
            System.out.println("big2 :  " + big2.subtract(big));
//        System.out.println( "add : " + big.add(big2));
            //System.out.println(1/0);
            System.out.println( "Date before :" + curDate.before(formatDateStr.parse("2018-05-28 00:00:00")));
            System.out.println("Date after :" + curDate.after(formatDateStr.parse("2018-05-28 00:00:00")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String test1 = "-3", test2 = "-1", test3 = "-2", test4 = "0",test5 = "1", test6="2";
        System.out.println( "test1 " + test1.compareTo(test4));
        System.out.println("test2 " + test2.compareTo(test4));
        System.out.println("test3 " + test3.compareTo(test4));
        System.out.println("test5 " + test5.compareTo(test4));
        System.out.println("test4 " + test4.compareTo(test4));
        List<String> stringList = new ArrayList<>();//数据集合
        List<Integer> integerList = new ArrayList<>();//存储remove的位置
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");

        integerList.add(2);
        integerList.add(4);//此处相当于要移除最后一个数据
        System.out.println(stringList);
        for (Integer i :integerList){
            stringList.remove(i);
        }
        stringList.remove("a");
        for (String s :stringList){

            System.out.println(s);
        }
        Date date = new Date();
        String s = "2018-05-10";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String currentDate = df.format(new Date());
        System.out.println( s.compareTo(currentDate));
        BigDecimal big = new BigDecimal(0);
        BigDecimal big2 = new BigDecimal(62954.38567);
        System.out.println( "add : " + big.add(big2));
        DecimalFormat df1 = new DecimalFormat("0.00");
        String str = df1.format(big);
        System.out.println(str);
        BigDecimal bi =  big.setScale(2, BigDecimal.ROUND_DOWN);
        System.out.println("big  :" + big + " bi :" + bi);
        DecimalFormat df2 =new DecimalFormat("#.00");
        String str2 =df2.format(big);
        System.out.println(str2);  //13.15
        Date date2 = getFormatDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "yyyy-MM-dd HH:mm:ss");
        System.out.println("date2 :" + date2);
        System.out.println(new Date());
        String data = null;
        if (data == null ) {
            System.out.println(data.equals(null));
        }
    }

}
