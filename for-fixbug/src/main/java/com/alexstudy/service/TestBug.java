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

        String url = "http://113.204.229.162:8025/businessapi/ops/newBusiness/batchNotifyOfflineTransfer/2/xydb5a5f332cc8d1234?appsecret=2GkBLdsW%2F0Zj4fM7ElYRI18zLqtPvf98m8C1i3OiFW7KaWxfugdXjXzGUv5OOrS8&pendingNotifications=[{\"orderNo\":\"PL2018020813461866728770\",\"productNo\":\"6C\",\"notifyName\":\"test\",\"repaymentAt\":\"20180313100000\",\"amount\":\"2410\",\"type\":\"17\",\"pendingReqSn\":\"BN20180316174638823046814\",\"pendingDetails\":[{\"installmentNumber\":\"8\",\"proceedsAmount\":\"2410\"}]}]";

           char[] array =  url.toCharArray();
        for (int i =0; i<array.length; i++) {
            System.out.println(i + "  character :" + array[i]);
        }
//        TestBug testBug = new TestBug();
//        for (String phone:phoneNums){
//            System.out.println(testBug.replace0086(phone));
//        }

    }
}
