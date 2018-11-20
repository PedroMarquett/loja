package com.loja.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FornecedorController {
	@GetMapping("/fornecedor")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/fornecedor/index");

		return mv;
	}

}
