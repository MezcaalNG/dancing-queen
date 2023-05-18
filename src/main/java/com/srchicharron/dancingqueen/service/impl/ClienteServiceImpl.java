package com.srchicharron.dancingqueen.service.impl;

import com.srchicharron.dancingqueen.model.Cita;
import com.srchicharron.dancingqueen.model.Cliente;
import com.srchicharron.dancingqueen.model.ResponseModel;
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
    public ResponseModel addCliente(Cliente cliente) {
        ResponseModel response = new ResponseModel();
        try{
            Cliente savedCliente = clienteRepository.save(cliente);
            response.setReturnCode(0);
        }catch(Exception e){
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModel updateCita(Cliente cliente) {
        ResponseModel response = new ResponseModel();
        try{
            Cliente savedCliente = clienteRepository.save(cliente);
            response.setReturnCode(0);
        }catch(Exception e){
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModel deleteCita(int id) {
        ResponseModel responseUpdate = new ResponseModel();
        try{
            clienteRepository.deleteById(id);
            responseUpdate.setReturnCode(0);
        }catch(Exception e){
            System.out.println(e);
            responseUpdate.setReturnCode(1);
        }
        return responseUpdate;
    }


}
