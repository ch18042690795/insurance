package com.middle.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-05-05 15:30
 * 参合人员基本信息
 **/
@Component
@ExcelTarget("StaffInformation")
public class StaffInformation {
    //身份证号
    @Excel(name="身份证号")
    public String id;
    //户主姓名
    @Excel(name="户主姓名")
    public String hhouseholdName;
    //性别
    @Excel(name="性别")
    public String  gender;
    //民族
    @Excel(name="民族")
    public String  nation;
    //出生日期
    @Excel(name="出生日期" , exportFormat = "yyyy-MM-dd HH:mm:ss")
    public String birthday;
    //出生地
    @Excel(name="出生地")
    public String birthplace;
    //婚姻状况
    @Excel(name="婚姻状况")
    public String maritalStatus;
    //健康状况
    @Excel(name="健康状况")
    public String healthStatus;
    //新生儿标志
    @Excel(name="新生儿标志")
    public String newBornFlag;
    //参合证号
    @Excel(name="参合证号")
    public String nrcID;
    //身份唯一标识
    @Excel(name="身份唯一标识")
    public String personalId;
    //邮政编码
    @Excel(name="邮政编码")
    public String zipCode;
    //联系电话
    @Excel(name="联系电话")
    public String telephone;
    //备用
    public String workUnit;
    //统筹区划编码
    @Excel(name="统筹区划编码")
    public String districtCode;
    //备用
    public String districtName;
    //险种
    @Excel(name="险种")
    public String insuranceType;
    //医疗人员类别
    @Excel(name="医疗人员类别")
    public String medPersonType;
    //保单号
    @Excel(name="保单号")
    public String insurancePolicy;
    //参保开始时间
    public String InsurPoBeginDate;
    //参保终止时间
    public String InsurPoEndDate;
    //备用
    public String year;
    //家庭编码
    @Excel(name="家庭编码")
    public String familyCode;
    //备用
    public String householdCode;
    //备用
    public String hhouseholdId;
    //备用
    public String groupNum;
    //备用
    public String familyAmount;
    //备用
    public String agriculturalAmount;
    //备用
    public String homeAddress;
    //名字
    public String Name;
    //备用
    public String FamilyRelation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHhouseholdName() {
        return hhouseholdName;
    }

    public void setHhouseholdName(String hhouseholdName) {
        this.hhouseholdName = hhouseholdName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getNewBornFlag() {
        return newBornFlag;
    }

    public void setNewBornFlag(String newBornFlag) {
        this.newBornFlag = newBornFlag;
    }

    public String getNrcID() {
        return nrcID;
    }

    public void setNrcID(String nrcID) {
        this.nrcID = nrcID;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getMedPersonType() {
        return medPersonType;
    }

    public void setMedPersonType(String medPersonType) {
        this.medPersonType = medPersonType;
    }

    public String getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(String insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public String getInsurPoBeginDate() {
        return InsurPoBeginDate;
    }

    public void setInsurPoBeginDate(String insurPoBeginDate) {
        InsurPoBeginDate = insurPoBeginDate;
    }

    public String getInsurPoEndDate() {
        return InsurPoEndDate;
    }

    public void setInsurPoEndDate(String insurPoEndDate) {
        InsurPoEndDate = insurPoEndDate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }

    public String getHouseholdCode() {
        return householdCode;
    }

    public void setHouseholdCode(String householdCode) {
        this.householdCode = householdCode;
    }

    public String getHhouseholdId() {
        return hhouseholdId;
    }

    public void setHhouseholdId(String hhouseholdId) {
        this.hhouseholdId = hhouseholdId;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    public String getFamilyAmount() {
        return familyAmount;
    }

    public void setFamilyAmount(String familyAmount) {
        this.familyAmount = familyAmount;
    }

    public String getAgriculturalAmount() {
        return agriculturalAmount;
    }

    public void setAgriculturalAmount(String agriculturalAmount) {
        this.agriculturalAmount = agriculturalAmount;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFamilyRelation() {
        return FamilyRelation;
    }

    public void setFamilyRelation(String familyRelation) {
        FamilyRelation = familyRelation;
    }
}
