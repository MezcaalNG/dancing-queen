package com.srchicharron.dancingqueen.web;

import com.srchicharron.dancingqueen.model.Cita;
import com.srchicharron.dancingqueen.model.Cliente;
import com.srchicharron.dancingqueen.model.ResponseModel;
import com.srchicharron.dancingqueen.service.CitaService;
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
@RequestMapping("citas")
@RestController
public class CitaController {
    private static Logger log = LoggerFactory.getLogger(CitaController.class);
    Utils utils = new Utils();

    @Autowired
    private CitaService citaService;

    //@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @GetMapping("/getallcitas")
    public ResponseEntity<List<Cita>> getAllCitas() {
        List<Cita> list = citaService.getAllCitas();
        return new ResponseEntity<List<Cita>>(list, HttpStatus.OK);
    }

    //@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @GetMapping("/getcitabyid")
    public ResponseEntity<Optional<Cita>> getCitaById(@RequestParam int id) {
        Optional<Cita> cita = citaService.findCitaById(id);
        return new ResponseEntity<Optional<Cita>>(cita, HttpStatus.OK);
    }

    //@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @GetMapping("/getcitasbyclienteid")
    public ResponseEntity<List<Cita>> getCitasByClienteId(@RequestParam int idCliente) {
        List<Cita> list = citaService.getCitasByClienteID(idCliente);
        return new ResponseEntity<List<Cita>>(list, HttpStatus.OK);
    }

    //@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @PostMapping("/addcita")
    public ResponseEntity<ResponseModel> addCita(@RequestBody Cita cita) {
        log.atInfo().log("Se recibe peticion: "+utils.jsonFormatter(cita));
        ResponseModel response = citaService.addCita(cita);
        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }

    @PostMapping("/updatecita")
    public ResponseEntity<ResponseModel> updateCita(@RequestBody Cita cita) {
        log.atInfo().log("Se recibe peticion: "+utils.jsonFormatter(cita));
        ResponseModel response = citaService.updateCita(cita);
        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }

    //@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @PostMapping("/deletecita")
    public ResponseEntity<ResponseModel> deleteCita(@RequestBody Cita cita) {
        log.atInfo().log("Se recibe peticion: "+utils.jsonFormatter(cita));
        ResponseModel response = citaService.deleteCita(cita.getId());
        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }
}
