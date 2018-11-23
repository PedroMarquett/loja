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

import com.loja.model.OrdemVenda;
import com.loja.repository.OrdemVendaRepository;

@Controller
public class OrdemCompra {
	
	private final String ROOT = "/ordemVenda";
	
	@Autowired
	OrdemVendaRepository Repository;

	@GetMapping("/ordemVenda")
	public ModelAndView findAll() {
		
		List<OrdemVenda> lista = (List<OrdemVenda>)Repository.findAll();

		ModelAndView mv = new ModelAndView("/ordemVenda/index");
		
		mv.addObject("lista", lista);

		return mv;
	}
	@GetMapping(ROOT + "/add")
	public ModelAndView add() {
		
		ModelAndView mv = new ModelAndView(ROOT + "/add");
		mv.addObject("ordemVenda", new OrdemVenda());
		
		return mv;
	}
	
	@GetMapping(ROOT + "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("/postAdd");
		mv.addObject("ordemVenda", Repository.findById(id));
		
		return mv;
	}
	
	@GetMapping(ROOT + "/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Repository.deleteById(id);
		
		return findAll();
	}

	@PostMapping(ROOT + "/save")
	public ModelAndView save(@Valid OrdemVenda ordemVenda, BindingResult result) {
		
		if(result.hasErrors()) {
			//return add(cliente);
		}
		
		Repository.save(ordemVenda);
		
		return findAll();
	}
}
