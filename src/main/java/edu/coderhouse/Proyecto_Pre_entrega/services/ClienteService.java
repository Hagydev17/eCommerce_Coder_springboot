package edu.coderhouse.Proyecto_Pre_entrega.services;

import edu.coderhouse.Proyecto_Pre_entrega.entities.Cliente;
import edu.coderhouse.Proyecto_Pre_entrega.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public void eliminarCliente(Long clienteId) {
        clienteRepository.deleteById(clienteId); // Eliminar cliente directamente
    }

    public Optional<Cliente> buscarCliente(Long id) {
        return clienteRepository.findById(id);
    }
}
