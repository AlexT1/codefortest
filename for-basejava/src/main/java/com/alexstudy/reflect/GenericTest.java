package com.alexstudy.reflect;

import com.alexstudy.collectiontest.Gerbil;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author AlexTong
 * @ClassName GenericTest
 * @Description TODO()
 * @date 2018/7/3 17:44:43
 */
public class GenericTest {

    public static SimpleDateFormat formatDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 字符串转换Date格式类型
     * @param date
     * @param formatStr
     * @return
     */
    public static String getFormatString(Date date,String formatStr){
        formatDateStr = new SimpleDateFormat(formatStr);
        String resultDate = "";
        if(null==date){
            return resultDate;
        }
        resultDate = formatDateStr.format(date);
        return resultDate;
    }
    /**
     * 格式化日期
     * @param date
     * @return
     */
    public static String getFormatDateByStr(Date date){
        String resultDate = "";
        try {
            return formatDateStr.format(date);
        } catch (Exception e) {
            return resultDate;
        }
    }

    /**
     * 日期格式化Date格式类型
     * @param date
     * @param formatStr
     * @return
     */
    public static Date getFormatTurnDate(Date date,String formatStr){
        formatDateStr = new SimpleDateFormat(formatStr);
        Date resultDate = null;
        try {
            resultDate = sdf.parse(formatDateStr.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    /**
     * 字符串转换Date格式类型
     * @param date
     * @param formatStr
     * @return
     */
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
        return resultDate;
    }

    public static void main(String[] args){
        String slash = "haxt1_201803091420057543232";
        String last = slash.contains("_") ? slash.substring(slash.indexOf("_")+1) : slash;
        System.out.println("-------" + last);
        Date date = new Date();
       // System.out.println("----" + formatDate.format(new Date()));
    //    System.out.println(date);
        System.out.println("=========="+getFormatDateByStr(date));
//        System.out.println("----------"+getFormatString(date,"yyyy-MM-dd"));

//        System.out.println("&&"+getFormatDateByStr(new Date()));
//        System.out.println("---"+getFormatTurnDate(new Date(),"yyyy-MM-dd"));
 //       System.out.println("{}" + getFormatDate(sdf.format(new Date()),"yyyy-MM-dd") );
        System.out.println(sdf.format(new Date()));
        System.out.println(getFormatDate(sdf.format(new Date()), "yyyy-MM-dd"));
        ArrayList<Gerbil> gerList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Gerbil gerbil = new Gerbil(i);
            gerList.add(gerbil);
        }
        for (Gerbil gerbil: gerList) {
            gerbil.hop();
        }
    }
}
