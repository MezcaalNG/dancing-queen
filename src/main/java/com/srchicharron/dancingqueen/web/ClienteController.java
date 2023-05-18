package com.srchicharron.dancingqueen.web;

import com.srchicharron.dancingqueen.model.Cliente;
import com.srchicharron.dancingqueen.model.ResponseModel;
import com.srchicharron.dancingqueen.service.ClienteService;
import com.srchicharron.dancingqueen.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ={"http://localhost:8080","http://localhost:8081","http://localhost:8082","http://localhost:8083"},
        exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
@RequestMapping("clientes")
@RestController
public class ClienteController {
    private static Logger log = LoggerFactory.getLogger(ClienteController.class);
    Utils utils = new Utils();

    @Autowired
    private ClienteService clienteService;

    //@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @GetMapping("/getallclientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> list = clienteService.getAllClientes();
         return new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
    }

    //@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @GetMapping("/getclientebyid")
    public ResponseEntity<Optional<Cliente>> getClienteById(@RequestParam int id) {
        Optional<Cliente> cliente = clienteService.findClienteById(id);
        return new ResponseEntity<Optional<Cliente>>(cliente, HttpStatus.OK);
    }

    //@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @PostMapping("/addcliente")
    public ResponseEntity<ResponseModel> addCliente(@RequestBody Cliente cliente) {
        log.atInfo().log("Se recibe peticion: "+utils.jsonFormatter(cliente));
        ResponseModel response = clienteService.addCliente(cliente);
        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }

    @PostMapping("/updatecliente")
    public ResponseEntity<ResponseModel> updateCita(@RequestBody Cliente cliente) {
        log.atInfo().log("Se recibe peticion: "+utils.jsonFormatter(cliente));
        ResponseModel response = clienteService.updateCita(cliente);
        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }

    //@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @PostMapping("/deletecliente")
    public ResponseEntity<ResponseModel> deleteCita(@RequestBody Cliente cliente) {
        log.atInfo().log("Se recibe peticion: "+utils.jsonFormatter(cliente));
        ResponseModel response = clienteService.deleteCita(cliente.getId());
        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }
}
