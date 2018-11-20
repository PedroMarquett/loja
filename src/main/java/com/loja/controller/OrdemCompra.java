package com.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrdemCompra {

	@GetMapping("/ordemVenda")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/ordemVenda/index");

		return mv;
	}
}
