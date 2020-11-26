package com.ies.kentucky.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ies.kentucky.admin.domain.PlanDomain;
import com.ies.kentucky.admin.service.PlanService;

@Controller
public class ViewPlansController {

	@Autowired
	private PlanService serv;
	
	@GetMapping("/allPlans")
	public String viewAllPlansBtnHandler(Model model) {
		List<PlanDomain> plans = serv.getPlans();
		
		model.addAttribute("plans", plans);
		
		return "viewPlans";
	}
	@GetMapping("/editplan")
	public String editBtnHandler(@RequestParam("pid") Integer pid, Model model) {
		
		PlanDomain plan = serv.getByPlanId(pid);
		model.addAttribute("plan", plan);
		
		return "createPlan";
	}
	
	@GetMapping("/deleteplan")
	public String deleteBtnHandler(@RequestParam("pid") Integer pid, RedirectAttributes redr) {
		
		boolean byPlanId = serv.deleteByPlanId(pid);
		
		if(byPlanId) {
			redr.addFlashAttribute("succMsg", "Plan Deleted Successfully");
		}else {
			redr.addFlashAttribute("succMsg", "Plan Deletion Failure");
		}
		
		return "redirect:/allplans";
	}
}
