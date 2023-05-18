package com.srchicharron.dancingqueen.service.impl;

import com.srchicharron.dancingqueen.model.Cita;
import com.srchicharron.dancingqueen.model.Mascota;
import com.srchicharron.dancingqueen.model.ResponseModel;
import com.srchicharron.dancingqueen.repository.MascotaRepository;
import com.srchicharron.dancingqueen.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;
    @Override
    public List<Mascota> getMascotasByClienteID(int idCliente) {
        List<Mascota> mascotas = new ArrayList<>();
        if(idCliente==0){
            mascotaRepository.findAll().forEach(mascotas::add);
        }else{
            mascotaRepository.getAllByCliente_Id(idCliente).forEach(mascotas::add);
        }
        mascotas.forEach(mascota -> mascota.ageDef());
        return mascotas;
    }

    @Override
    public ResponseModel addMascota(Mascota mascota) {
        ResponseModel responseUpdate = new ResponseModel();
        try{
            Mascota updatedMascota = mascotaRepository.save(mascota);
            responseUpdate.setReturnCode(0);
        }catch(Exception e){
            System.out.println(e);
            responseUpdate.setReturnCode(1);
        }
        return responseUpdate;
    }

    @Override
    public ResponseModel updateCita(Mascota mascota) {
        ResponseModel responseUpdate = new ResponseModel();
        try{
            Mascota updatedMascota = mascotaRepository.save(mascota);
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
            mascotaRepository.deleteById(id);
            responseUpdate.setReturnCode(0);
        }catch(Exception e){
            System.out.println(e);
            responseUpdate.setReturnCode(1);
        }
        return responseUpdate;
    }
}
