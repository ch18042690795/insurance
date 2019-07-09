package com.middle.service.impl;

import com.middle.controller.Kafka.KafkaConfiguration;
import com.middle.controller.webService.printClient;
import com.middle.entity.*;
import com.middle.service.UploadDataService;
import com.middle.utils.ExcelUtils;
import com.middle.utils.FactoryUtils;
import com.middle.utils.poiExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

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
    private static Boolean islljgFlag=false;
    private static Boolean isCbrxxFlag=false;
    private static Boolean isDbspFlag=false;
    private static Boolean isZybcFlag=false;
    //H210三个实体类
    private static MedResult medResult = null;
    private static StaffInformation staffInformation = null;
    private static PayeeInformation payeeInformation = null;
    private static ArrayList list = null;

    public void getData(IsSdml isSdml) {
        medResult = FactoryUtils.getMedResult();
        payeeInformation = FactoryUtils.getPayeeInformation();
        staffInformation = FactoryUtils.getStaffInformation();
    /*    try {*/
        //将需要导出的数据放入导出的对象中。
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
       /* classLists=FactoryUtils.getClassList();
        classLists.add("Islljg");*/
        islljgFlag=true;
        medResult.setFwwdmc(islljg.getFwwdmc()==null?"":islljg.getFwwdmc());
        medResult.setWdjbbh(islljg.getWdjbbh()==null?"":islljg.getWdjbbh());

        System.out.println("Islljg");
        /*try {*/
        //将需要导出的数据放入导出的对象中。
     /*   medResult.setHospitalCode(islljg.getFwwdbh());*/
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

        staffInformation.setId(isCbrxx.getZjhm00()==null?"":isCbrxx.getZjhm00());
        staffInformation.setGender(isCbrxx.getXbie00()==null?"":isCbrxx.getXbie00());
        staffInformation.setBirthday(isCbrxx.getCsrq00()==null?"":isCbrxx.getCsrq00());
        staffInformation.setPersonalId(isCbrxx.getId0000()==null?"":isCbrxx.getId0000());
        staffInformation.setZipCode(isCbrxx.getTxdzhi()==null?"":isCbrxx.getTxdzhi());
        staffInformation.setTelephone(isCbrxx.getDhua00()==null?"":isCbrxx.getDhua00());
        staffInformation.setDistrictCode(isCbrxx.getQhdm00()==null?"":isCbrxx.getQhdm00());
        payeeInformation.setTelephone(isCbrxx.getDhua00()==null?"":isCbrxx.getDhua00());
        medResult.setSenderCode("440500");
        medResult.setDistrictCode("440500");
        /*try {*/
        //将需要导出的数据放入导出的对象中。
        //判断是否接收到所有主题的数据
        isCbrxxFlag=true;
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
        isDbspFlag=true;
        IsGrxx isGrxx = isDbsp.getIsGrxx();
        IsCyxx isCyxx = isDbsp.getIsCyxx();
        IsZyxx isZyxx = isDbsp.getIsZyxx();
        IsZd iszd = isZyxx.getIsZd();
        if(isDbsp!=null){
            if(isDbsp.getIsZysfmx()!=null&&isDbsp.getIsZysfmx().size()>0){
                IsZysfmx isZysfmx = isDbsp.getIsZysfmx().get(0);
                medResult.setReserveField2(isZysfmx.getZfbl00()==null?"":isZysfmx.getZfbl00());

            }

            String pkid = isDbsp.getPkid();
            medResult.setHospitalCode(isDbsp.getFwwdbh()==null?"":isDbsp.getFwwdbh());
            medResult.setBatch(isDbsp.getSbcwpc()==null?"":isDbsp.getSbcwpc());
            if(isDbsp.getJzlx00().equals("本人")){
                medResult.setNewBornFlag("2");
            }
            else{
                medResult.setNewBornFlag("1");
            }

        /*try {*/
            //将需要导出的数据放入导出的对象中。
            medResult.setPkid(pkid);
            if(isGrxx!=null){
                staffInformation.setHhouseholdName(isGrxx.getXming0()==null?"":isGrxx.getXming0());
                staffInformation.setNewBornFlag(isGrxx.getXsetx0()==null?"":isGrxx.getXsetx0());
                payeeInformation.setPersonID(isGrxx.getId0000()==null?"":isGrxx.getId0000());
                staffInformation.setName(isGrxx.getXming0()==null?"":isGrxx.getXming0());
            }
            if(isCyxx!=null){
                medResult.setDischargeDate(isCyxx.getCyrq00()==null?"":isCyxx.getCyrq00());
                medResult.setDischargeCheifDiagnosisName(isCyxx.getCyzd00()==null?"":isCyxx.getCyzd00());
            }
           if(isZyxx!=null){
               medResult.setDepatmentName(isZyxx.getJzks00()==null?"":isZyxx.getJzks00());
               medResult.setSickbedNum(isZyxx.getCwhao0()==null?"":isZyxx.getCwhao0());
               medResult.setMedicalCategory(isZyxx.getJbyblx()==null?"":isZyxx.getJbyblx());
           }
          if(iszd!=null){
              medResult.setInpatientDiagnosisDiseaseCode(iszd.getCszd00()==null?"":iszd.getCszd00());
              medResult.setInpatientDiagnosisDiseaseName(iszd.getZzdjb0()==null?"":iszd.getZzdjb0());
          }
           if(isZyxx!=null){
               medResult.setInpatientDate(isZyxx.getZyrq00()==null?"":isZyxx.getZyrq00());
           }
        }

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
         isZybcFlag=true;
        IsFy isFy = isZybc.getFy();
        IsZj isZj = isZybc.getIsZj();
        if(isFy!=null){
            medResult.setMedicalPaymentTotalAmount(isFy.getYlzfy0()==null?"":isFy.getYlzfy0());
            if (isFy.getSfcetk().equals("是")) {
                medResult.setBigDiseaseCompenFee(isFy.getDbbcfy()==null?"":isFy.getDbbcfy());
            } else {
                medResult.setBigDiseaseCompenFee(isFy.getSjdbbcfy()==null?"":isFy.getSjdbbcfy());
            }

            medResult.setBigDiseaseCompenFeeAdd(isFy.getNddbbcfy()==null?"":isFy.getNddbbcfy());
            medResult.setStandardTotalFeeAdd(isFy.getNrbybtc()==null?"":isFy.getNrbybtc());
        }
        if(isZj!=null){
            payeeInformation.setIdType(isZj.getZjlx00()==null?"":isZj.getZjlx00());
            payeeInformation.setIdNumber(isZj.getZjhm00()==null?"":isZj.getZjhm00());
        }
        medResult.setDischargeReason(isZybc.getLyzt00()==null?"":isZybc.getLyzt00());
        medResult.setClinicSerialNum(isZybc.getZylsh0()==null?"":isZybc.getZylsh0());
        medResult.setReceiptNum(isZybc.getDjlsh0()==null?"":isZybc.getDjlsh0());
        medResult.setYear(isZybc.getSsybnd()==null?"":isZybc.getSsybnd());

        //将需要导出的数据放入导出的对象中。
        //判断是否接收到所有主题的数据
        this.setResult();
    }






    public synchronized void setResult() {



        if (isZybcFlag==true&&isDbspFlag==true&&isCbrxxFlag==true&&islljgFlag==true) {
            String date = new java.text.SimpleDateFormat("yyyyMMddhhmmss").format(new Date()).toString();
            String dateCurrent = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()).toString();
           String transRefGUID="440500"+"-"+ date + "-" + medResult.getHospitalCode() + "-" + medResult.getPkid();
            //拼装字符串
            String XMLStr = "<?xml version='1.0'?>\n" +
                    "<UploadMedResult_Request>\n" +
                    "<head>\n" +
                    "<StandardVersionCode>JKXZX V2.0.0.0</StandardVersionCode>\n" +
                    "<MaxRecord>1</MaxRecord>\n" +
                    "<TransRefGUID>440500-" + date + "-" + medResult.getHospitalCode() + "-" + medResult.getPkid() + "</TransRefGUID>\n" +
                    "<TransactionCode>H210</TransactionCode>\n" +
                    "<DefaultCurrencyCode>01</DefaultCurrencyCode>\n" +
                    "<MessageId>440500"+"-" + date + "-" + medResult.getHospitalCode() + "-" + medResult.getPkid() + "</MessageId>\n" +
                    "<CorrelationId>440500-" + date + "-" + medResult.getHospitalCode() + "-" + medResult.getPkid() + "</CorrelationId>\n" +
                    "<MessageDateTime>" + dateCurrent + "</MessageDateTime>\n" +
                    "<SenderCode>440500</SenderCode><SenderName></SenderName>\n" +
                    "<SenderAddress></SenderAddress>\n" +
                    "<ReceiverCode>440500</ReceiverCode><ReceiverName>\n" +
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
                    "<Nation>" + staffInformation.getNation() + "</Nation>\n" +
                    "<Birthday>" + staffInformation.getBirthday() + "</Birthday>\n" +
                    "<HouseholdAttribute>1</HouseholdAttribute>\n" +
                    "<Town_or_Village_Num></Town_or_Village_Num>\n" +
                    "<Birthplace> </Birthplace>\n" +
                    "<MaritalStatus>2</MaritalStatus>\n" +
                    "<HealthState>30</HealthState>\n" +
                    "<NewBorn_Flag>"+ medResult.getNewBornFlag()+"</NewBorn_Flag>\n" +
                    "<NrcID>" + staffInformation.getPersonalId() + "</NrcID>\n" +
                    "<PersonalID>" + staffInformation.getPersonalId() + "</PersonalID>\n" +
                    "<ZipCode>" + staffInformation.getZipCode() + "</ZipCode>\n" +
                    "<Telephone>" + staffInformation.getTelephone() + "</Telephone>\n" +
                    "<WorkUnit>" + staffInformation.getWorkUnit() + "</WorkUnit>\n" +
                    "<DistrictCode>440500</DistrictCode>\n" +
                    "<DistrictName></DistrictName>\n" +
                    "<InsuranceType>WBR</InsuranceType>\n" +
                    "<MedPersonType>11</MedPersonType>\n" +
                    "<InsurancePolicy>PWBR201944050000956025</InsurancePolicy>\n" +
                    "<InsurPo_BeginDate>" + staffInformation.getInsurPoBeginDate() + "</InsurPo_BeginDate>\n" +
                    "<InsurPo_EndDate>" + staffInformation.getInsurPoEndDate() + "</InsurPo_EndDate>\n" +
                    "<Year>" + staffInformation.getYear() + "</Year>\n" +
                    "<FamilyCode>" + staffInformation.getFamilyCode() + "</FamilyCode>\n" +
                    "<HouseholdCode></HouseholdCode>\n" +
                    "<HHouseholdID>" + staffInformation.getHhouseholdId() + "</HHouseholdID>\n" +
                    "<GroupNum>" + staffInformation.getGroupNum() + "</GroupNum>\n" +
                    "<FamilyAmount>" + staffInformation.getFamilyAmount() + "</FamilyAmount>\n" +
                    "<AgriculturalAmount>" + staffInformation.getAgriculturalAmount() + "</AgriculturalAmount>\n" +
                    "<HomeAddress>" + staffInformation.getHomeAddress() + "</HomeAddress>\n" +
                    "<Name>" + staffInformation.getName() + "</Name>\n" +
                    "<FamilyRelations>1</FamilyRelations>\n" +
                    "</StaffInformation><PayeeInformation>\n" +
                    "<CustomerType>01</CustomerType>\n" +
                    "<CustomerNature>2</CustomerNature>\n" +
                    "<BankType></BankType>\n" +
                    "<BankRegion></BankRegion>\n" +
                    "<BankBranchName>邮政银行汕头分行</BankBranchName>\n" +
                    "<LineNumber></LineNumber>\n" +
                    "<BankAccountName>汕头市社会保险基金管理局（职工医疗）</BankAccountName>\n" +
                    "<BankAccountNameAgain>汕头市社会保险基金管理局（职工医疗）</BankAccountNameAgain>\n" +
                    "<BankAccount>94400701000031896510005</BankAccount>\n" +
                    "<BankAccountAgain>94400701000031896510005</BankAccountAgain>\n" +
                    "<IDType>" + payeeInformation.getIdType() + "</IDType>\n" +
                    "<IDNumber>" + payeeInformation.getIdNumber() + "</IDNumber>\n" +
                    "<Telephone>" + payeeInformation.getTelephone() + "</Telephone>\n" +
                    "<PersonalID>" + payeeInformation.getPersonID() + "</PersonalID>\n" +
                    "<FeeField1></FeeField1>\n" +
                    "<FeeField2></FeeField2>\n" +
                    "</PayeeInformation>\n" +
                    "<MedResultList>\n" +
                    "<MedResult>\n" +
                    "<TransRefGUID>440500-" + date + "-" + medResult.getHospitalCode() + "-" + medResult.getPkid() + "</TransRefGUID>\n" +
                    "<Batch>" + medResult.getBatch() + "</Batch>\n" +
                    "<HospitalCode>" + medResult.getHospitalCode() + "</HospitalCode>\n" +
                    "<ClinicSerialNum>" + medResult.getClinicSerialNum() + "</ClinicSerialNum>\n" +
                    "<SenderCode>440500</SenderCode>\n" +
                    "<ReceiptNum>" + medResult.getReceiptNum() + "</ReceiptNum>\n" +
                    "<MedicalCategory></MedicalCategory>\n" +
                    "<InpatientDate>" + medResult.getInpatientDate() + "</InpatientDate>\n" +
                    "<InpatientDiagnosisDiseaseCode>U9999999</InpatientDiagnosisDiseaseCode>\n" +
                    "<InpatientDiagnosisDiseaseName> " + medResult.getInpatientDiagnosisDiseaseName() + "</InpatientDiagnosisDiseaseName>\n" +
                    "<Discharge_date>" + medResult.getDischargeDate() + "</Discharge_date>\n" +
                    "<Discharge_Reason>" + medResult.getDischargeReason() + "</Discharge_Reason>\n" +
                    "<DischargeCheifDiagnosis>U9999999</DischargeCheifDiagnosis>\n" +
                    "<DischargeCheifDiagnosisName>" + medResult.getDischargeCheifDiagnosisName() + "</DischargeCheifDiagnosisName>\n" +
                    "<DepartmentCode>"+ medResult.getDepartmentCode() + "</DepartmentCode>\n" +
                    "<DepartmentName>" + medResult.getDepatmentName() + "</DepartmentName>\n" +
                    "<SickbedNum>" + medResult.getSickbedNum() + "</SickbedNum>\n" +
                    "<DoctorCode>" + medResult.getDoctorCode() + "</DoctorCode>\n" +
                    "<DoctorName>" + medResult.getDoctorName() + "</DoctorName>\n" +
                    "<ClinicNum></ClinicNum>\n" +
                    "<MedicalPaymentTotalAmount>" + medResult.getMedicalPaymentTotalAmount() + "</MedicalPaymentTotalAmount>\n" +
                    "<PlanFundBySI></PlanFundBySI>\n" +
                    "<BigDiseaseCompenFee>" + medResult.getBigDiseaseCompenFee() + "</BigDiseaseCompenFee>\n" +
                    "<BasicMedTotalFeeAdd></BasicMedTotalFeeAdd>\n" +
                    "<StandardTotalFeeAdd></StandardTotalFeeAdd>\n" +
                    "<PlanFundBySIAdd></PlanFundBySIAdd>\n" +
                    "<BigDiseaseCompenFeeAdd>" + medResult.getBigDiseaseCompenFeeAdd() + "</BigDiseaseCompenFeeAdd>\n" +
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
                    "<DistrictCode>440500</DistrictCode>\n" +
                    "<MedicareOfficeApplyFlag>1" +
                    "</MedicareOfficeApplyFlag>\n" +
                    "<ReserveField1></ReserveField1>\n" +
                    "<ReserveField2></ReserveField2>\n" +
                    "<ReserveField3></ReserveField3>\n" +
                    "</MedResult>\n" +
                    "</MedResultList>\n" +
                    "</body>\n" +
                    "</UploadMedResult_Request>";
            //生成excel
         /*   exportExcels(transRefGUID);*/
            //调用第三方接口

        /*       String result = (new printClient()).print(XMLStr, "http://10.10.1.31:6699/si/services/PiccWSInterface?wsdl");
            System.out.println(result+"---------------------------------");
            String name = new printClient().print(medResult.getPkid(), "http://10.10.1.31:6699/si/services/PiccWSInterface?wsdl");
            System.out.println(name+"---------------------------------");
            KafkaConfiguration.WriteLPZT(medResult.getPkid(), name);
            KafkaConfiguration.getLPZT(medResult.getPkid());*/
            //初始化
            isZybcFlag=false;
            islljgFlag=false;
            isCbrxxFlag=false;
            isDbspFlag=false;

            medResult = null;
            staffInformation = null;
            payeeInformation = null;
        }

    }
}
