package com.loja.utils;

public enum EnumEntidadeTipo {
	FUNCIONARIO(1),
	CLIENTE(2),
	FORNECEDOR(3);
	
	private int Codigo;
	EnumEntidadeTipo(int codigo){
		Codigo = codigo;
	}
}
