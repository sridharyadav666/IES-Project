package com.ies.kentucky.admin.domain;

import java.util.Date;

import lombok.Data;

@Data
public class AccountDomain {

	private String accountId;
	private String firstName;
	private String lastName;
	private String email;
	private String pswd;
	private String dob;
	private String gender;
	private Long ssn;
	private String mobile;
	private String role;
	private String accStatus;
	private Date acCreationDate;
	private Date acUpadatedDate;
	
}
