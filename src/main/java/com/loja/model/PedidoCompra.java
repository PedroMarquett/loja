package com.loja.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
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

	public Set<PedidoCompraProduto> getPedidoCompraProdutos() {
		return PedidoCompraProdutos;
	}

	public void setPedidoCompraProdutos(Set<PedidoCompraProduto> pedidoCompraProdutos) {
		PedidoCompraProdutos = pedidoCompraProdutos;
	}

	@OneToMany(mappedBy = "PedidoCompra")
	private Set<PedidoCompraProduto> PedidoCompraProdutos = new HashSet<>(0);
}
