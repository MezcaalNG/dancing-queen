package com.srchicharron.dancingqueen.service;

import com.srchicharron.dancingqueen.model.Cita;
import com.srchicharron.dancingqueen.model.Cliente;
import com.srchicharron.dancingqueen.model.ResponseModel;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> getAllClientes();

    Optional<Cliente> findClienteById(int id);

    ResponseModel addCliente(Cliente cliente);

    ResponseModel updateCita(Cliente cliente);

    ResponseModel deleteCita(int id);
}
