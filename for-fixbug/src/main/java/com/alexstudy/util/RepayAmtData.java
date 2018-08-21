package com.alexstudy.util;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author AlexTong
 * @ClassName RepayAmtData
 * @Description TODO()
 * @date 2018/6/21 16:34:36
 */
public class RepayAmtData {

    private String contractNo;
    private String sourceNo;
    private SourceType sourceType;
    private BigDecimal initAmount;
    private BigDecimal usedAmount=BigDecimal.ZERO;
    private Date validDate;
    private Integer version ;

    public boolean isFinish() {
        return initAmount.compareTo(usedAmount) == 0;
    }

    public synchronized BigDecimal subAmount(BigDecimal subAmount) {
        BigDecimal noUsedAmount = getNoUsedAmount();
        subAmount = noUsedAmount.compareTo(subAmount) > 0 ? subAmount : noUsedAmount;
        this.usedAmount = this.usedAmount.add(subAmount);
        return subAmount;
    }

    public BigDecimal getNoUsedAmount() {
        return initAmount.subtract(usedAmount);
    }

    public RepayAmtData(String sourceNo, SourceType sourceType ,Date validDate,String contractNo, BigDecimal initAmount , Integer version) {
        super();
        this.sourceNo = sourceNo;
        this.contractNo = contractNo;
        this.initAmount = initAmount;
        this.sourceType = sourceType;
        this.version = version;
        this.validDate =  validDate;
    }

//    public RepayAmtData(TransJournalDTL transJournalDTL){
//        this.sourceNo = transJournalDTL.getBusiReqSegNo();
//        this.contractNo = transJournalDTL.getContractNo();
//        this.initAmount = transJournalDTL.getTransAmount();
//        this.sourceType = SourceType.NORMAL_DEDUCT;
//        this.version = transJournalDTL.getVersion();
//        this.validDate =  transJournalDTL.getTransDate();
//    }
//
//    public RepayAmtData(CompanyAccountPayRegister companyRepay) {
//        this.sourceNo = companyRepay.getRegisterCode();
//        this.contractNo = companyRepay.getContractNo();
//        this.initAmount = companyRepay.getRepayAmount();
//        this.sourceType = SourceType.COMPANY_ACCOUNT_PAY;
//        this.version = companyRepay.getVersion();
//        this.validDate =  companyRepay.getClearDate();
//    }
//
//    public RepayAmtData(FeeBreaksApplyDtl feeBreaksApplyDtl) {
//        this.sourceNo = feeBreaksApplyDtl.getBreaksApplyDtlCode();
//        this.contractNo = feeBreaksApplyDtl.getContractNo();
//        this.initAmount = feeBreaksApplyDtl.getBreaksAmount();
//        this.sourceType =  FeeType.paserToSouce(feeBreaksApplyDtl.getFeeCode());
////		this.version = companyRepay.getVersion();
//        this.validDate =  feeBreaksApplyDtl.getCreatedTime();
//    }
//
//    public RepayAmtData(ExcessivePayInfo excessiveInfo) {
//        this.sourceNo = excessiveInfo.getExcessiveCode();
//        this.sourceType = SourceType.EXCESSIVE;
//        this.validDate = excessiveInfo.getExcessiveValidDate();
//        this.contractNo = excessiveInfo.getContractNo();
//        this.initAmount = excessiveInfo.getExcessiveRemainAmt();
//        this.version = excessiveInfo.getVersion();
//    }

    public RepayAmtData(BillFeeDtl billFeeDtl) {
        this.sourceNo = billFeeDtl.getBillCode();
        this.sourceType = SourceType.RETURN_SERVICE_FEE;
        this.validDate = billFeeDtl.getCreatedTime();
        this.contractNo = billFeeDtl.getContractNo();
        this.initAmount = billFeeDtl.getCurrReceiveAmt().abs();
        this.version = billFeeDtl.getVersion();
    }

    public  void initAgain( ) {
        this.initAmount = getNoUsedAmount();
        this.usedAmount = BigDecimal.ZERO;
    }


    public Date getValidDate() {
        return validDate;
    }

    public BigDecimal getInitAmount() {
        return initAmount;
    }

    public Integer getVersion() {
        return version;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    @Override
    public String toString() {
        return "RepayAmtData [contractNo=" + contractNo + ", sourceNo=" + sourceNo + ", sourceType=" + sourceType
                + ", initAmount=" + initAmount + ", usedAmount=" + usedAmount + "]";
    }



}
