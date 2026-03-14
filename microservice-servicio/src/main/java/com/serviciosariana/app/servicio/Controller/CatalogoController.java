package com.serviciosariana.app.servicio.Controller;

import com.serviciosariana.app.servicio.Model.EstadoOrden;
import com.serviciosariana.app.servicio.Model.Prioridad;
import com.serviciosariana.app.servicio.Model.TipoAlerta;
import com.serviciosariana.app.servicio.Model.dto.EstadoOrdenSimpleDTO;
import com.serviciosariana.app.servicio.Services.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio/catalogos")
public class CatalogoController {

    @Autowired
    private CatalogoService catalogoService;

    @GetMapping("/prioridades")
    public ResponseEntity<List<Prioridad>> listarPrioridades() {
        return ResponseEntity.ok(catalogoService.listarPrioridades());
    }

    @GetMapping("/estados-orden")
    public ResponseEntity<List<EstadoOrden>> listarEstadosOrden() {
        return ResponseEntity.ok(catalogoService.listarEstadosOrden());
    }

    @GetMapping("/estados-orden/siguientes/{estadoActual}")
    public ResponseEntity<List<EstadoOrdenSimpleDTO>> listarEstadosSiguientes(
            @PathVariable("estadoActual") String cEstadoOrdenCodActual) {
        return ResponseEntity.ok(catalogoService.listarEstadosSiguientes(cEstadoOrdenCodActual));
    }

    @GetMapping("/tipos-alerta")
    public ResponseEntity<List<TipoAlerta>> listarTiposAlerta() {
        return ResponseEntity.ok(catalogoService.listarTiposAlerta());
    }
}