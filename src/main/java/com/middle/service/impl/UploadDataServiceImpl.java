package com.middle.service.impl;

import com.middle.controller.webService.printClient;
import com.middle.entity.*;
import com.middle.service.UploadDataService;
import com.middle.utils.ExcelUtils;
import com.middle.utils.FactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-04-27 14:08
 **/
@Service
public class UploadDataServiceImpl implements UploadDataService {
    @Autowired
    Environment environment;
    //保存主题名称集合,用于判断是否拿到所有的主题数据
    public static Set classLists=null;
    //H210三个实体类
    private static MedResult medResult = null;
    private static StaffInformation staffInformation = null;
    private static PayeeInformation payeeInformation = null;
    private static ArrayList list = null;

    public void getData(IsSdml isSdml) {
        medResult = FactoryUtils.getMedResult();
        payeeInformation = FactoryUtils.getPayeeInformation();
        staffInformation = FactoryUtils.getStaffInformation();
        classLists=FactoryUtils.getClassList();
        classLists.add("IsSdml");
    /*    try {*/
        //将需要导出的数据放入导出的对象中。
        medResult.setAccidentCode("qaa");
        //判断是否接收到所有主题的数据
       this.setResult();

       /* } catch (Exception e) {
        }*/

    }

    @Override
    public void getData(Islljg islljg) {
        medResult = FactoryUtils.getMedResult();
        payeeInformation = FactoryUtils.getPayeeInformation();
        staffInformation = FactoryUtils.getStaffInformation();
        classLists=FactoryUtils.getClassList();
        classLists.add("Islljg");
        /*try {*/
        //将需要导出的数据放入导出的对象中。
        medResult.setHospitalCode(islljg.getFwwdbh());
        //判断是否接收到所有主题的数据
        this.setResult();

       /* } catch (Exception e) {

        }*/

    }

    @Override
    public String getData(IsCbrxx isCbrxx) {
        medResult = FactoryUtils.getMedResult();
        payeeInformation = FactoryUtils.getPayeeInformation();
        staffInformation = FactoryUtils.getStaffInformation();
        String result = null;
        staffInformation.setId(isCbrxx.getZjhm00());
        staffInformation.setGender(isCbrxx.getXbie00());
        staffInformation.setBirthday(isCbrxx.getCsrq00());
        staffInformation.setPersonalId(isCbrxx.getId0000());
        staffInformation.setZipCode(isCbrxx.getTxdzhi());
        staffInformation.setTelephone(isCbrxx.getDhua00());
        staffInformation.setDistrictCode(isCbrxx.getQhdm00());
        payeeInformation.setTelephone(isCbrxx.getDhua00());
        medResult.setSenderCode(isCbrxx.getQhdm00());
        medResult.setDistrictCode(isCbrxx.getQhdm00());
        /*try {*/
        //将需要导出的数据放入导出的对象中。
        //判断是否接收到所有主题的数据
        classLists=FactoryUtils.getClassList();
        classLists.add("IsCbrxx");
       this.setResult();

       /* } catch (Exception e) {

        }*/

        return result;
    }

    @Override
    public void getData(IsDbsp isDbsp) {
        medResult = FactoryUtils.getMedResult();
        payeeInformation = FactoryUtils.getPayeeInformation();
        staffInformation = FactoryUtils.getStaffInformation();
        classLists=FactoryUtils.getClassList();
        classLists.add("IsDbsp");
        IsGrxx isGrxx = isDbsp.getIsGrxx();
        IsCyxx isCyxx = isDbsp.getIsCyxx();
        IsZyxx isZyxx = isDbsp.getIsZyxx();
        IsZysfmx isZysfmx = isDbsp.getIsZysfmx().get(0);
        /*try {*/
        //将需要导出的数据放入导出的对象中。
        medResult.setReserveField2(isZysfmx.getZfbl00());
        staffInformation.setHhouseholdName(isGrxx.getXming0());
        staffInformation.setNewBornFlag(isGrxx.getXsetx0());
        payeeInformation.setPersonID(isGrxx.getId0000());
        medResult.setDischargeDate(isCyxx.getCyrq00());
        medResult.setDisChargeCheifDiagnosis(isCyxx.getCyzd00());
        medResult.setDepatmentName(isZyxx.getJzks00());
        medResult.setSickbedNum(isZyxx.getCwhao0());
        //判断是否接收到所有主题的数据
        this.setResult();

       /* } catch (Exception e) {

        }*/

    }

