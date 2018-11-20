package com.loja.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.loja.model.Cliente;
import com.loja.repository.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	ClienteRepository Repository;
	
	@GetMapping("/cliente")
	public ModelAndView findAll() {
		
		List<Cliente> lista = (List<Cliente>)Repository.findAll();

		ModelAndView mv = new ModelAndView("/cliente/index");

		return mv;
	}

}
