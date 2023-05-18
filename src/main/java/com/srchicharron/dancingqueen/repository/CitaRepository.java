package com.srchicharron.dancingqueen.repository;
import com.srchicharron.dancingqueen.model.Cita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends CrudRepository<Cita, Integer> {
    public List<Cita> getCitasByClienteId(int idCliente);

    public List<Cita> getAllByFechaGreaterThanEqualOrderByFecha(String fecha);
}
