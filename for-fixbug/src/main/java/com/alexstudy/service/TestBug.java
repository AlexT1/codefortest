package com.alexstudy.service;

import org.apache.commons.lang.StringUtils;

/**
 * @author AlexTong
 * @ClassName TestBug
 * @Description TODO()
 * @date 2018/1/30 10:30:58
 */
public class TestBug {
    public String replace0086(String phoneNum) {
        if (StringUtils.isNotEmpty(phoneNum) && phoneNum.startsWith("0086")) {
            return phoneNum.replaceFirst("0086", "");
        }else if (StringUtils.isNotEmpty(phoneNum) && phoneNum.startsWith("+86")) {
            return phoneNum.replaceFirst("\\+86", "");
        }else if (StringUtils.isNotEmpty(phoneNum) && phoneNum.startsWith("86")) {
            return phoneNum.replaceFirst("86", "");
        }
        return phoneNum;
    }
    public static void main(String[] args){
        String[] phoneNums = {"13243254364","+8613244567834","8613467892456","008613467890863"};
        TestBug testBug = new TestBug();
        for (String phone:phoneNums){
            System.out.println(testBug.replace0086(phone));
        }

    }
}
