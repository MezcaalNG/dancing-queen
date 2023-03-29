package com.srchicharron.dancingqueen.web;


import com.srchicharron.dancingqueen.model.Cliente;
import com.srchicharron.dancingqueen.service.ClienteService;
import com.srchicharron.dancingqueen.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@RestController
public class DancingQueenController {
    private static Logger log = LoggerFactory.getLogger(DancingQueenController.class);
    Utils utils = new Utils();

    @Autowired
    private ClienteService clienteService;

    @CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @GetMapping("/getallclientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> list = clienteService.getAllClientes();
         return new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
    }

    @CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @GetMapping("/getclientebyid")
    public ResponseEntity<Optional<Cliente>> getClienteById(@RequestParam int id) {
        Optional<Cliente> cliente = clienteService.findClienteById(id);
        return new ResponseEntity<Optional<Cliente>>(cliente, HttpStatus.OK);
    }

}
