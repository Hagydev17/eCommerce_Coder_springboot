package edu.coderhouse.Proyecto_Pre_entrega.controllers;

import edu.coderhouse.Proyecto_Pre_entrega.entities.Cliente;
import edu.coderhouse.Proyecto_Pre_entrega.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus; // Para manejar respuestas http
import org.springframework.http.ResponseEntity;// Para manejar respuestas http

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/agregar")// Método para agregar un cliente
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.agregarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }
    // Método para eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        try {
            clienteService.eliminarCliente(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content en caso de éxito
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found en caso de error
        }
    }

    @GetMapping("/buscar/{id}")// Método para buscar un cliente por ID, en caso de no encontrar, lanzar error 404
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscarCliente(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
