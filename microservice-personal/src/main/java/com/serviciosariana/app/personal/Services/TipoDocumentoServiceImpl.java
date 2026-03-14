package com.serviciosariana.app.personal.Services;

import com.serviciosariana.app.personal.Model.TipoDocumento;
import com.serviciosariana.app.personal.Repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumento> listarTodos() {
        return tipoDocumentoRepository.listarTodos();
    }
}