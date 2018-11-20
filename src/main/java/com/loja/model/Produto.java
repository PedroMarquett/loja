package com.loja.model;

import javax.persistence.Entity;

@Entity
public class Produto extends Base{

	private int Quantidade;
	
	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}	
}
