package com.alexstudy.util;

import java.math.BigDecimal;

/**
 * @author AlexTong
 * @ClassName DetailData
 * @Description TODO()
 * @date 2018/6/25 19:47:36
 */
public class DetailData {
    private String amount;

    private BigDecimal refundCapital;

    private BigDecimal refundInterest;

    private BigDecimal refundCommission;

    private BigDecimal refundOverdue;

    private String periodNumber;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public BigDecimal getRefundCapital() {
        return refundCapital;
    }

    public void setRefundCapital(BigDecimal refundCapital) {
        this.refundCapital = refundCapital;
    }

    public BigDecimal getRefundInterest() {
        return refundInterest;
    }

    public void setRefundInterest(BigDecimal refundInterest) {
        this.refundInterest = refundInterest;
    }

    public BigDecimal getRefundCommission() {
        return refundCommission;
    }

    public void setRefundCommission(BigDecimal refundCommission) {
        this.refundCommission = refundCommission;
    }

    public BigDecimal getRefundOverdue() {
        return refundOverdue;
    }

    public void setRefundOverdue(BigDecimal refundOverdue) {
        this.refundOverdue = refundOverdue;
    }

    public String getPeriodNumber() {
        return periodNumber;
    }

    public void setPeriodNumber(String periodNumber) {
        this.periodNumber = periodNumber;
    }
}
