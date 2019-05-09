package com.middle.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @program: insurance
 * @description: 就诊结算信息
 * @author: Mr.Wang
 * @create: 2019-05-05 16:26
 **/
@ExcelTarget("MedResult")
public class MedResult {

    //流水账号
    @Excel(name="流水账号")
    public String transRefGUID;
    //定点机构医疗编码
    @Excel(name="定点机构医疗编码")
    public String hospitalCode;
    //住院登记号
    @Excel(name="定点机构医疗编码")
    public String clinicSerialNum;
    //统筹区编码
    @Excel(name="统筹区编码")
    public String senderCode;
    //票据号
    @Excel(name="票据号")
    public String receiptNum;
    //入院日期
    @Excel(name = "入院日期", exportFormat = "yyyy-MM-dd HH:mm:ss")
    public String inpatientDate;
    //入院诊断疾病编码
    @Excel(name="入院诊断疾病编码")
    public String inpatientDiagnosisDiseaseCode;
    //入院诊断疾病名称
    @Excel(name="入院诊断疾病编码")
    public String inpatientDiagnosisDiseaseName;
    //出院日期
   /* @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")*/

    public String DischargeDate;
    //出院原因
    @Excel(name="出院原因")
    public String dischargeReason;
    //出院疾病主要诊断编码
    @Excel(name="出院疾病主要诊断编码")
    public String disChargeCheifDiagnosis;
    //出院疾病主要诊断名称
    @Excel(name="出院疾病主要诊断名称")
    public String dischargeCheifDiagnosisName;
    //科室代码
    @Excel(name="科室代码")
    public String departmentCode;
    //科室名称
    @Excel(name="科室名称")
    public String depatmentName;
    //床位号
    @Excel(name="床位号")
    public String sickbedNum;
    //医生编号
    @Excel(name="医生编号")
    public String doctorCode;
    //医生姓名
    @Excel(name="医生姓名")
    public String doctorName;
    //医院内部住院号
    @Excel(name="医院内部住院号")
    public String clinicNum;
    //医疗费总额
    @Excel(name="医疗费总额")
    public String medicalPaymentTotalAmount;
    //农和补偿金额（统筹）
    @Excel(name="农和补偿金额（统筹）")
    public String planFundBySI;
    //大病补偿金额
    @Excel(name="大病补偿金额")
    public String bigDiseaseCompenFee;
    //农合累计可报费用（统筹）
    @Excel(name="农合累计可报费用（统筹）")
    public String basicMedTotalFeeAdd;
    //大病累计可报费用
    @Excel(name="大病累计可报费用")
    public String standardTotalFeeAdd;
    //农合累计补偿金额（统筹）
    @Excel(name="农合累计补偿金额（统筹）")
    public String planFundBySIAdd;
    //大病累计补偿金额
    @Excel(name="大病累计补偿金额")
    public String bigDiseaseCompenFeeAdd;
    //本次合规医疗费（大病）
    @Excel(name="本次合规医疗费(大病)")
    public String feeField1;
    //本次剔除非合规医疗费(大病)
    @Excel(name="本次剔除非合规医疗费(大病)")
    public String feeField2;
    // 默认为空，如果启用（1-可以重复上传 0-不可以重
    //复上传）

    public String feeFiled3;
    //预留 4
    public String feeFiled4;
    //是否贫困人口（即精准扶贫标志），0-否 1-是
    @Excel(name="是否贫困人口（即精准扶贫标志）")
    public String feeFiled5;
    //预留 6
    public String feeFiled6;
    //本次合规医疗费（农合）
    public String FeeField7;
    //本次剔除非合规医疗费（农合）
    @Excel(name="本次剔除非合规医疗费（农合）")
    public String feeFiled8;
    //计算公式(不能出现”/”符号)

    public String feeFiled9;
    //经办人
    @Excel(name="经办人")
    public String operator;
    //统筹区编码
    public String DistrictCode;
    //医保机构（新农合/医保中心）报销标志（二版新加字段，用来区分医保机构数据是医院及时上传，还是
    // 医保机构非及时报销。）0- 社保/新农合 医院端上传1- 社保/新农合 中心报销
    public String MedicareOfficeApplyFlag;
    //基本医疗（统筹）或大额（大病）标识
    //0/空 - 大病1 - 基本医疗（统筹）
    @Excel(name="基本医疗（统筹）或大额（大病）标识")
    public String basicBigDiseaseFlag;
    //账户支出金额（基本医疗)
    @Excel(name="账户支出金额（基本医疗)")
    public String basicPersonAccount;
    //是否意外伤害（甘肃）0-非意外伤害1-意外伤害
    @Excel(name="是否意外伤害")
    public String accidentCode;
    //是否医院就医（甘肃）0-非医院就医1-医院就医
    @Excel(name="是否医院就医")
    public String hospitalAdvamceCode;
    //补偿类型（甘肃）
    @Excel(name="补偿类型")
    public String compensatioType;
    //结算日期


