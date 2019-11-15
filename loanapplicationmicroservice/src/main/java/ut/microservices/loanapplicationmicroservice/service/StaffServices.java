package ut.microservices.loanapplicationmicroservice.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import ut.microservices.loanapplicationmicroservice.dto.*;
import ut.microservices.loanapplicationmicroservice.model.*;
import ut.microservices.loanapplicationmicroservice.repository.*;

/**
 * StaffServices
 */
@Service
public class StaffServices {

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

    IGenericDAO<ApplicationNotesModel> applicationNotesDAO;
    @Autowired
    public void setApplicationNotesDAO(IGenericDAO<ApplicationNotesModel> DAOToSet) {
        applicationNotesDAO = DAOToSet;
        applicationNotesDAO.setClazz(ApplicationNotesModel.class);
    }


    @Autowired
    private ObjectMapper objectMapper;

    DVServices dvservice;

    public @ResponseBody ResponseDTO<ApplicationDTO> getAvailableLoans() throws Exception {
        List<ApplicationData> LoanApplicationsList = applicationDAO.findValueByColumn("Status", "ST");
        // System.out.println(LoanApplicationsList);
        return this.getResponseBody(LoanApplicationsList);
    }

    public void approvedLoan(String ApplicationID) throws JsonProcessingException {
        ApplicationData applicationData=applicationDAO.findValueByColumn("ApplicationID",ApplicationID).get(0);
        applicationData.setStatus("A");
        applicationDAO.updateOne(applicationData);
        HashMap<String,Object> map=new HashMap<String,Object>();
        map.put("loanAppID", applicationData.getLoanApplicationID());
        map.put("loanAmount",applicationData.getLoanAmount());
        map.put("ApplicationID",applicationData.getApplicationID());
        map.put("loanTenor",applicationData.getLoanDaysLength());
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

      public String staffAddNotes(ApplicationNotesModel applicationNotes) throws Exception {
        String responseTempID = applicationNotesDAO.save(applicationNotes).toString();
        return responseTempID;
    }

    public ResponseDTO<ApplicationNotesDTO> staffViewNotes(String applicationID) throws Exception {
        List<ApplicationNotesModel> ApplicationNotesList = applicationNotesDAO.findValueByColumn("ApplicationID", applicationID);
        
        return getApplicationNotesResponseBody(ApplicationNotesList);
    }

    public ResponseDTO<ApplicationNotesDTO> getApplicationNotesResponseBody(List<ApplicationNotesModel> applicationList) {
        Iterator<ApplicationNotesModel> iterator=applicationList.iterator();
        ResponseDTO<ApplicationNotesDTO> response=new ResponseDTO<ApplicationNotesDTO>();
        List<ApplicationNotesDTO> rows=new LinkedList<ApplicationNotesDTO>();
        int key=0;
        while(iterator.hasNext()){
          key++;
          ApplicationNotesModel application=iterator.next();
          ApplicationNotesDTO availableLoansDTO=new ApplicationNotesDTO();
          availableLoansDTO.setApplicationID(application.getApplicationID());
          availableLoansDTO.setApplicationNotesID(application.getApplicationNotesID());
          availableLoansDTO.setTypeNote(application.getTypeNote());
          availableLoansDTO.setNote(application.getNote());
          availableLoansDTO.setInputBy(application.getInputBy());          
          rows.add(availableLoansDTO);
        }
        response.setRows(rows);
        HashMap<String,String> tableColumns=new HashMap<String,String>();
        tableColumns.put("TypeNote", "Note Type");
        tableColumns.put("Note", "Note");
        tableColumns.put("InputBy", "Input By");
        List<ColumnDTO> columns=new LinkedList<ColumnDTO>();
        for(Map.Entry<String,String> entry : tableColumns.entrySet()){
          ColumnDTO columnDTO=new ColumnDTO();
          columnDTO.setKey(entry.getKey());
          columnDTO.setTitle(entry.getValue());
          columnDTO.setDataIndex(entry.getKey());
          columns.add(columnDTO);
        }
        response.setColumns(columns);
        return response;
      }
}