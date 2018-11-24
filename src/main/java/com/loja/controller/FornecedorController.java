package com.loja.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loja.model.Fornecedor;
import com.loja.repository.FornecedorRepository;

@Controller
public class FornecedorController {
	
	private final String ROOT = "/fornecedor";
	
	@Autowired
	FornecedorRepository Repository;
	
	@GetMapping("/fornecedor")
	public ModelAndView findAll() {
		
		List<Fornecedor> lista = (List<Fornecedor>)Repository.findAll();

		ModelAndView mv = new ModelAndView("/fornecedor/index");
		
		mv.addObject("lista", lista);

		return mv;
	}
	
	@GetMapping(ROOT + "/add")
	public ModelAndView add() {
		
		ModelAndView mv = new ModelAndView(ROOT + "/add");
		mv.addObject("fornecedor", new Fornecedor());
		
		return mv;
	}
	
	@GetMapping(ROOT + "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView(ROOT + "/add");
		mv.addObject("fornecedor", Repository.findById(id));
		
		return mv;
	}
	
	@GetMapping(ROOT + "/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Repository.deleteById(id);
		
		return findAll();
	}

	@PostMapping(ROOT + "/save")
	public ModelAndView save(@Valid Fornecedor fornecedor, BindingResult result) {
		
		if(result.hasErrors()) {
			//return add(cliente);
		}
		
		Repository.save(fornecedor);
		
		return findAll();
	}

}
