package ut.microservices.loanapplicationmicroservice.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import ut.microservices.loanapplicationmicroservice.dto.*;
import ut.microservices.loanapplicationmicroservice.model.*;
import ut.microservices.loanapplicationmicroservice.repository.*;
import ut.microservices.loanapplicationmicroservice.service.*;
/**
 * DVServices
 */
@Service
public class DVServices {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    IGenericDAO<ApplicantData> applicantDAO;
    IGenericDAO<ApplicationData> applicationDAO;

    @Autowired
    public void setApplicantDAO(IGenericDAO<ApplicantData> DAOToSet) {
        applicantDAO = DAOToSet;
        applicantDAO.setClazz(ApplicantData.class);
    }

    @Autowired
    public void setApplicationDAO(IGenericDAO<ApplicationData> DAOToSet) {
        applicationDAO = DAOToSet;
        applicationDAO.setClazz(ApplicationData.class);
    }

    @Autowired
    private ObjectMapper objectMapper;

    public @ResponseBody ResponseDTO<ApplicationDTO> getAvailableLoans() throws Exception {
        List<ApplicationData> LoanApplicationsList = applicationDAO.findValueByColumn("Status", "DV");
        return getResponseBody(LoanApplicationsList);
    }
    
    public @ResponseBody ApplicantData dvEditApplicationPersonalDetails(HashMap<String, String> ApplicationID) throws JsonProcessingException {
        HashMap<String, Object> data = new HashMap<String, Object>();
        // Available Loan state in LoanInvestment table is 'N'
        ApplicationData applicationData = applicationDAO.findValueByColumn("ApplicationID", ApplicationID.get("id")).get(0);
        ApplicantData applicantData=applicantDAO.findValueByColumn("ApplicantID",applicationData.getApplicationApplicantID().toString()).get(0);
        return applicantData;
    }

    public @ResponseBody String dvSubmitApplicationPersonalDetails(ApplicantData applicantData){
        applicantDAO.updateOne(applicantData);
        return "Updated Succesfully";
    }

    public @ResponseBody String dvEditLoanDetails(ApplicantData ApplicationID) throws JsonProcessingException {
        // System.out.println("app::"+ApplicationID);
        // HashMap<String, Object> data = new HashMap<String, Object>();
        // // Available Loan state in LoanInvestment table is 'N'
        // ApplicantData fundingLoansList = applicantDAO.findValueByColumn("ApplicantID", ApplicationID).get(0);
        // System.out.println("data::"+fundingLoansList);
        // data.put("applicantLoanData", objectMapper.writeValueAsString(fundingLoansList));
        // return objectMapper.writeValueAsString(data);
        return "success";
    }
    
    public void approvedLoan(String ApplicationID) throws JsonProcessingException {
        ApplicationData applicationData=applicationDAO.findValueByColumn("ApplicationID",ApplicationID).get(0);
        applicationData.setStatus("ST");
        applicationDAO.updateOne(applicationData);
        HashMap<String,Object> map=new HashMap<String,Object>();
        map.put("loanAppID", applicationData.getLoanApplicationID());
        map.put("loanAmount",applicationData.getLoanAmount());
        map.put("ApplicationID",applicationData.getApplicationID());
        map.put("LoanTenor",applicationData.getLoanDaysLength());
        //kafkaTemplate.send("loanApproved",objectMapper.writeValueAsString(map));
    }
    
    public void rejectedLoan(String ApplicationID) {
        ApplicationData applicationData=applicationDAO.findValueByColumn("ApplicationID",ApplicationID).get(0);
        applicationData.setStatus("T");
        applicationDAO.updateOne(applicationData);
    }

    public ResponseDTO<ApplicationDTO> getResponseBody(List<ApplicationData> applicationList) {
        Iterator<ApplicationData> iterator=applicationList.iterator();
        ResponseDTO<ApplicationDTO> response=new ResponseDTO<ApplicationDTO>();
        List<ApplicationDTO> rows=new LinkedList<ApplicationDTO>();
        int key=0;
        while(iterator.hasNext()){
          key++;
          ApplicationData application=iterator.next();
          ApplicationDTO availableLoansDTO=new ApplicationDTO();
          availableLoansDTO.setApplicationApplicantID(application.getApplicationApplicantID());
          availableLoansDTO.setApplicationID(application.getApplicationID());
          availableLoansDTO.setLoanAmount(application.getLoanAmount());
          availableLoansDTO.setLoanApplicationID(application.getLoanApplicationID());
          availableLoansDTO.setLoanDaysLength(application.getLoanDaysLength());          
          rows.add(availableLoansDTO);
        }
        response.setRows(rows);
        HashMap<String,String> tableColumns=new HashMap<String,String>();
        tableColumns.put("applicationApplicantID", "Applicant ID");
        tableColumns.put("loanApplicationID", "Loan ID");
        tableColumns.put("loanAmount", "Loan Amount");
        tableColumns.put("loanDaysLength", "Loan Tenor");
        tableColumns.put("applicationID", "Action");
        List<ColumnDTO> columns=new LinkedList<ColumnDTO>();
        for(Map.Entry<String,String> entry : tableColumns.entrySet()){
          ColumnDTO columnDTO=new ColumnDTO();
          columnDTO.setKey(entry.getKey());
          columnDTO.setTitle(entry.getValue());
          columnDTO.setDataIndex(entry.getKey());
          columns.add(columnDTO);
        }
        List<ButtonDTO> buttons=new LinkedList<ButtonDTO>();
        ButtonDTO buttonDTO=new ButtonDTO();
        buttonDTO.setTitle("Action");
        buttonDTO.setKey("applicationID");
        buttonDTO.setAction("approveLoan");
        buttons.add(buttonDTO);
        response.setColumns(columns);
        response.setButton(buttons);
        return response;
      }
}