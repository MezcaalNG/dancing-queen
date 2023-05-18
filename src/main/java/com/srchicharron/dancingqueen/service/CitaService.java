package com.srchicharron.dancingqueen.service;

import com.srchicharron.dancingqueen.model.Cita;
import com.srchicharron.dancingqueen.model.ResponseModel;

import java.util.List;
import java.util.Optional;

public interface CitaService {
    List<Cita> getAllCitas();

    Optional<Cita> findCitaById(int id);

    List<Cita> getCitasByClienteID(int idCliente);

    ResponseModel addCita(Cita cita);

    ResponseModel updateCita(Cita cita);

    ResponseModel deleteCita(int id);
}
