package edu.coderhouse.Proyecto_Pre_entrega.services;

import edu.coderhouse.Proyecto_Pre_entrega.entities.Pedido;
import edu.coderhouse.Proyecto_Pre_entrega.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Crear un nuevo pedido
    public Pedido agregarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Buscar un pedido por ID
    public Optional<Pedido> buscarPedido(Long id) {
        return pedidoRepository.findById(id);
    }

    // Listar todos los pedidos
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    // Actualizar un pedido existente
    public Pedido actualizarPedido(Long id, Pedido pedido) {
        if (pedidoRepository.existsById(id)) {
            pedido.setId(id);
            return pedidoRepository.save(pedido);
        } else {
            throw new RuntimeException("Pedido no encontrado con ID: " + id);
        }
    }

    // Eliminar un pedido por ID
    public void eliminarPedido(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Pedido no encontrado con ID: " + id);
        }
    }
}
