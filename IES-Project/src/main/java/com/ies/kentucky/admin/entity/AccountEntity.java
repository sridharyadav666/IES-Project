package com.ies.kentucky.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "ACCOUNTS_DTLS")
public class AccountEntity {

	@Id
	@Column(name="ACCOUNT_ID")
	@GenericGenerator(name = "ID_SEQ", strategy = "com.ies.kentucky.generator.EmployeeIdGenerator")
	@GeneratedValue(generator = "ID_SEQ")
	private String accountId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String pswd;
	
	@Column(name = "DOB")
	private String dob;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "SSN")
	private Long ssn;
	
	@Column(name = "MOBILE")
	private String mobile;
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name="ACC_STATUS")
	private String accStatus;
	
	@Column(name = "ACC_CREATION_DATE")
	@CreationTimestamp
	private Date acCreationDate;
	
	@Column(name = "ACC_UPDATE_DATE")
	@UpdateTimestamp
	private Date acUpadatedDate;
	
}
