package com.srchicharron.dancingqueen.service.impl;

import com.srchicharron.dancingqueen.model.*;
import com.srchicharron.dancingqueen.repository.CitaRepository;
import com.srchicharron.dancingqueen.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<Cita> getAllCitas() {
        List<Cita> citas = new ArrayList<>();
        //citaRepository.findAll().forEach(citas::add);
        LocalDate currentDate = LocalDate.now();
        citaRepository.getAllByFechaGreaterThanEqualOrderByFecha(currentDate.toString()).forEach(citas::add);
        citas.forEach(cita -> cita.getMascota().ageDef());
        return citas;
    }

    @Override
    public Optional<Cita> findCitaById(int id) {
        Optional<Cita> cita = Optional.of(new Cita());
        cita=citaRepository.findById(id);
        cita.get().getMascota().ageDef();
        return cita;
    }

    @Override
    public List<Cita> getCitasByClienteID(int idCliente) {
        List<Cita> citas = new ArrayList<>();
        citaRepository.getCitasByClienteId(idCliente).forEach(citas::add);
        citas.forEach(cita -> cita.getMascota().ageDef());
        return citas;
    }

    @Override
    public ResponseModel addCita(Cita cita) {
        ResponseModel response = new ResponseModel();
        try{
            Cita savedCita = citaRepository.save(cita);
            response.setReturnCode(0);
        }catch(Exception e){
            System.out.println(e);
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModel updateCita(Cita cita) {
        ResponseModel responseUpdate = new ResponseModel();
        try{
            Cita updatedCita = citaRepository.save(cita);
            responseUpdate.setReturnCode(0);
        }catch(Exception e){
            System.out.println(e);
            responseUpdate.setReturnCode(1);
        }
        return responseUpdate;
    }

    @Override
    public ResponseModel deleteCita(int id) {
        ResponseModel responseUpdate = new ResponseModel();
        try{
            citaRepository.deleteById(id);
            responseUpdate.setReturnCode(0);
        }catch(Exception e){
            System.out.println(e);
            responseUpdate.setReturnCode(1);
        }
        return responseUpdate;
    }
}
