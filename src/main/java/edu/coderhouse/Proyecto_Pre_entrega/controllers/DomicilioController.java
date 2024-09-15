package edu.coderhouse.Proyecto_Pre_entrega.controllers;

import edu.coderhouse.Proyecto_Pre_entrega.entities.Domicilio;
import edu.coderhouse.Proyecto_Pre_entrega.services.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @PostMapping("/agregar")
    public ResponseEntity<Domicilio> agregarDomicilio(@RequestBody Domicilio domicilio) {
        Domicilio nuevoDomicilio = domicilioService.agregarDomicilio(domicilio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDomicilio);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Domicilio> buscarDomicilio(@PathVariable Long id) {
        Optional<Domicilio> domicilio = domicilioService.buscarDomicilio(id);
        return domicilio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<Domicilio>> listarDomicilios() {
        List<Domicilio> domicilios = domicilioService.listarDomicilios();
        return ResponseEntity.ok(domicilios);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Domicilio> actualizarDomicilio(@PathVariable Long id, @RequestBody Domicilio domicilio) {
        Domicilio domicilioActualizado = domicilioService.actualizarDomicilio(id, domicilio);
        return ResponseEntity.ok(domicilioActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarDomicilio(@PathVariable Long id) {
        domicilioService.eliminarDomicilio(id);
        return ResponseEntity.noContent().build();
    }
}
