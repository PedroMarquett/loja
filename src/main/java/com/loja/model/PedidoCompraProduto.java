package com.loja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PedidoCompraProduto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;	
	
	@ManyToOne    
	private PedidoCompra PedidoCompra;
	
	@ManyToOne    
	private Produto Produto;
	
	private int Quantidade;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public PedidoCompra getPedidoCompra() {
		return PedidoCompra;
	}

	public void setPedidoCompra(PedidoCompra pedidoCompra) {
		PedidoCompra = pedidoCompra;
	}

	public Produto getProduto() {
		return Produto;
	}

	public void setProduto(Produto produto) {
		Produto = produto;
	}

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
}
