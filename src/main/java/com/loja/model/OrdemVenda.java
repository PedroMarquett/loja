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

	@OneToMany(mappedBy = "OrdemVenda", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrdemVendaProduto> OrdemVendaProdutos;
	
	public List<OrdemVendaProduto> getOrdemVendaProdutos() {
		return OrdemVendaProdutos;
	}

	public void setOrdemVendaProdutos(List<OrdemVendaProduto> ordemVendaProdutos) {
		OrdemVendaProdutos = ordemVendaProdutos;
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
