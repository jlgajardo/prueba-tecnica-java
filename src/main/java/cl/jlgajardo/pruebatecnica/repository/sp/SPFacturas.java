package cl.jlgajardo.pruebatecnica.repository.sp;


import cl.jlgajardo.pruebatecnica.repository.constants.SPContants;
import cl.jlgajardo.pruebatecnica.repository.model.Facturas;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.jlgajardo.pruebatecnica.repository.core.AbstractStoredProcedure;

@Repository
public class SPFacturas extends AbstractStoredProcedure {

    public SPFacturas(
            @Qualifier(SPContants.SQLSERVER_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate,
            @Value(SPContants.SP_FACTURAS) String spName) {
        super(jdbcTemplate, spName);
        declareInputOuputParameters(Facturas.class);
    }

}
