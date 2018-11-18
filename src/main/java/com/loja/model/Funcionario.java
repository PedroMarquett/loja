package com.loja.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Funcionario extends EntidadeBase{
	
	public Funcionario(long id, String nome, String cpfCnpj, String telefone, String endereco) {
		super(id, nome, cpfCnpj, telefone, endereco);
	}
	
	@Column(length=1)
	private String Sexo;

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

}
