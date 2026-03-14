package com.serviciosariana.app.personal.Services;

import com.serviciosariana.app.personal.Model.Cargo;
import com.serviciosariana.app.personal.Repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public List<Cargo> listarTodos() {
        return cargoRepository.listarTodos();
    }

    @Override
    public Optional<Cargo> obtenerPorId(Integer nCargoId) {
        return cargoRepository.obtenerPorId(nCargoId);
    }

    @Override
    public Integer crear(String cCargoCod, String cNombre, String cDescripcion) {
        return cargoRepository.insertar(cCargoCod, cNombre, cDescripcion);
    }

    @Override
    public void actualizar(Integer nCargoId, String cCargoCod, String cNombre, String cDescripcion, Boolean bEstado) {
        cargoRepository.actualizar(nCargoId, cCargoCod, cNombre, cDescripcion, bEstado);
    }

    @Override
    public void eliminar(Integer nCargoId) {
        cargoRepository.eliminar(nCargoId);
    }
}