package com.alexstudy.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AlexTong
 * @ClassName TestForObjectMap
 * @Description TODO()
 * @date 2018/5/30 17:29:30
 */
public class TestForObjectMap {
    public  static Map<String,Integer> feeCodeRank = new  HashMap<String,Integer>();
    private static Map<SourceType , FeeType> specifyRepayRelation = new HashMap<SourceType , FeeType>();
    static {
        feeCodeRank.put("8001", 1);
        feeCodeRank.put("5003", 2);
        feeCodeRank.put("5002", 3);
        feeCodeRank.put("5001", 4);
        feeCodeRank.put("1002", 5); //		INTEREST("1002", "利息"),
        feeCodeRank.put("1001", 6);



        specifyRepayRelation.put(SourceType.FEE_BREAKS_OVERDUE, FeeType.OVERDUE_SERVICE_FEE);
        specifyRepayRelation.put(SourceType.FEE_BREAKS_PENALTY, FeeType.OVERDUE_PENALTY);


//		BREAKS_SERVICE_FEE_SUM("7002", "累计已减免逾期手续费"),
//		BREAKS_PENALTY_AMT_SUM("7003", "累计已减免逾期违约金");

//		CAPITAL("1001", "本金"),
//		SERVICE_FEE("5001", "分期手续费"),
//		OVERDUE_SERVICE_FEE("5002", "逾期手续费"),
//		OVERDUE_PENALTY("5003", "逾期违约金"),
    }
    public static void main(String[] args) {
        System.out.println("--------");
        for(SourceType sourceType: specifyRepayRelation.keySet()){
            System.out.println("======================");
            FeeType feeType = specifyRepayRelation.get(sourceType);
            System.out.println("source type :" + sourceType + " fee type :" + feeType);
        }
        for(String key: feeCodeRank.keySet()){
            System.out.println("======================");
            Integer param = feeCodeRank.get(key);
            System.out.println("source key :" + key + " param :" + param);
        }
    }

}
