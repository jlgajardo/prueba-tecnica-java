package cl.jlgajardo.pruebatecnica.service;

import cl.jlgajardo.pruebatecnica.repository.model.Ventas;

import java.util.List;

public interface VentasService {
    List<Object> findAllVentas(Ventas ventas);
}
