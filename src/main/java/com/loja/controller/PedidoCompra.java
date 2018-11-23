package com.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loja.repository.PedidoCompraRepository;

@Controller
public class PedidoCompra {
	
	private final String ROOT = "/pedidoCompra";
	
	@Autowired
	PedidoCompraRepository Repository;
	
	@GetMapping("/pedidoCompra")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/pedidoCompra/index");

		return mv;
	}
}
