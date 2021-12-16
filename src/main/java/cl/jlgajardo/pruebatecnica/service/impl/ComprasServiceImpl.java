package cl.jlgajardo.pruebatecnica.service.impl;

import cl.jlgajardo.pruebatecnica.repository.model.Compras;
import cl.jlgajardo.pruebatecnica.repository.sp.SPCompras;
import cl.jlgajardo.pruebatecnica.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComprasServiceImpl implements ComprasService {

    public static final String YYYY_MM_DD = "yyyy/MM/dd";
    @Autowired
    private SPCompras spCompras;


    @Override
    public Object findCompras(Compras compras) {
        return null;
    }
}
