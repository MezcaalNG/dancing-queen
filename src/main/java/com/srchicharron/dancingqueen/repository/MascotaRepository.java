package com.srchicharron.dancingqueen.repository;

import com.srchicharron.dancingqueen.model.Mascota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends CrudRepository<Mascota, Integer> {
    List<Mascota> getAllByCliente_Id(int idCliente);
}
