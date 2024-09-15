package edu.coderhouse.Proyecto_Pre_entrega.repositories;

import edu.coderhouse.Proyecto_Pre_entrega.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
