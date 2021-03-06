package com.loja.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntidadeBase extends Base {
	
	@Column(length=18)
	private String CpfCnpj;
	@Column(length=12)
	private String Telefone;
	private String Endereco;
	
	public String getCpfCnpj() {
		return CpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		CpfCnpj = cpfCnpj;
	}	
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
}
