package com.alexstudy.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AlexTong
 * @ClassName FeeType
 * @Description TODO()
 * @date 2018/5/30 17:42:36
 */
public enum FeeType {
    CAPITAL("1001", "本金"),
    INTEREST("1002", "利息"),
    MONTH_SERVICE_FEE("1003", "月服务费"),
    SERVICE_FEE("5001", "分期手续费"),
    OVERDUE_SERVICE_FEE("5002", "逾期服务费"),
    OVERDUE_PENALTY("5003", "逾期违约金"),
    BREAKS_SERVICE_FEE_SUM("7002", "累计已减免逾期服务费"),
    BREAKS_PENALTY_AMT_SUM("7003", "累计已减免逾期违约金"),
    RISK_SETTLEMENT("7009", "风险性结清减免"),
    EARLY_CHARGE("8001", "提前还款手续费"),
    RETURN_SERVICE_FEE("9001","退还服务费");
    ;

    private static final Map<String, FeeType> enumConstants = new HashMap<String, FeeType>();
    private String value;
    private String display;

    private FeeType(String value, String display) {
        this.value = value;
        this.display = display;
    }

    /**
     * @return 返回value的值
     */
    public String getValue() {
        return value;
    }

    /**
     * @return 返回display的值
     */
    public String getDisplay() {
        return display;
    }


    static {
        for (FeeType c : FeeType.values()) {
            enumConstants.put(c.getValue(), c);
        }
    }

    public static FeeType parse2Enum(String value) {
        return enumConstants.get(value);
    }


//    public static boolean isFeeBreaks(FeeType feeType){
//    	return feeType == FeeType.BREAKS_PENALTY_AMT_SUM || feeType ==FeeType.BREAKS_SERVICE_FEE_SUM;
//    }

    public static SourceType paserToSouce(String feeCode) {
        FeeType feeType =	parse2Enum(feeCode);
        return feeType==FeeType.BREAKS_PENALTY_AMT_SUM ?SourceType.FEE_BREAKS_PENALTY: SourceType.FEE_BREAKS_OVERDUE;
    }
}
