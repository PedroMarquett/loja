package com.loja.repository;

import org.springframework.data.repository.CrudRepository;
import com.loja.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
