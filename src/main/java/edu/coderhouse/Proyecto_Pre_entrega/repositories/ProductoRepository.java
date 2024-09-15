package edu.coderhouse.Proyecto_Pre_entrega.repositories;

import edu.coderhouse.Proyecto_Pre_entrega.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
