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

@Controller
public class ViewAccountsController {

	@Autowired
	private AccountService serv;
	
	@ModelAttribute
	public void loadAccTypes(Model model) {
		List<String> typesOfAccounts = serv.getTypesOfAccounts();	
		model.addAttribute("types", typesOfAccounts);
		
		  AccountDomain acc=new AccountDomain(); 
		  model.addAttribute("acc",acc);
		 
	}
	
	@GetMapping("/allAcc")
	public String viewAccountsDtls(Model model) {
		
		
		
		
		return "accountsList";
	}
	
	@GetMapping("/getAllAcc")
	public String viewAccountsBtnHandler(@RequestParam("role")String role,Model model) {
		
		List<AccountDomain> allAccounts = serv.getByAccType(role);
		
		model.addAttribute("accounts",allAccounts);
		return "accountsList";
	}
	
	@GetMapping("/editAccount")
	public String editBtnHandler(@RequestParam("accountId") String empId, Model model) {
		
		AccountDomain accountByEmpId = serv.getAccountByEmpId(empId);
		model.addAttribute("acc",accountByEmpId);
		
		return "accountcreation";
		
	}
	

	@GetMapping("/deactivateAccount")
	public String handleDeactiveBtn(@RequestParam("accountId") String accountId, Model model) {
		
	       AccountDomain accountDomain = serv.deleteAccById(accountId);
	       String empRole=accountDomain.getRole();
		model.addAttribute("deleteMsg", "Account Deactivate Successfully");
		
		return "redirect:/getAllAcc?role="+empRole;
	}
	@GetMapping("/activateAccount")
	public String handleActiveBtn(@RequestParam("accountId") String accountId, Model model) {
		AccountDomain activeAccount = serv.activeAccount(accountId);
		String empRole=activeAccount.getRole();
		return "redirect:/getAllAcc?role="+empRole;
	}
}
