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

import com.loja.model.PedidoCompra;
import com.loja.repository.ClienteRepository;
import com.loja.repository.FuncionarioRepository;
import com.loja.repository.PedidoCompraProdutoRepository;
import com.loja.repository.PedidoCompraRepository;
import com.loja.repository.ProdutoRepository;

@Controller
public class PedidoCompraController {
	
private final String ROOT = "/pedidoCompra";
	
	@Autowired
	PedidoCompraRepository pcRepository;
	
	@Autowired
	FuncionarioRepository funcRepository;
	
	@Autowired
	ClienteRepository cliRepository;
	
	@Autowired
	ProdutoRepository prodRepository;
	
	@Autowired
	PedidoCompraProdutoRepository pcpRepository;

	@GetMapping(ROOT)
	public ModelAndView findAll() {		
		ModelAndView mv = new ModelAndView(ROOT + "/index");
		
		mv.addObject("lista", pcRepository.findAll());

		return mv;
	}
	@GetMapping(ROOT + "/add")
	public ModelAndView add() {
		
		ModelAndView mv = new ModelAndView(ROOT + "/add");
		mv.addObject("pedidoCompra", new PedidoCompra());
		mv.addObject("listaFuncionarios", funcRepository.findAll());
		mv.addObject("listaClientes", cliRepository.findAll());
		mv.addObject("listaProdutos", prodRepository.findAll());
		
		return mv;
	}
	
	@GetMapping(ROOT + "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView(ROOT + "/add");
		
		Optional<PedidoCompra> pedidoCompra = pcRepository.findById(id);
		
		mv.addObject("pedidoCompra", pedidoCompra);
		mv.addObject("pedidoCompraProdutos", pedidoCompra.get().getPedidoCompraProdutos());		
		mv.addObject("listaFuncionarios", funcRepository.findAll());
		mv.addObject("listaClientes", cliRepository.findAll());
		mv.addObject("listaProdutos", prodRepository.findAll());
		
		return mv;
	}
	
	@GetMapping(ROOT + "/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		pcRepository.deleteById(id);
		
		return findAll();
	}

	@PostMapping(ROOT + "/save")
	public ModelAndView save(PedidoCompra pedidoCompra, BindingResult result) {
		
		if(result.hasErrors()) {
			//return add(cliente);
		}
		if (pedidoCompra.getId() > 0) {
			//ovpRepository.findById(ordemVenda.getId()).get().getOrdemVendaProdutos()
			//ovpRepository.deleteAll(ovRepository.findById(ordemVenda.getId()).get().getOrdemVendaProdutos());
			PedidoCompra pc = pcRepository.findById(pedidoCompra.getId()).get(); 
			pc.getPedidoCompraProdutos().forEach(item->{
				pcpRepository.deleteById(item.getId());
				});
		}
		if (pedidoCompra.getPedidoCompraProdutos() != null)
			pedidoCompra.getPedidoCompraProdutos().forEach(item->{
				item.setPedidoCompra(pedidoCompra);
			});
		pcRepository.save(pedidoCompra);
		
		return new ModelAndView("redirect:"+ROOT);
	}
}
