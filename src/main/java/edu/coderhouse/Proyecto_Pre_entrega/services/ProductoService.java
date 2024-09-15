package edu.coderhouse.Proyecto_Pre_entrega.services;

import edu.coderhouse.Proyecto_Pre_entrega.entities.Producto;
import edu.coderhouse.Proyecto_Pre_entrega.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    // Crear o actualizar un producto
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Buscar un producto por ID
    public Optional<Producto> buscarProducto(Long id) {
        return productoRepository.findById(id);
    }

    // Listar todos los productos
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    // Actualizar un producto
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        if (productoRepository.existsById(id)) {
            productoActualizado.setId(id);
            return productoRepository.save(productoActualizado);
        } else {
            return null;// Lanzar una excepción o manejar el caso en el que el producto no existe
        }
    }

    // Eliminar un producto por ID
    public void eliminarProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        } else {
            // Manejar el caso en el que el producto no existe
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
    }
}
