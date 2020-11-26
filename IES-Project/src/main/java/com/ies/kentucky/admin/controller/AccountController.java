package com.ies.kentucky.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ies.kentucky.admin.domain.AccountDomain;
import com.ies.kentucky.admin.service.AccountService;
import com.ies.kentucky.constants.AppConstants;
import com.ies.kentucky.props.AppProperties;

@Controller
public class AccountController {

	@Autowired
	private AccountService serv;
	
	@Autowired
	private AppProperties props;
	
	@ModelAttribute
	public void initObjects(Model model) {
		AccountDomain account= new AccountDomain();
		  model.addAttribute(AppConstants.ACC,account);
	}
	
	
	@GetMapping("/home")
	public String loadHomePage(Model model) {
			return AppConstants.HOME_PAGE;
		}
	
	@GetMapping("/account")
	public String loadAcCreationPage(Model model) {
		  return AppConstants.ACCOUNTCREATION_VIEW;
	}
	
	
	@PostMapping("/accountCreation")
	public String handlingCreateBtn(@ModelAttribute(AppConstants.ACC) AccountDomain acc , RedirectAttributes redrct) {
		
		boolean accstatus = serv.createAccount(acc);
		
		if(acc.getAccountId()==null) {
			String creationSucc= props.getMessages().get(AppConstants.ACC_CREATE_SUCC);
			redrct.addFlashAttribute(AppConstants.SUCC_MESSAGE, creationSucc);
		}else {
			String creationFail= props.getMessages().get(AppConstants.ACC_UPDATE_SUCC);
			redrct.addAttribute(AppConstants.FAIL_MESSAGE, creationFail);
		}
		
		
		return AppConstants.ACCOUNT_REDIRECTION;
	}
	
	@GetMapping("/accountredirection")
	public String redirectionMethod(Model model) {
		  return AppConstants.ACCOUNTCREATION_VIEW;
	}
	
	@GetMapping("/uniqueMailCheck")
	public @ResponseBody String isUniqueEmailOrNot(@RequestParam(AppConstants.EMAIL) String email, Model model) {
		
		String response="";
		
		boolean emailstatus = serv.isUniqueEmail(email);
		if(emailstatus) {
			response=AppConstants.UNIQUE_MAIL;
		}else {
			response=AppConstants.DUPLICATE_MAIL;
		}
		return response;
	}
	
	
}
