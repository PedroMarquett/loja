package com.loja.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OrdemVenda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	private Funcionario Funcionario;
	private Fornecedor Fornecedor;
	private Estoque Produto;
	private int Quantidade;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
}
