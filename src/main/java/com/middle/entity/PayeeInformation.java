package com.middle.entity;

/**
 * @program: insurance
 * @description: 领款人信息
 * @author: Mr.Wang
 * @create: 2019-05-05 16:07
 **/
public class PayeeInformation {
    //客户类型
    public String customerType;
    //客户性质
    public String customerNature;
    //开户银行类别
    public String bankType;
    //银行区域
    public String bankRegion;
    //卡户银行支行名称
    public String bankBranchName;
    //联行号
    public String lineNumber;
    //银行户名
    public String bankAccountName;
    //确认银行账号
    public String bankAccountNameAgain;
    //证件类型
    public String idType;
    //证件号码
    public String idNumber;
    //电话
    public String telephone;
    //社保个人编码
    public String personID;
    //银行附言
    public String bankNode;
    //赔款说明
    public String calimNote;
    //账号类型
    public String FeeField1;
    //备用2
    public String Feefield2;

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerNature() {
        return customerNature;
    }

    public void setCustomerNature(String customerNature) {
        this.customerNature = customerNature;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getBankRegion() {
        return bankRegion;
    }

    public void setBankRegion(String bankRegion) {
        this.bankRegion = bankRegion;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNameAgain() {
        return bankAccountNameAgain;
    }

    public void setBankAccountNameAgain(String bankAccountNameAgain) {
        this.bankAccountNameAgain = bankAccountNameAgain;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getBankNode() {
        return bankNode;
    }

    public void setBankNode(String bankNode) {
        this.bankNode = bankNode;
    }

    public String getCalimNote() {
        return calimNote;
    }

    public void setCalimNote(String calimNote) {
        this.calimNote = calimNote;
    }

    public String getFeeField1() {
        return FeeField1;
    }

    public void setFeeField1(String feeField1) {
        FeeField1 = feeField1;
    }

    public String getFeefield2() {
        return Feefield2;
    }

    public void setFeefield2(String feefield2) {
        Feefield2 = feefield2;
    }
}
