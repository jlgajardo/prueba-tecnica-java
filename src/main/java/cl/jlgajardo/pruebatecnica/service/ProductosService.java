package cl.jlgajardo.pruebatecnica.service;

import cl.jlgajardo.pruebatecnica.repository.model.Productos;

import java.util.List;

public interface ProductosService {
    List<Object> findProductos(Productos productos);
}
