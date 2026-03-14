package com.serviciosariana.app.personal.Controller;

import com.serviciosariana.app.personal.Model.TipoDocumento;
import com.serviciosariana.app.personal.Services.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal/tipos-documento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public ResponseEntity<List<TipoDocumento>> listarTodos() {
        return ResponseEntity.ok(tipoDocumentoService.listarTodos());
    }
}