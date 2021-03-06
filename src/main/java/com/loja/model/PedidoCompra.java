package com.loja.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PedidoCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, updatable = false)
	private Funcionario Funcionario;
	
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, updatable = false)
	private Cliente Cliente;
	
	@OneToMany(mappedBy = "PedidoCompra", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<PedidoCompraProduto> PedidoCompraProdutos;
	
	public List<PedidoCompraProduto> getPedidoCompraProdutos() {
		return PedidoCompraProdutos;
	}

	public void setPedidoCompraProdutos(List<PedidoCompraProduto> pedidoCompraProdutos) {
		PedidoCompraProdutos = pedidoCompraProdutos;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Funcionario getFuncionario() {
		return Funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		Funcionario = funcionario;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}
	
}
