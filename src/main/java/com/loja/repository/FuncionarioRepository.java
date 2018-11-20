package com.loja.repository;

import org.springframework.data.repository.CrudRepository;

import com.loja.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

}
