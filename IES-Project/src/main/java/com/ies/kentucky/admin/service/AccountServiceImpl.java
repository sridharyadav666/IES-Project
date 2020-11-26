package com.ies.kentucky.admin.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.kentucky.admin.domain.AccountDomain;
import com.ies.kentucky.admin.entity.AccountEntity;
import com.ies.kentucky.admin.repository.AccountRepository;
import com.ies.kentucky.utils.EmailUtils;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository repo; 
	
	@Autowired
	private EmailUtils emailUtils;
	
	
	//To Insert new record into database
	@Override
	public boolean createAccount(AccountDomain account) {
		
		AccountEntity entity= new AccountEntity();
		BeanUtils.copyProperties(account, entity);
		entity.setAccStatus("Active");
		AccountEntity saveEntity = repo.save(entity);
		/*
		 * Integer accId = saveEntity.getEmpId(); return accId!=null ? true : false;
		 */
		
		if(saveEntity.getAccountId()!=null) {
			String to=saveEntity.getEmail();
			String subject="";
			String body=getRegSuccMailBody(account);
			return sendRegSuccEmail(to,subject, body);
		}
		else {
			return false;
		}
	}

	/*
	 * @Override public List<AccountDomain> getAllAccounts() {
	 * 
	 * AccountDomain acc=new AccountDomain(); List<AccountDomain> acclist=new
	 * ArrayList<>();
	 * 
	 * List<AccountEntity> accountList = repo.findAll(); for (AccountEntity entity :
	 * accountList) { acc.setEmpId(entity.getEmpId());
	 * acc.setFirstName(entity.getFirstName());
	 * acc.setLastName(entity.getLastName()); acc.setEmail(entity.getEmail());
	 * acc.setAccountType(entity.getAccountType());
	 * 
	 * acclist.add(acc); }
	 * 
	 * return acclist; }
	 */
	
	
	
    //This Method will Check Email is Unique or not
	@Override
	public boolean isUniqueEmail(String email) {
		AccountEntity entity = repo.findByEmail(email);
		
		return (entity==null) ? true: false;
	}
	
	//mail Body
	@Override
	public String getRegSuccMailBody(AccountDomain account) {
		String fileName = "IES-ACC-CREATION-EMAIL-BODY-TEMPLATE.txt";
		List<String> replacedLines = null;
		String mailBody = null;
		try {
			Path path = Paths.get(fileName, "");
			Stream<String> lines = Files.lines(path);

			replacedLines = lines.map(line -> line.replace("{FNAME}", account.getFirstName())
								 .replace("{LNAME}", account.getLastName())
								 .replace("{EMAIL}", account.getEmail()))
								 .collect(Collectors.toList());

			mailBody = String.join("", replacedLines);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mailBody;
	
	}
	//This method used to send a mail of account creation confirmation and this method calls mailsender method
	@Override
	public boolean sendRegSuccEmail(String to, String subject, String body) {
		
		return emailUtils.sendMail(to, subject, body);
	}

	//this method used to get accounts list based on account type
	@Override
	public List<AccountDomain> getEmpsByAccType(String role) {
		

		AccountDomain acc=new AccountDomain();
		List<AccountDomain> acclist=new ArrayList<>();
		
		List<AccountEntity> accountType = repo.findByRole(role);
		
		for (AccountEntity entity : accountType) {
			
			acc.setFirstName(entity.getFirstName());
			acc.setLastName(entity.getLastName());
			acc.setEmail(entity.getEmail());
			acc.setGender(entity.getGender());
			acc.setMobile(entity.getMobile());
			acc.setRole(entity.getRole());
			
			acclist.add(acc);
			
		}
		
		return acclist;
	}

	//This method used to edit and update the account
	@Override
	public AccountDomain getAccountByEmpId(String empId) {
		Optional<AccountEntity> findById = repo.findById(empId);
		AccountDomain acc=new AccountDomain();
		if(findById.isPresent()) {
			AccountEntity entity = findById.get();
			acc.setAccountId(entity.getAccountId());
			acc.setFirstName(entity.getFirstName());
			acc.setLastName(entity.getLastName());
			acc.setEmail(entity.getEmail());
			acc.setPswd(entity.getPswd());
			acc.setMobile(entity.getMobile());
			acc.setGender(entity.getGender());
			acc.setSsn(entity.getSsn());
			acc.setDob(entity.getDob());
			acc.setRole(entity.getRole());
		}
		return acc;
	}

	//this method used to delete a account
	@Override
	public AccountDomain deleteAccById(String empId) {
		Optional<AccountEntity> findById = repo.findById(empId);
		AccountDomain acc=new AccountDomain();
		AccountEntity entity = null;
		if(findById.isPresent()) {
			entity = findById.get();
			entity.setAccStatus("DeActive");
			
		}
		AccountEntity entity2 = repo.save(entity);
		acc.setFirstName(entity2.getFirstName());
		acc.setLastName(entity2.getLastName());
		acc.setEmail(entity2.getEmail());
		acc.setGender(entity2.getGender());
		acc.setMobile(entity2.getMobile());
		acc.setRole(entity2.getRole());
		return acc;
	}

	//this method used to get accounts list based on account type
	@Override
	public List<AccountDomain> getByAccType(String role) {
		
		List<AccountDomain> list=new ArrayList<>();
		AccountDomain acc=new AccountDomain();
		
		List<AccountEntity> entity = repo.findByRole(role);
		
		for (AccountEntity accentity : entity) {
			acc.setAccountId(accentity.getAccountId());
			acc.setFirstName(accentity.getFirstName());
			acc.setLastName(accentity.getLastName());
			acc.setEmail(accentity.getEmail());
			acc.setRole(accentity.getRole());
			acc.setAccStatus(accentity.getAccStatus());
			
			list.add(acc);
		}
		return list;
	}

	@Override
	public List<String> getTypesOfAccounts() {

		List<String> types = repo.getRoles();
		return types;
	}

	@Override
	public AccountDomain activeAccount(String accountId) {
		Optional<AccountEntity> optional = repo.findById(accountId);
		AccountDomain acc=new AccountDomain();
		AccountEntity entity=null;
		if(optional.isPresent()) {
			entity = optional.get();
			entity.setAccStatus("Active");
		}
		AccountEntity entity2 = repo.save(entity);
		acc.setFirstName(entity2.getFirstName());
		acc.setLastName(entity2.getLastName());
		acc.setEmail(entity2.getEmail());
		acc.setGender(entity2.getGender());
		acc.setMobile(entity2.getMobile());
		acc.setRole(entity2.getRole());
		return acc;
	}
	


	
	

}