    @Override
    public void getData(IsZybc isZybc) {
        medResult = FactoryUtils.getMedResult();
        payeeInformation = FactoryUtils.getPayeeInformation();
        staffInformation = FactoryUtils.getStaffInformation();
        classLists=FactoryUtils.getClassList();
        classLists.add("IsZybc");
        IsFy isFy = isZybc.getFy();
        IsZj isZj = isZybc.getIsZj();
        staffInformation.setName(isZybc.getXming0());
        payeeInformation.setIdType(isZj.getZjlx00());
        payeeInformation.setIdNumber(isZj.getZjhm00());
        medResult.setMedicalPaymentTotalAmount(isFy.getYlzfy0());
        /*try {*/
        //将需要导出的数据放入导出的对象中。
        //判断是否接收到所有主题的数据
        this.setResult();

       /* } catch (Exception e) {

        }*/
    }

    @Override
    public void getData(IsDbbcywzt isDbbcywzt) {
        medResult = FactoryUtils.getMedResult();
        payeeInformation = FactoryUtils.getPayeeInformation();
        staffInformation = FactoryUtils.getStaffInformation();
        classLists=FactoryUtils.getClassList();
        classLists.add("IsDbbcywzt");
        /*try {*/
        //将需要导出的数据放入导出的对象中。
        //判断是否接收到所有主题的数据
         this.setResult();

       /* } catch (Exception e) {

        }*/

    }

    @Override
    public void getData(IsCbxxhq isCbxxhq) {
        medResult = FactoryUtils.getMedResult();
        payeeInformation = FactoryUtils.getPayeeInformation();
        staffInformation = FactoryUtils.getStaffInformation();
        classLists=FactoryUtils.getClassList();
        classLists.add("IsCbxxhq");
        //将需要导出的数据放入导出的对象中。
        //判断是否接收到所有主题的数据
       this.setResult();



    }

    @Override
    public void getData(Islpzt islpzt) {
        medResult = FactoryUtils.getMedResult();
        payeeInformation = FactoryUtils.getPayeeInformation();
        staffInformation = FactoryUtils.getStaffInformation();
        classLists=FactoryUtils.getClassList();
        classLists.add("Islpzt");
        medResult.setClinicSerialNum(islpzt.getZylsh0());
        medResult.setReceiptNum(islpzt.getDjlsh0());
            //判断是否接收到所有主题的数据
            this.setResult();


    }

    @Override
    public void getData(IsDbbcywztcx isDbbcywztcx) {
        medResult = FactoryUtils.getMedResult();
        payeeInformation = FactoryUtils.getPayeeInformation();
        staffInformation = FactoryUtils.getStaffInformation();
        classLists=FactoryUtils.getClassList();
        classLists.add("IsDbbcywztcx");
/*        try {*/
            //将需要导出的数据放入导出的对象中。

            //判断是否接收到所有主题的数据

        this.setResult();

      /*  } catch (Exception e) {

        }
*/
    }

