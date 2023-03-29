package com.srchicharron.dancingqueen.repository;

import com.srchicharron.dancingqueen.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
