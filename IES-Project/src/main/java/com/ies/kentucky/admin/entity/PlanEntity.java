package com.ies.kentucky.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PLANS_DTLS")
public class PlanEntity {

	@Id
	@Column(name="PLAN_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	@Column(name="PLAN_NAME")
	private String planName;
	@Column(name="PLAN_DESCRIPTION")
	private String planDesc;
	@Column(name="PLAN_START_DATE")
	private Date startDate;
	@Column(name="PLAN_END_DATE")
	private Date endDate;
	
}
