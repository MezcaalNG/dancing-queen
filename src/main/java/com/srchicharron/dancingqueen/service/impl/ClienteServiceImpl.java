package com.srchicharron.dancingqueen.service.impl;

import com.srchicharron.dancingqueen.model.Cliente;
import com.srchicharron.dancingqueen.repository.ClienteRepository;
import com.srchicharron.dancingqueen.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clienteRepository.findAll().forEach(clientes::add);
        return clientes;
    }

    @Override
    public Optional<Cliente> findClienteById(int id) {
        Optional<Cliente> cliente = Optional.of(new Cliente());
        cliente=clienteRepository.findById(id);
        return cliente;
    }

    @Override
    public void addCliente(Cliente cliente) {

    }

    @Override
    public void updateCliente(int id, Cliente cliente) {

    }

    @Override
    public void deleteCliente(int id) {

    }
}
