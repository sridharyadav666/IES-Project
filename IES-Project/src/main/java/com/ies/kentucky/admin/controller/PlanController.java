package com.ies.kentucky.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ies.kentucky.admin.domain.PlanDomain;
import com.ies.kentucky.admin.service.PlanService;

@Controller
public class PlanController {

	@Autowired
	private PlanService serv;
	
	@ModelAttribute
	public void modelInit(Model model) {
		PlanDomain plan =new PlanDomain();
		model.addAttribute("plan", plan);
	}
	
	@GetMapping("/plancreation")
	public String loadCreatePlanPage(Model model) {
		
		return "createPlan";
	}
	
	@PostMapping("/createPlan")
	public String handleCreatePlanBtn(@ModelAttribute PlanDomain plan, RedirectAttributes redr) {
		
		serv.createPlan(plan);
		
		if(plan.getPid()!=null) {
			redr.addFlashAttribute("succMsg", "Plan Updated Successfully");
		}else {
			redr.addFlashAttribute("succMsg", "Plan Created Successfully");
		}
		
		return "redirect:/planSucc";
	}
	
	@GetMapping("/planSucc")
	public String doublePostingHandler(Model model) {
		
		return "createPlan";
	}
}
