package com.srchicharron.dancingqueen.service;

import com.srchicharron.dancingqueen.model.Cliente;
import com.srchicharron.dancingqueen.model.Mascota;
import com.srchicharron.dancingqueen.model.ResponseModel;

import java.util.List;

public interface MascotaService {
    List<Mascota> getMascotasByClienteID(int idCliente);

    ResponseModel addMascota(Mascota mascota);

    ResponseModel updateCita(Mascota mascota);

    ResponseModel deleteCita(int id);
}
