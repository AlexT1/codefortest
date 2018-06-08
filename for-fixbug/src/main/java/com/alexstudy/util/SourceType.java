package com.alexstudy.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AlexTong
 * @ClassName SourceType
 * @Description TODO()
 * @date 2018/5/30 17:42:01
 */
public enum SourceType {
    NORMAL_DEDUCT("01","正常扣款"),
    EXCESSIVE("02","溢缴"),
    COMPANY_ACCOUNT_PAY("03", "对公还款"),
    FEE_BREAKS_OVERDUE("04","减免逾期服务费"),
    FEE_BREAKS_PENALTY("06","减免逾期违约金"),
    REAY_TIME_DEDUCT("05","实时划扣"),
    RETURN_SERVICE_FEE("07","退还服务费"),
    RETURN_EXCESSIVE("08","溢缴退回"),
    RISK_SETTLEMENT("09","风险性结清减免");

    private static final Map<String, SourceType> enumConstants = new HashMap<String, SourceType>();
    private String value;
    private String display;

    private SourceType(String value, String display) {
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
        for (SourceType c : SourceType.values()) {
            enumConstants.put(c.getValue(), c);
        }
    }

    public static SourceType parse2Enum(String value) {
        return enumConstants.get(value);
    }

    public String getDesc(){
        return this.display+"["+this.value+"]";
    }


    public static boolean isFeeBreanks(SourceType  sourceType){
        return sourceType == SourceType.FEE_BREAKS_OVERDUE
                || sourceType == SourceType.FEE_BREAKS_PENALTY;
    }
}
