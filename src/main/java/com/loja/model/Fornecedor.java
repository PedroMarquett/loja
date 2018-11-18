package com.loja.model;

import javax.persistence.Entity;

@Entity
public class Fornecedor extends EntidadeBase{

	public Fornecedor(long id, String nome, String cpfCnpj, String telefone, String endereco, String sexo) {
		super(id, nome, cpfCnpj, telefone, endereco);
	}
}
