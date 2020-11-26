package com.ies.kentucky.admin.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PlanDomain {

	
	private Integer pid;
	private String planName;
	private String planDesc;
	private Date startDate;
	private Date endDate;
	
}