    public String settleDate;
    //是否新生儿童标识（0/空– 否 1 - 是）
    public String NewBornFlag;
    //出险日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public String ReserveField1;
    //自费费用
    public String  ReserveField2;
    //符合补偿范围费用
    public String ReserveField3;
    //预留字段4
    public String ReserveField4;
    //预留字段5
    public String ReserveField5;
    //预留字段6
    public String ReserveField6;
    //预留字段7
    public String ReserveField7;
    //预留字段8
    public String ReserveField8;

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getReserveField1() {
        return ReserveField1;
    }

    public void setReserveField1(String reserveField1) {
        ReserveField1 = reserveField1;
    }

    public String getTransRefGUID() {
        return transRefGUID;
    }

    public void setTransRefGUID(String transRefGUID) {
        this.transRefGUID = transRefGUID;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public String getClinicSerialNum() {
        return clinicSerialNum;
    }

    public void setClinicSerialNum(String clinicSerialNum) {
        this.clinicSerialNum = clinicSerialNum;
    }

    public String getSenderCode() {
        return senderCode;
    }

    public void setSenderCode(String senderCode) {
        this.senderCode = senderCode;
    }

    public String getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(String receiptNum) {
        this.receiptNum = receiptNum;
    }

    public String getInpatientDiagnosisDiseaseCode() {
        return inpatientDiagnosisDiseaseCode;
    }

    public void setInpatientDiagnosisDiseaseCode(String inpatientDiagnosisDiseaseCode) {
        this.inpatientDiagnosisDiseaseCode = inpatientDiagnosisDiseaseCode;
    }

    public String getInpatientDate() {
        return inpatientDate;
    }

    public void setInpatientDate(String inpatientDate) {
        this.inpatientDate = inpatientDate;
    }

    public String getInpatientDiagnosisDiseaseName() {
        return inpatientDiagnosisDiseaseName;
    }

    public void setInpatientDiagnosisDiseaseName(String inpatientDiagnosisDiseaseName) {
        this.inpatientDiagnosisDiseaseName = inpatientDiagnosisDiseaseName;
    }

    public String getDischargeDate() {
        return DischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        DischargeDate = dischargeDate;
    }

    public String getDischargeReason() {
        return dischargeReason;
    }

    public void setDischargeReason(String dischargeReason) {
        this.dischargeReason = dischargeReason;
    }

    public String getDisChargeCheifDiagnosis() {
        return disChargeCheifDiagnosis;
    }

    public void setDisChargeCheifDiagnosis(String disChargeCheifDiagnosis) {
        this.disChargeCheifDiagnosis = disChargeCheifDiagnosis;
    }

    public String getDischargeCheifDiagnosisName() {
        return dischargeCheifDiagnosisName;
    }

    public void setDischargeCheifDiagnosisName(String dischargeCheifDiagnosisName) {
        this.dischargeCheifDiagnosisName = dischargeCheifDiagnosisName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepatmentName() {
        return depatmentName;
    }

    public void setDepatmentName(String depatmentName) {
        this.depatmentName = depatmentName;
    }

    public String getSickbedNum() {
        return sickbedNum;
    }

    public void setSickbedNum(String sickbedNum) {
        this.sickbedNum = sickbedNum;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getClinicNum() {
        return clinicNum;
    }

    public void setClinicNum(String clinicNum) {
        this.clinicNum = clinicNum;
    }

    public String getMedicalPaymentTotalAmount() {
        return medicalPaymentTotalAmount;
    }

    public void setMedicalPaymentTotalAmount(String medicalPaymentTotalAmount) {
        this.medicalPaymentTotalAmount = medicalPaymentTotalAmount;
    }

    public String getPlanFundBySI() {
        return planFundBySI;
    }

    public void setPlanFundBySI(String planFundBySI) {
        this.planFundBySI = planFundBySI;
    }

    public String getBigDiseaseCompenFee() {
        return bigDiseaseCompenFee;
    }

    public void setBigDiseaseCompenFee(String bigDiseaseCompenFee) {
        this.bigDiseaseCompenFee = bigDiseaseCompenFee;
    }

    public String getBasicMedTotalFeeAdd() {
        return basicMedTotalFeeAdd;
    }

    public void setBasicMedTotalFeeAdd(String basicMedTotalFeeAdd) {
        this.basicMedTotalFeeAdd = basicMedTotalFeeAdd;
    }

    public String getStandardTotalFeeAdd() {
        return standardTotalFeeAdd;
    }

    public void setStandardTotalFeeAdd(String standardTotalFeeAdd) {
        this.standardTotalFeeAdd = standardTotalFeeAdd;
    }

    public String getPlanFundBySIAdd() {
        return planFundBySIAdd;
    }

    public void setPlanFundBySIAdd(String planFundBySIAdd) {
        this.planFundBySIAdd = planFundBySIAdd;
    }

    public String getBigDiseaseCompenFeeAdd() {
        return bigDiseaseCompenFeeAdd;
    }

    public void setBigDiseaseCompenFeeAdd(String bigDiseaseCompenFeeAdd) {
        this.bigDiseaseCompenFeeAdd = bigDiseaseCompenFeeAdd;
    }

    public String getFeeField1() {
        return feeField1;
    }

    public void setFeeField1(String feeField1) {
        this.feeField1 = feeField1;
    }

    public String getFeeField2() {
        return feeField2;
    }

    public void setFeeField2(String feeField2) {
        this.feeField2 = feeField2;
    }

    public String getFeeFiled3() {
        return feeFiled3;
    }

    public void setFeeFiled3(String feeFiled3) {
        this.feeFiled3 = feeFiled3;
    }

    public String getFeeFiled4() {
        return feeFiled4;
    }

    public void setFeeFiled4(String feeFiled4) {
        this.feeFiled4 = feeFiled4;
    }

    public String getFeeFiled5() {
        return feeFiled5;
    }

    public void setFeeFiled5(String feeFiled5) {
        this.feeFiled5 = feeFiled5;
    }

    public String getFeeFiled6() {
        return feeFiled6;
    }

    public void setFeeFiled6(String feeFiled6) {
        this.feeFiled6 = feeFiled6;
    }

    public String getFeeField7() {
        return FeeField7;
    }

    public void setFeeField7(String feeField7) {
        FeeField7 = feeField7;
    }

    public String getFeeFiled8() {
        return feeFiled8;
    }

    public void setFeeFiled8(String feeFiled8) {
        this.feeFiled8 = feeFiled8;
    }

    public String getFeeFiled9() {
        return feeFiled9;
    }

    public void setFeeFiled9(String feeFiled9) {
        this.feeFiled9 = feeFiled9;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDistrictCode() {
        return DistrictCode;
    }

    public void setDistrictCode(String districtCode) {
        DistrictCode = districtCode;
    }

    public String getMedicareOfficeApplyFlag() {
        return MedicareOfficeApplyFlag;
    }

    public void setMedicareOfficeApplyFlag(String medicareOfficeApplyFlag) {
        MedicareOfficeApplyFlag = medicareOfficeApplyFlag;
    }

    public String getBasicBigDiseaseFlag() {
        return basicBigDiseaseFlag;
    }

    public void setBasicBigDiseaseFlag(String basicBigDiseaseFlag) {
        this.basicBigDiseaseFlag = basicBigDiseaseFlag;
    }

    public String getBasicPersonAccount() {
        return basicPersonAccount;
    }

    public void setBasicPersonAccount(String basicPersonAccount) {
        this.basicPersonAccount = basicPersonAccount;
    }

    public String getAccidentCode() {
        return accidentCode;
    }

    public void setAccidentCode(String accidentCode) {
        this.accidentCode = accidentCode;
    }

    public String getHospitalAdvamceCode() {
        return hospitalAdvamceCode;
    }

    public void setHospitalAdvamceCode(String hospitalAdvamceCode) {
        this.hospitalAdvamceCode = hospitalAdvamceCode;
    }

    public String getCompensatioType() {
        return compensatioType;
    }

    public void setCompensatioType(String compensatioType) {
        this.compensatioType = compensatioType;
    }


    public String getNewBornFlag() {
        return NewBornFlag;
    }

    public void setNewBornFlag(String newBornFlag) {
        NewBornFlag = newBornFlag;
    }



    public String getReserveField2() {
        return ReserveField2;
    }

    public void setReserveField2(String reserveField2) {
        ReserveField2 = reserveField2;
    }

    public String getReserveField3() {
        return ReserveField3;
    }

    public void setReserveField3(String reserveField3) {
        ReserveField3 = reserveField3;
    }

    public String getReserveField4() {
        return ReserveField4;
    }

    public void setReserveField4(String reserveField4) {
        ReserveField4 = reserveField4;
    }

    public String getReserveField5() {
        return ReserveField5;
    }

    public void setReserveField5(String reserveField5) {
        ReserveField5 = reserveField5;
    }

    public String getReserveField6() {
        return ReserveField6;
    }

    public void setReserveField6(String reserveField6) {
        ReserveField6 = reserveField6;
    }

    public String getReserveField7() {
        return ReserveField7;
    }

    public void setReserveField7(String reserveField7) {
        ReserveField7 = reserveField7;
    }

    public String getReserveField8() {
        return ReserveField8;
    }

    public void setReserveField8(String reserveField8) {
        ReserveField8 = reserveField8;
    }
}
