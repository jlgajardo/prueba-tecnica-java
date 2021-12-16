package cl.jlgajardo.pruebatecnica.service;

import cl.jlgajardo.pruebatecnica.repository.model.Facturas;

import java.util.List;

public interface FacturasService {
    List<Object> findFacturas(Facturas facturas);
}
