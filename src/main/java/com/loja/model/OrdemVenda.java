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
public class OrdemVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, updatable = false)
	private Funcionario Funcionario;
	

	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, updatable = false)
	private Fornecedor Fornecedor;

	public Set<OrdemVendaProduto> getOrdemVendaProdutos() {
		return OrdemVendaProdutos;
	}

	public void setOrdemVendaProdutos(Set<OrdemVendaProduto> ordemVendaProdutos) {
		OrdemVendaProdutos = ordemVendaProdutos;
	}

	@OneToMany(mappedBy = "OrdemVenda")
	private Set<OrdemVendaProduto> OrdemVendaProdutos = new HashSet<>(0);

	public Set<OrdemVendaProduto> getOrdemVendaProduto() {
		return OrdemVendaProdutos;
	}

	public void setOrdemVendaProduto(Set<OrdemVendaProduto> ordemVendaProduto) {
		OrdemVendaProdutos = ordemVendaProduto;
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

	public Fornecedor getFornecedor() {
		return Fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		Fornecedor = fornecedor;
	}
}
