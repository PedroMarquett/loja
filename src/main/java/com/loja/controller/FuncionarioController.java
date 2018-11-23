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

import com.loja.model.Funcionario;
import com.loja.repository.FuncionarioRepository;

	@Controller
	public class FuncionarioController {
		
		private final String ROOT = "/funcionario";
		
		@Autowired
		FuncionarioRepository Repository;

		@GetMapping(ROOT)
		public ModelAndView findAll() {		
			
			List<Funcionario> lista = (List<Funcionario>)Repository.findAll();

			ModelAndView mv = new ModelAndView("/funcionario/index");

			mv.addObject("lista", lista);

		    return mv;
		}
		@GetMapping(ROOT + "/add")
		public ModelAndView add() {
			
			ModelAndView mv = new ModelAndView(ROOT + "/add");
			mv.addObject("funcionario", new Funcionario());
			
			return mv;
		}
		
		@GetMapping(ROOT + "/edit/{id}")
		public ModelAndView edit(@PathVariable("id") Long id) {
			ModelAndView mv = new ModelAndView(ROOT + "/add");
			mv.addObject("funcionario", Repository.findById(id));
			
			return mv;
		}
		
		@GetMapping(ROOT + "/delete/{id}")
		public ModelAndView delete(@PathVariable("id") Long id) {
			
			Repository.deleteById(id);
			
			return findAll();
		}

		@PostMapping(ROOT + "/save")
		public ModelAndView save(@Valid Funcionario funcionario, BindingResult result) {
			
			if(result.hasErrors()) {
				//return add(cliente);
			}
			
			Repository.save(funcionario);
			
			return findAll();
		}
		
	}
