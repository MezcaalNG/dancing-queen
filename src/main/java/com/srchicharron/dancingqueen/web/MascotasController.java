package com.srchicharron.dancingqueen.web;

import com.srchicharron.dancingqueen.model.Cita;
import com.srchicharron.dancingqueen.model.Mascota;
import com.srchicharron.dancingqueen.model.ResponseModel;
import com.srchicharron.dancingqueen.service.MascotaService;
import com.srchicharron.dancingqueen.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ={"http://localhost:8080","http://localhost:8081","http://localhost:8082","http://localhost:8083"},
        exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
@RequestMapping("mascotas")
@RestController
public class MascotasController {
    private static Logger log = LoggerFactory.getLogger(MascotasController.class);
    Utils utils = new Utils();

    @Autowired
    private MascotaService mascotaService;

    //@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @GetMapping("/getmascotasbyclienteid")
    public ResponseEntity<List<Mascota>> getCitasByClienteId(@RequestParam int idCliente) {
        List<Mascota> list = mascotaService.getMascotasByClienteID(idCliente);
        return new ResponseEntity<List<Mascota>>(list, HttpStatus.OK);
    }

    //@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @PostMapping("/addmascota")
    public ResponseEntity<ResponseModel> addCita(@RequestBody Mascota mascota) {
        log.atInfo().log("Se recibe peticion: "+utils.jsonFormatter(mascota));
        ResponseModel response = mascotaService.addMascota(mascota);
        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }

    @PostMapping("/updatemascota")
    public ResponseEntity<ResponseModel> updateCita(@RequestBody Mascota mascota) {
        log.atInfo().log("Se recibe peticion: "+utils.jsonFormatter(mascota));
        ResponseModel response = mascotaService.updateCita(mascota);
        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }

    //@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080"})
    @PostMapping("/deletemascota")
    public ResponseEntity<ResponseModel> deleteCita(@RequestBody Mascota mascota) {
        log.atInfo().log("Se recibe peticion: "+utils.jsonFormatter(mascota));
        ResponseModel response = mascotaService.deleteCita(mascota.getId());
        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }
}
