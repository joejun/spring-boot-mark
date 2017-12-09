package com.generate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_bank_account")
@Entity
public class BankAccount {
    @Id
    private String id;

    private String cardNo;

    private String cardType;

    private String cardNoSuf;

    private String bankCode;

    private String orgBankCode;

    private String validDate;

    private String certificateType;

    private String certificateNo;

    private String bankAccountName;

    private String phone;

    private String bankVarSeq;

    private String bankAgNo;

    private String perEntFlag;

    private String cvv2;

    private String reserve;

    private String status;

    private String createdBy;

    private Date createdAt;

    private String updatedBy;

    private Date updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getCardNoSuf() {
        return cardNoSuf;
    }

    public void setCardNoSuf(String cardNoSuf) {
        this.cardNoSuf = cardNoSuf == null ? null : cardNoSuf.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getOrgBankCode() {
        return orgBankCode;
    }

    public void setOrgBankCode(String orgBankCode) {
        this.orgBankCode = orgBankCode == null ? null : orgBankCode.trim();
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate == null ? null : validDate.trim();
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType == null ? null : certificateType.trim();
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo == null ? null : certificateNo.trim();
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName == null ? null : bankAccountName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBankVarSeq() {
        return bankVarSeq;
    }

    public void setBankVarSeq(String bankVarSeq) {
        this.bankVarSeq = bankVarSeq == null ? null : bankVarSeq.trim();
    }

    public String getBankAgNo() {
        return bankAgNo;
    }

    public void setBankAgNo(String bankAgNo) {
        this.bankAgNo = bankAgNo == null ? null : bankAgNo.trim();
    }

    public String getPerEntFlag() {
        return perEntFlag;
    }

    public void setPerEntFlag(String perEntFlag) {
        this.perEntFlag = perEntFlag == null ? null : perEntFlag.trim();
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2 == null ? null : cvv2.trim();
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}