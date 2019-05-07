package com.middle.service.impl;

import com.middle.controller.webService.printClient;
import com.middle.entity.IsSdml;
import com.middle.entity.Islljg;
import com.middle.entity.MedResult;
import com.middle.service.UploadDataService;
import com.middle.utils.FactoryUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-04-27 14:08
 **/
@Service
public class UploadDataServiceImpl implements UploadDataService {
    public static int num = 0;
    private static MedResult medResult = null;
    public String getData(IsSdml isSdml) {
        medResult = FactoryUtils.getMedResult();
        String result = null;
    /*    try {*/
        //将需要导出的数据放入导出的对象中。
        medResult.setAccidentCode("qaa");
        //判断是否接收到所有主题的数据
        result = this.setResult();

       /* } catch (Exception e) {
        }*/
        return result;
    }

    @Override
    public String getData(Islljg islljg) {
        medResult = FactoryUtils.getMedResult();
        String result = null;
        /*try {*/
        //将需要导出的数据放入导出的对象中。
        medResult.setBasicBigDiseaseFlag("bbb");
        //判断是否接收到所有主题的数据
        result = this.setResult();

       /* } catch (Exception e) {

        }*/
        return result;
    }

    public String setResult() {
        num++;
        if (num == 2) {
            //拼装字符串
            String XMLStr = "<?xml version='1.0'?>\n" +
                    "<UploadMedResult_Request>\n" +
                    "<head>\n" +
                    "<StandardVersionCode>v1.0</StandardVersionCode>\n" +
                    "<MaxRecord>" + medResult.getAccidentCode() + "</MaxRecord>\n" +
                    "<TransRefGUID>aad21ae9-0b45-4794-8598-27b774ee5651</TransRefGUID>\n" +
                    "<TransactionCode>H210</TransactionCode>\n" +
                    "<DefaultCurrencyCode>1</DefaultCurrencyCode>\n" +
                    "<MessageId>cc4c8853-82f8-4565-ac71-fd4ce2d4edc5</MessageId>\n" +
                    "<CorrelationId>" + medResult.getBasicBigDiseaseFlag() + "</CorrelationId>\n" +
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
                    "<StaffInformation><ID>210101198001010014</ID>\n" +
                    "<HHouseholdName> 张 三010</HHouseholdName>\n" +
                    "<Gender>1</Gender>\n" +
                    "<Nation>01</Nation>\n" +
                    "<Birthday>1987-10-19</Birthday>\n" +
                    "<HouseholdAttribute>1</HouseholdAttribute>\n" +
                    "<Town_or_Village_Num> 陵水 区 </Town_or_Village_Num>\n" +
                    "<Birthplace> 陵 水 区</Birthplace>\n" +
                    "<MaritalStatus>2</MaritalStatus>\n" +
                    "<HealthState>30</HealthState>\n" +
                    "<NewBorn_Flag>0</NewBorn_Flag>\n" +
                    "<NrcID>nrcId001</NrcID>\n" +
                    "<PersonalID>1000025699</PersonalID>\n" +
                    "<ZipCode>110179</ZipCode>\n" +
                    "<Telephone>15904064400</Telephone>\n" +
                    "<WorkUnit>陵水区</WorkUnit>\n" +
                    "<DistrictCode>431101</DistrictCode>\n" +
                    "<DistrictName> 陵水区</DistrictName>\n" +
                    "<InsuranceType>3H</InsuranceType>\n" +
                    "<MedPersonType>51</MedPersonType>\n" +
                    "<InsurancePolicy>PWBT201343110000000002</InsurancePolicy>\n" +
                    "<InsurPo_BeginDate>2013-01-01 00:00:00</InsurPo_BeginDate>\n" +
                    "<InsurPo_EndDate>2013-12-31 59:59:59</InsurPo_EndDate>\n" +
                    "<Year>2013</Year>\n" +
                    "<FamilyCode>0707</FamilyCode>\n" +
                    "<HouseholdCode></HouseholdCode>\n" +
                    "<HHouseholdID>210101198001010014</HHouseholdID>\n" +
                    "<GroupNum>0101</GroupNum>\n" +
                    "<FamilyAmount>2</FamilyAmount>\n" +
                    "<AgriculturalAmount>2</AgriculturalAmount>\n" +
                    "<HomeAddress> 陵水区 </HomeAddress>\n" +
                    "<Name> 张 三010</Name>\n" +
                    "<FamilyRelations>1</FamilyRelations>\n" +
                    "</StaffInformation><PayeeInformation>\n" +
                    "<CustomerType>01</CustomerType>\n" +
                    "<CustomerNature>1</CustomerNature>\n" +
                    "<BankType>RCB</BankType>\n" +
                    "<BankRegion>4203</BankRegion>\n" +
                    "<BankBranchName>湖北竹山农村商业银行得胜支行</BankBranchName>\n" +
                    "<LineNumber>402539440199</LineNumber>\n" +
                    "<BankAccountName>储志莲 </BankAccountName>\n" +
                    "<BankAccountNameAgain> 储 志 莲</BankAccountNameAgain>\n" +
                    "<BankAccount>81010000153529900</BankAccount>\n" +
                    "<BankAccountAgain>81010000153529900</BankAccountAgain>\n" +
                    "<IDType>1</IDType>\n" +
                    "<IDNumber>422624194811260028</IDNumber>\n" +
                    "<Telephone>13797867807</Telephone>\n" +
                    "<PersonalID>1000025699</PersonalID>\n" +
                    "<FeeField1></FeeField1>\n" +
                    "<FeeField2></FeeField2>\n" +
                    "</PayeeInformation>\n" +
                    "<MedResultList>\n" +
                    "<MedResult>\n" +
                    "<TransRefGUID>0000-20140515085314-841</TransRefGUID>\n" +
                    "<HospitalCode>226900</HospitalCode>\n" +
                    "<ClinicSerialNum>AKC190-1000025699</ClinicSerialNum>\n" +
                    "<SenderCode>431101</SenderCode>\n" +
                    "<ReceiptNum>AAE072-1000025699</ReceiptNum>\n" +
                    "<MedicalCategory>21</MedicalCategory>\n" +
                    "<InpatientDate>2014-01-17 00:00:00</InpatientDate>\n" +
                    "<InpatientDiagnosisDiseaseCode>I25.101</InpatientDiagnosisDiseaseCode>\n" +
                    "<InpatientDiagnosisDiseaseName> 冠心病</InpatientDiagnosisDiseaseName>\n" +
                    "<Discharge_date>2014-01-27 00:00:00</Discharge_date>\n" +
                    "<Discharge_Reason>9</Discharge_Reason>\n" +
                    "<DischargeCheifDiagnosis>I25.101</DischargeCheifDiagnosis>\n" +
                    "<DischargeCheifDiagnosisName> 冠 心 病</DischargeCheifDiagnosisName>\n" +
                    "<DepartmentCode></DepartmentCode>\n" +
                    "<DepartmentName></DepartmentName>\n" +
                    "<SickbedNum></SickbedNum>\n" +
                    "<DoctorCode></DoctorCode>\n" +
                    "<DoctorName></DoctorName>\n" +
                    "<ClinicNum></ClinicNum>\n" +
                    "<MedicalPaymentTotalAmount>5864.65</MedicalPaymentTotalAmount>\n" +
                    "<PlanFundBySI>2493.24</PlanFundBySI>\n" +
                    "<BigDiseaseCompenFee>424.15</BigDiseaseCompenFee>\n" +
                    "<BasicMedTotalFeeAdd>0.0</BasicMedTotalFeeAdd>\n" +
                    "<StandardTotalFeeAdd>0.0</StandardTotalFeeAdd>\n" +
                    "<PlanFundBySIAdd>0.0</PlanFundBySIAdd>\n" +
                    "<BigDiseaseCompenFeeAdd>0.0</BigDiseaseCompenFeeAdd>\n" +
                    "<FeeField1></FeeField1>\n" +
                    "<FeeField></FeeField>\n" +
                    "<FeeField3>4311810001</FeeField3>\n" +
                    "<FeeField4>4311810088</FeeField4>\n" +
                    "<FeeField5></FeeField5>\n" +
                    "<FeeField6></FeeField6>\n" +
                    "<FeeField7></FeeField7>\n" +
                    "<FeeField8></FeeField8>\n" +
                    "<Formula></Formula>\n" +
                    "<Operator> 周 轶 慧</Operator>\n" +
                    "<DistrictCode>431101</DistrictCode>\n" +
                    "<ReserveField1></ReserveField1>\n" +
                    "<ReserveField2></ReserveField2>\n" +
                    "<ReserveField3></ReserveField3>\n" +
                    "</MedResult>\n" +
                    "</MedResultList>\n" +
                    "</body>\n" +
                    "</UploadMedResult_Request>";
            String result = (new printClient()).print(XMLStr);
            System.out.println(result);
            num = 0;
            medResult = null;
            return "ok";
        }
        return "false";
    }
}
