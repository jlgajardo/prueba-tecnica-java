package cl.jlgajardo.pruebatecnica.repository.sp;


import cl.jlgajardo.pruebatecnica.repository.constants.SPContants;
import cl.jlgajardo.pruebatecnica.repository.model.Productos;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.jlgajardo.pruebatecnica.repository.core.AbstractStoredProcedure;

@Repository
public class SPProductos extends AbstractStoredProcedure {

    public SPProductos(
            @Qualifier(SPContants.SQLSERVER_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate,
            @Value(SPContants.SP_PRODUCTOS) String spName) {
        super(jdbcTemplate, spName);
        declareInputOuputParameters(Productos.class);
    }

}
