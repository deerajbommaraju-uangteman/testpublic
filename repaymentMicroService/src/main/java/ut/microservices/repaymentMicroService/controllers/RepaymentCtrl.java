package ut.microservices.repaymentmicroservice.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ut.microservices.repaymentmicroservice.dto.CustomerRepaymentHomePageDTO;
import ut.microservices.repaymentmicroservice.dto.GenerateVaDTO;
import ut.microservices.repaymentmicroservice.services.RepaymentService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class RepaymentCtrl {

  @Autowired
	private RepaymentService repaymentService;

  
  @PostMapping(value = "/postLoginDetails")
  public @ResponseBody CustomerRepaymentHomePageDTO postCustomerLogin(@RequestBody HashMap<String, String> param) throws Exception{
      return repaymentService.postCustomerLogin(param);    
	}
    
  @PostMapping("/makeLoanRepayment")
  public @ResponseBody GenerateVaDTO makeLoanRepayment(@RequestBody HashMap<String, String> userdata) throws Exception{
    return repaymentService.makeLoanRepayment(userdata);
  }
  
  @GetMapping(path = "/getRepaymentData/{VaNumber}")
  public @ResponseBody String loanDataForReconcile(@PathVariable String VaNumber) throws Exception {
    return repaymentService.loanDataForReconcile(VaNumber);
  }



}