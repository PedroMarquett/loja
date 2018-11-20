package com.loja.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends EntidadeBase {	
		
	@Column(length=1)
	private String Sexo;

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}
}
