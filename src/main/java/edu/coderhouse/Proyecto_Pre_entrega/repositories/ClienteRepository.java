package edu.coderhouse.Proyecto_Pre_entrega.repositories;

import edu.coderhouse.Proyecto_Pre_entrega.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
