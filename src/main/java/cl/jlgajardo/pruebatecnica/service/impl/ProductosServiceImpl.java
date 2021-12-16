package cl.jlgajardo.pruebatecnica.service.impl;

import cl.jlgajardo.pruebatecnica.exception.APIExceptionEmptyOrNullParam;
import cl.jlgajardo.pruebatecnica.repository.core.SPResponse;
import cl.jlgajardo.pruebatecnica.repository.model.Productos;
import cl.jlgajardo.pruebatecnica.repository.sp.SPProductos;
import cl.jlgajardo.pruebatecnica.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private SPProductos spProductos;

    @Override
    public List<Object> findProductos(Productos productos) {

        SPResponse spResponse = spProductos.query(productos);

        if (spResponse.getErrorMsg() != null) {
            throw new APIExceptionEmptyOrNullParam(spResponse.getErrorMsg());
        }


        return null;
    }
}
