package com.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ClienteController {

	@GetMapping("/cliente")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/cliente/index");

		return mv;
	}

}
