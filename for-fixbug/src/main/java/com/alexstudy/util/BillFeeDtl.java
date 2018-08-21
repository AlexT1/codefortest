package com.alexstudy.util;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author AlexTong
 * @ClassName BillFeeDtl
 * @Description TODO()
 * @date 2018/6/21 16:33:14
 */
public class BillFeeDtl {
    private Integer id;

    private String billCode;

    private String contractNo;

    private Integer currPeriod;

    private String feeCode;

    private String feeName;

    private BigDecimal currReceiveAmt;

    private BigDecimal currReceiptAmt;

    private String offsetStatus;

    private Date offsetDate;

    private Date feeDate;

    private String remark;

    private String createdUserId;

    private Date createdTime;

    private String updatedUserName;

    private Date updatedTime;

    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode == null ? null : billCode.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public Integer getCurrPeriod() {
        return currPeriod;
    }

    public void setCurrPeriod(Integer currPeriod) {
        this.currPeriod = currPeriod;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode == null ? null : feeCode.trim();
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName == null ? null : feeName.trim();
    }

    public BigDecimal getCurrReceiveAmt() {
        return currReceiveAmt;
    }

    public void setCurrReceiveAmt(BigDecimal currReceiveAmt) {
        this.currReceiveAmt = currReceiveAmt;
    }

    public BigDecimal getCurrReceiptAmt() {
        return currReceiptAmt;
    }

    public void setCurrReceiptAmt(BigDecimal currReceiptAmt) {
        this.currReceiptAmt = currReceiptAmt;
    }

    public String getOffsetStatus() {
        return offsetStatus;
    }

    public void setOffsetStatus(String offsetStatus) {
        this.offsetStatus = offsetStatus == null ? null : offsetStatus.trim();
    }

    public Date getOffsetDate() {
        return offsetDate;
    }

    public void setOffsetDate(Date offsetDate) {
        this.offsetDate = offsetDate;
    }

    public Date getFeeDate() {
        return feeDate;
    }

    public void setFeeDate(Date feeDate) {
        this.feeDate = feeDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId == null ? null : createdUserId.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedUserName() {
        return updatedUserName;
    }

    public void setUpdatedUserName(String updatedUserName) {
        this.updatedUserName = updatedUserName == null ? null : updatedUserName.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
