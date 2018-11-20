package com.loja.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Funcionario extends EntidadeBase{
		
	@Column(length=1)
	private String Sexo;
	
	@OneToMany(mappedBy = "Funcionario")
	private Set<OrdemVenda> OrdemVendas;

	public Set<OrdemVenda> getOrdemVendas() {
		return OrdemVendas;
	}

	public void setOrdemVendas(Set<OrdemVenda> ordemVendas) {
		OrdemVendas = ordemVendas;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

}
