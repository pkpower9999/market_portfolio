package kr.co.uk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.uk.service.ProductService;
import kr.co.uk.vo.ProductVO;


@Controller
public class ProductController {
	
	@Autowired
	ProductService service;

	@GetMapping("/products")
	public String getProducts(Model model) {
		model.addAttribute("menu_num", 0);
		List<ProductVO> productList = service.selectProducts(null);
		
		model.addAttribute("list", productList);
		
		return "/product/list";
	}
}
