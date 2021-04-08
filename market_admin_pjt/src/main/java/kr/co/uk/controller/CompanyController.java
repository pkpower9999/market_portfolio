package kr.co.uk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.uk.service.CompanyService;
import kr.co.uk.vo.CompanyVO;


@Controller
public class CompanyController {

	@Autowired
	CompanyService service;
	
	@GetMapping("/company")
	public String getCompany(Model model) {
		model.addAttribute("menu_num", 2);
		
		List<CompanyVO> list = service.selectCompanies();
		model.addAttribute("list", list);
		
		return "/company/company_list";
	}
}