    public synchronized void setResult() {

        System.out.println(Integer.valueOf(environment.getProperty("kafka.topic.nums")));

        if (classLists.size() == Integer.valueOf(environment.getProperty("kafka.topic.nums"))) {
            String date = new java.text.SimpleDateFormat("yyyyMMddhhmmss").format(new Date()).toString();
            //拼装字符串
            String XMLStr = "<?xml version='1.0'?>\n" +
                    "<UploadMedResult_Request>\n" +
                    "<head>\n" +
                    "<StandardVersionCode>JKXZX V2.0.0.0</StandardVersionCode>\n" +
                    "<MaxRecord>1</MaxRecord>\n" +
                    "<TransRefGUID>" + medResult.getSenderCode() + "-" + date + "-" + medResult.getHospitalCode() + "-" + medResult.getClinicSerialNum() + "</TransRefGUID>\n" +
                    "<TransactionCode>H210</TransactionCode>\n" +
                    "<DefaultCurrencyCode>1</DefaultCurrencyCode>\n" +
                    "<MessageId>cc4c8853-82f8-4565-ac71-fd4ce2d4edc5</MessageId>\n" +
                    "<CorrelationId>" + medResult.getSenderCode() + "-" + date + "-" + medResult.getHospitalCode() + "-" + medResult.getClinicSerialNum() + "</CorrelationId>\n" +
                    "<MessageDateTime>2014-05-15 08:53:12</MessageDateTime>\n" +
                    "<SenderCode>431101</SenderCode><SenderName></SenderName>\n" +
                    "<SenderAddress></SenderAddress>\n" +
                    "<ReceiverCode>431101</ReceiverCode><ReceiverName>\n" +
                    "</ReceiverName><ReceiverAddress>\n" +
                    "</ReceiverAddress><IntermediaryCode>\n" +
                    "</IntermediaryCode><IntermediaryrName>\n" +
                    "</IntermediaryrName><IntermediaryAddress>\n" +
                    "</IntermediaryAddress>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<StaffInformation><ID>" + staffInformation.getId() + "</ID>\n" +
                    "<HHouseholdName>" + staffInformation.getHhouseholdName() + "</HHouseholdName>\n" +
                    "<Gender>" + staffInformation.getGender() + "</Gender>\n" +
                    "<Nation>01</Nation>\n" +
                    "<Birthday>" + staffInformation.getBirthday() + "</Birthday>\n" +
                    "<HouseholdAttribute>1</HouseholdAttribute>\n" +
                    "<Town_or_Village_Num>  </Town_or_Village_Num>\n" +
                    "<Birthplace> </Birthplace>\n" +
                    "<MaritalStatus>2</MaritalStatus>\n" +
                    "<HealthState>30</HealthState>\n" +
                    "<NewBorn_Flag>" + staffInformation.getNewBornFlag() + "</NewBorn_Flag>\n" +
                    "<NrcID>nrcId001</NrcID>\n" +
                    "<PersonalID>" + staffInformation.getPersonalId() + "</PersonalID>\n" +
                    "<ZipCode>" + staffInformation.getZipCode() + "</ZipCode>\n" +
                    "<Telephone>" + staffInformation.getTelephone() + "</Telephone>\n" +
                    "<WorkUnit></WorkUnit>\n" +
                    "<DistrictCode>" + staffInformation.getDistrictCode() + "</DistrictCode>\n" +
                    "<DistrictName></DistrictName>\n" +
                    "<InsuranceType></InsuranceType>\n" +
                    "<MedPersonType></MedPersonType>\n" +
                    "<InsurancePolicy>" + staffInformation.getInsurancePolicy() + "</InsurancePolicy>\n" +
                    "<InsurPo_BeginDate></InsurPo_BeginDate>\n" +
                    "<InsurPo_EndDate></InsurPo_EndDate>\n" +
                    "<Year></Year>\n" +
                    "<FamilyCode></FamilyCode>\n" +
                    "<HouseholdCode></HouseholdCode>\n" +
                    "<HHouseholdID></HHouseholdID>\n" +
                    "<GroupNum></GroupNum>\n" +
                    "<FamilyAmount></FamilyAmount>\n" +
                    "<AgriculturalAmount></AgriculturalAmount>\n" +
                    "<HomeAddress>  </HomeAddress>\n" +
                    "<Name>" + staffInformation.getName() + "</Name>\n" +
                    "<FamilyRelations>1</FamilyRelations>\n" +
                    "</StaffInformation><PayeeInformation>\n" +
                    "<CustomerType></CustomerType>\n" +
                    "<CustomerNature></CustomerNature>\n" +
                    "<BankType></BankType>\n" +
                    "<BankRegion></BankRegion>\n" +
                    "<BankBranchName></BankBranchName>\n" +
                    "<LineNumber></LineNumber>\n" +
                    "<BankAccountName> </BankAccountName>\n" +
                    "<BankAccountNameAgain> </BankAccountNameAgain>\n" +
                    "<BankAccount></BankAccount>\n" +
                    "<BankAccountAgain></BankAccountAgain>\n" +
                    "<IDType>" + payeeInformation.getIdType() + "</IDType>\n" +
                    "<IDNumber>" + payeeInformation.getIdNumber() + "</IDNumber>\n" +
                    "<Telephone>" + payeeInformation.getTelephone() + "</Telephone>\n" +
                    "<PersonalID>" + payeeInformation.getPersonID() + "</PersonalID>\n" +
                    "<FeeField1></FeeField1>\n" +
                    "<FeeField2></FeeField2>\n" +
                    "</PayeeInformation>\n" +
                    "<MedResultList>\n" +
                    "<MedResult>\n" +
                    "<TransRefGUID>" + medResult.getSenderCode() + "-" + date + "-" + medResult.getHospitalCode() + "-" + medResult.getClinicSerialNum() + "</TransRefGUID>\n" +
                    "<HospitalCode>" + medResult.getHospitalCode() + "</HospitalCode>\n" +
                    "<ClinicSerialNum>" + medResult.getClinicSerialNum() + "</ClinicSerialNum>\n" +
                    "<SenderCode>" + medResult.getSenderCode() + "</SenderCode>\n" +
                    "<ReceiptNum>" + medResult.getReceiptNum() + "</ReceiptNum>\n" +
                    "<MedicalCategory></MedicalCategory>\n" +
                    "<InpatientDate></InpatientDate>\n" +
                    "<InpatientDiagnosisDiseaseCode>" + medResult.getInpatientDiagnosisDiseaseCode() + "</InpatientDiagnosisDiseaseCode>\n" +
                    "<InpatientDiagnosisDiseaseName> " + medResult.getInpatientDiagnosisDiseaseName() + "</InpatientDiagnosisDiseaseName>\n" +
                    "<Discharge_date>" + medResult.getDischargeDate() + "</Discharge_date>\n" +
                    "<Discharge_Reason>" + medResult.getDischargeReason() + "</Discharge_Reason>\n" +
                    "<DischargeCheifDiagnosis>" + medResult.getDisChargeCheifDiagnosis() + "</DischargeCheifDiagnosis>\n" +
                    "<DischargeCheifDiagnosisName>" + medResult.getDischargeCheifDiagnosisName() + "</DischargeCheifDiagnosisName>\n" +
                    "<DepartmentCode></DepartmentCode>\n" +
                    "<DepartmentName>" + medResult.getDepatmentName() + "</DepartmentName>\n" +
                    "<SickbedNum>" + medResult.getSickbedNum() + "</SickbedNum>\n" +
                    "<DoctorCode></DoctorCode>\n" +
                    "<DoctorName></DoctorName>\n" +
                    "<ClinicNum></ClinicNum>\n" +
                    "<MedicalPaymentTotalAmount>" + medResult.getMedicalPaymentTotalAmount() + "</MedicalPaymentTotalAmount>\n" +
                    "<PlanFundBySI></PlanFundBySI>\n" +
                    "<BigDiseaseCompenFee></BigDiseaseCompenFee>\n" +
                    "<BasicMedTotalFeeAdd></BasicMedTotalFeeAdd>\n" +
                    "<StandardTotalFeeAdd></StandardTotalFeeAdd>\n" +
                    "<PlanFundBySIAdd></PlanFundBySIAdd>\n" +
                    "<BigDiseaseCompenFeeAdd></BigDiseaseCompenFeeAdd>\n" +
                    "<FeeField1></FeeField1>\n" +
                    "<FeeField></FeeField>\n" +
                    "<FeeField3></FeeField3>\n" +
                    "<FeeField4></FeeField4>\n" +
                    "<FeeField5></FeeField5>\n" +
                    "<FeeField6></FeeField6>\n" +
                    "<FeeField7></FeeField7>\n" +
                    "<FeeField8></FeeField8>\n" +
                    "<Formula></Formula>\n" +
                    "<Operator></Operator>\n" +
                    "<DistrictCode>" + medResult.getDistrictCode() + "</DistrictCode>\n" +
                    "<ReserveField1></ReserveField1>\n" +
                    "<ReserveField2></ReserveField2>\n" +
                    "<ReserveField3></ReserveField3>\n" +
                    "</MedResult>\n" +
                    "</MedResultList>\n" +
                    "</body>\n" +
                    "</UploadMedResult_Request>";
            //生成excel
            List list = new ArrayList();
            list.add(staffInformation);
            list.add(payeeInformation);
            list.add(medResult);
            ExcelUtils.getDownLoad(list, environment.getProperty("file.location"));
            //调用第三方接口
            String result = (new printClient()).print(XMLStr);
            System.out.println(result);
            //初始化
            classLists.clear();
            medResult = null;
            staffInformation = null;
            payeeInformation = null;
        }

    }
}
