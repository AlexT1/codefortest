package com.alexstudy.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AlexTong
 * @ClassName GoalAmtData
 * @Description TODO()
 * @date 2018/6/21 16:31:59
 */
public class GoalAmtData {


    private Integer pk;

    private String contractNo;

    private String billCode;

    private Integer period;

    private String feeCode;

    private String feeName;

    private Integer version;

    private boolean repay =false;//本次是否做过还款

    public boolean isRepay() {
        return repay;
    }



    private BigDecimal feeAmount = BigDecimal.ZERO;

    private BigDecimal  orignFinishAmount = BigDecimal.ZERO;  //已还金额【快照】

    private BigDecimal goalAmount = BigDecimal.ZERO;    //

    private BigDecimal finishAmount = BigDecimal.ZERO;  //本次已还金额

    private List<OffsetData> offsetDateList = new ArrayList<OffsetData>();

    public boolean isFinish() {
        return goalAmount.compareTo(finishAmount) == 0;
    }

    public synchronized BigDecimal addAmount(BigDecimal addAmount, String sourceNo, SourceType sourceType) {
        BigDecimal couldAddAmount = getLeftAmount();
        addAmount = couldAddAmount.compareTo(addAmount) > 0 ? addAmount : couldAddAmount;
        if(addAmount.compareTo(BigDecimal.ZERO)>0){
            this.finishAmount = this.finishAmount.add(addAmount);
            this.offsetDateList.add(new OffsetData(sourceNo, addAmount, sourceType));
            this.repay = true;
        }

        return addAmount;
    }

    public BigDecimal getLeftAmount() {
        return goalAmount.subtract(finishAmount);
    }

    public BigDecimal getFinishAmount() {
        return finishAmount;
    }

    public GoalAmtData(BillFeeDtl billDetail) {
        this.contractNo = billDetail.getContractNo();
        this.billCode = billDetail.getBillCode();
        this.period = billDetail.getCurrPeriod();
        this.feeCode = billDetail.getFeeCode();
        this.feeName = billDetail.getFeeName();
        this.feeAmount = billDetail.getCurrReceiveAmt();
        this.goalAmount = billDetail.getCurrReceiveAmt().subtract(billDetail.getCurrReceiptAmt());
        this.orignFinishAmount = billDetail.getCurrReceiptAmt();
        this.version = billDetail.getVersion();
        this.pk = billDetail.getId();
    }


    public static List<GoalAmtData> build(List<BillFeeDtl> billDetailList){
        List<GoalAmtData>  goalAmtList = new ArrayList<GoalAmtData>();
        for(BillFeeDtl billDetail :  billDetailList){
            GoalAmtData goalAmtData = new GoalAmtData(billDetail);
            goalAmtList.add(goalAmtData);
        }
        return goalAmtList;
    }


    public BigDecimal getOrignFinishAmount() {
        return orignFinishAmount;
    }

    public List<OffsetData> getOffsetDateList() {
        return offsetDateList;
    }

    public String getContractNo() {
        return contractNo;
    }

    public Integer getPeriod() {
        return period;
    }

    public Integer getPk() {
        return pk;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public String getFeeName() {
        return feeName;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public BigDecimal getAllFinishAmount() {
        return finishAmount.add(orignFinishAmount);
    }

    public String getBillCode() {
        return billCode;
    }


    public Integer getVersion() {
        return version;
    }



    public class OffsetData {
        private String sourceNo;
        private BigDecimal amount;
        private SourceType sourceType;

        public OffsetData(String sourceNo, BigDecimal amount, SourceType sourceType) {
            super();
            this.sourceNo = sourceNo;
            this.amount = amount;
            this.sourceType = sourceType;
        }

        public String getSourceNo() {
            return sourceNo;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public SourceType getSourceType() {
            return sourceType;
        }

        @Override
        public String toString() {
            return "OffsetData [sourceNo=" + sourceNo + ", amount=" + amount + ", sourceType=" + sourceType + "]";
        }



    }



    @Override
    public String toString() {
        return "GoalAmtData [pk=" + pk + ", contractNo=" + contractNo + ", billCode=" + billCode + ", period=" + period
                + ", feeCode=" + feeCode + ", feeName=" + feeName + ", version=" + version + ", repay=" + repay
                + ", feeAmount=" + feeAmount + ", orignFinishAmount=" + orignFinishAmount + ", goalAmount=" + goalAmount
                + ", finishAmount=" + finishAmount + ", offsetDateList=" + offsetDateList + "]";
    }


}
