package com.ies.kentucky.admin.service;

import java.util.List;

import com.ies.kentucky.admin.domain.AccountDomain;

public interface AccountService {

	public boolean createAccount(AccountDomain account);
	
	public String getRegSuccMailBody(AccountDomain uAccount);
	
	public boolean sendRegSuccEmail(String to, String subject, String body);
	
	//public List<AccountDomain> getAllAccounts();
	
	public List<AccountDomain> getByAccType(String accountType);
	
	public boolean isUniqueEmail(String email);
	
	public List<AccountDomain> getEmpsByAccType(String accType);
	
	public AccountDomain getAccountByEmpId(String empId);
	
	public AccountDomain deleteAccById(String empId);
	
	public AccountDomain activeAccount(String accountId);
	
	public List<String> getTypesOfAccounts();
}
