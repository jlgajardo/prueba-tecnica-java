package cl.jlgajardo.pruebatecnica.repository.sp;


import cl.jlgajardo.pruebatecnica.repository.constants.SPContants;
import cl.jlgajardo.pruebatecnica.repository.core.AbstractStoredProcedure;
import cl.jlgajardo.pruebatecnica.repository.model.Compras;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SPCompras extends AbstractStoredProcedure {

    public SPCompras(
            @Qualifier(SPContants.SQLSERVER_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate,
            @Value(SPContants.SP_COMPRAS) String spName) {
        super(jdbcTemplate, spName);
        declareInputOuputParameters(Compras.class);
    }

}
