package com.loja.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.loja.model.OrdemVenda;
import com.loja.repository.FornecedorRepository;
import com.loja.repository.FuncionarioRepository;
import com.loja.repository.OrdemVendaProdutoRepository;
import com.loja.repository.OrdemVendaRepository;
import com.loja.repository.ProdutoRepository;

@Controller
public class OrdemVendaController {
	
	private final String ROOT = "/ordemVenda";
	
	@Autowired
	OrdemVendaRepository ovRepository;
	
	@Autowired
	FuncionarioRepository funcRepository;
	
	@Autowired
	FornecedorRepository fornRepository;
	
	@Autowired
	ProdutoRepository prodRepository;
	
	@Autowired
	OrdemVendaProdutoRepository ovpRepository;

	@GetMapping(ROOT)
	public ModelAndView findAll() {
		
		List<OrdemVenda> lista = (List<OrdemVenda>)ovRepository.findAll();

		ModelAndView mv = new ModelAndView("/ordemVenda/index");
		
		mv.addObject("lista", lista);

		return mv;
	}
	@GetMapping(ROOT + "/add")
	public ModelAndView add() {
		
		ModelAndView mv = new ModelAndView(ROOT + "/add");
		mv.addObject("ordemVenda", new OrdemVenda());
		mv.addObject("listaFuncionarios", funcRepository.findAll());
		mv.addObject("listaFornecedores", fornRepository.findAll());
		mv.addObject("listaProdutos", prodRepository.findAll());
		
		return mv;
	}
	
	@GetMapping(ROOT + "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView(ROOT + "/add");
		
		Optional<OrdemVenda> ordemVenda = ovRepository.findById(id);
		
		mv.addObject("ordemVenda", ordemVenda);
		mv.addObject("ordemVendaProdutos", ordemVenda.get().getOrdemVendaProdutos());		
		mv.addObject("listaFuncionarios", funcRepository.findAll());
		mv.addObject("listaFornecedores", fornRepository.findAll());
		mv.addObject("listaProdutos", prodRepository.findAll());
		
		return mv;
	}
	
	@GetMapping(ROOT + "/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		ovRepository.deleteById(id);
		
		return findAll();
	}

	@PostMapping(ROOT + "/save")
	public ModelAndView save(OrdemVenda ordemVenda, BindingResult result) {
		
		if(result.hasErrors()) {
			//return add(cliente);
		}
		if (ordemVenda.getId() > 0) {
			//ovpRepository.findById(ordemVenda.getId()).get().getOrdemVendaProdutos()
			//ovpRepository.deleteAll(ovRepository.findById(ordemVenda.getId()).get().getOrdemVendaProdutos());
			OrdemVenda ov = ovRepository.findById(ordemVenda.getId()).get(); 
			ov.getOrdemVendaProdutos().forEach(item->{
				ovpRepository.deleteById(item.getId());
				});
		}
		if (ordemVenda.getOrdemVendaProdutos() != null)
			ordemVenda.getOrdemVendaProdutos().forEach(item->{
				item.setOrdemVenda(ordemVenda);
			});
		ovRepository.save(ordemVenda);
		
		return new ModelAndView("redirect:"+ROOT);
	}
}
