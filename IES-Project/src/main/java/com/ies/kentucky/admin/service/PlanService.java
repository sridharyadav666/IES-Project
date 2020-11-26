package com.ies.kentucky.admin.service;

import java.util.List;

import com.ies.kentucky.admin.domain.PlanDomain;

public interface PlanService {

	
	public boolean createPlan(PlanDomain plan);
	
	public List<PlanDomain> getPlans();
	
	public PlanDomain getByPlanId(Integer pid);
	
	public boolean deleteByPlanId(Integer pid);
}
