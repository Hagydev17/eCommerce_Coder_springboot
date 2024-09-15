package edu.coderhouse.Proyecto_Pre_entrega.services;

import edu.coderhouse.Proyecto_Pre_entrega.entities.Domicilio;
import edu.coderhouse.Proyecto_Pre_entrega.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    // Método para agregar un nuevo domicilio
    public Domicilio agregarDomicilio(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    // Método para buscar un domicilio por ID
    public Optional<Domicilio> buscarDomicilio(Long id) {
        return domicilioRepository.findById(id);
    }

    // Método para listar todos los domicilios
    public List<Domicilio> listarDomicilios() {
        return domicilioRepository.findAll();
    }

    // Método para actualizar un domicilio existente
    public Domicilio actualizarDomicilio(Long id, Domicilio domicilio) {
        if (domicilioRepository.existsById(id)) {
            domicilio.setId(id);  // Asegúrate de tener un método setId en Domicilio
            return domicilioRepository.save(domicilio);
        }
        return null;
    }

    // Método para eliminar un domicilio por ID
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }
}
