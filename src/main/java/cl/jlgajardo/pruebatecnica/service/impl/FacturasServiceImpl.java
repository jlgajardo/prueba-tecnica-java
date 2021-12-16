package cl.jlgajardo.pruebatecnica.service.impl;

import cl.jlgajardo.pruebatecnica.exception.APIExceptionEmptyOrNullParam;
import cl.jlgajardo.pruebatecnica.repository.core.SPResponse;
import cl.jlgajardo.pruebatecnica.repository.model.Facturas;
import cl.jlgajardo.pruebatecnica.repository.sp.SPFacturas;
import cl.jlgajardo.pruebatecnica.service.FacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturasServiceImpl implements FacturasService {

    @Autowired
    private SPFacturas spFacturas;


    @Override
    public List<Object> findFacturas(Facturas facturas) {
        SPResponse spResponse = spFacturas.query(facturas);

        if (spResponse.getErrorMsg() != null) {
            throw new APIExceptionEmptyOrNullParam(spResponse.getErrorMsg());
        }


        return null;
    }
}
