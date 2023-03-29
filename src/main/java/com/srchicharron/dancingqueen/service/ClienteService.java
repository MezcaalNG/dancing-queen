package com.srchicharron.dancingqueen.service;

import com.srchicharron.dancingqueen.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> getAllClientes();

    Optional<Cliente> findClienteById(int id);

    void addCliente(Cliente cliente);

    void updateCliente(int id, Cliente cliente);

    void deleteCliente(int id);
}
