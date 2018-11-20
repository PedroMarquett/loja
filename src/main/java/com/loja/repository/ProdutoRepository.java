package com.loja.repository;

import org.springframework.data.repository.CrudRepository;

import com.loja.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
