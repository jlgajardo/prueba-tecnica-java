package cl.jlgajardo.pruebatecnica.service.impl;

import cl.jlgajardo.pruebatecnica.exception.APIExceptionEmptyOrNullParam;
import cl.jlgajardo.pruebatecnica.repository.core.SPResponse;
import cl.jlgajardo.pruebatecnica.repository.model.Ventas;
import cl.jlgajardo.pruebatecnica.repository.sp.SPVentas;
import cl.jlgajardo.pruebatecnica.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImpl implements VentasService {

    @Autowired
    private SPVentas spVentas;

    @Override
    public List<Object> findAllVentas(Ventas ventas) {

        SPResponse spResponse = spVentas.query(ventas);

        if (spResponse.getErrorMsg() != null) {
            throw new APIExceptionEmptyOrNullParam(spResponse.getErrorMsg());
        }

        return null;
    }
}
