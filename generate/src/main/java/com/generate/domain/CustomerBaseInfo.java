package com.generate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_customer_base_info")
@Entity
public class CustomerBaseInfo {
    @Id
    private String id;

    private String customerNo;

    private String contractNo;

    private String contractName;

    private String orgCode;

    private String gender;

    private String maritalStTpCd;

    private String childrenTpCd;

    private String nationTpCd;

    private String birthPlace;

    private Date birthDate;

    private String highestEduTpCd;

    private String occpStTpCd;

    private String occupation;

    private String companyName;

    private String companyPhone;

    private String companyAddress;

    private String email;

    private String mobile;

    private String phone;

    private String addressType;

    private String address;

    private String residenceTime;

    private String isContactsUploaded;

    private String contractPerson;

    private String reserve;

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

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getMaritalStTpCd() {
        return maritalStTpCd;
    }

    public void setMaritalStTpCd(String maritalStTpCd) {
        this.maritalStTpCd = maritalStTpCd == null ? null : maritalStTpCd.trim();
    }

    public String getChildrenTpCd() {
        return childrenTpCd;
    }

    public void setChildrenTpCd(String childrenTpCd) {
        this.childrenTpCd = childrenTpCd == null ? null : childrenTpCd.trim();
    }

    public String getNationTpCd() {
        return nationTpCd;
    }

    public void setNationTpCd(String nationTpCd) {
        this.nationTpCd = nationTpCd == null ? null : nationTpCd.trim();
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace == null ? null : birthPlace.trim();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getHighestEduTpCd() {
        return highestEduTpCd;
    }

    public void setHighestEduTpCd(String highestEduTpCd) {
        this.highestEduTpCd = highestEduTpCd == null ? null : highestEduTpCd.trim();
    }

    public String getOccpStTpCd() {
        return occpStTpCd;
    }

    public void setOccpStTpCd(String occpStTpCd) {
        this.occpStTpCd = occpStTpCd == null ? null : occpStTpCd.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone == null ? null : companyPhone.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType == null ? null : addressType.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getResidenceTime() {
        return residenceTime;
    }

    public void setResidenceTime(String residenceTime) {
        this.residenceTime = residenceTime == null ? null : residenceTime.trim();
    }

    public String getIsContactsUploaded() {
        return isContactsUploaded;
    }

    public void setIsContactsUploaded(String isContactsUploaded) {
        this.isContactsUploaded = isContactsUploaded == null ? null : isContactsUploaded.trim();
    }

    public String getContractPerson() {
        return contractPerson;
    }

    public void setContractPerson(String contractPerson) {
        this.contractPerson = contractPerson == null ? null : contractPerson.trim();
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
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