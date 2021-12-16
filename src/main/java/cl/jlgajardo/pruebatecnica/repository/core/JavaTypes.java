package cl.jlgajardo.pruebatecnica.repository.core;

import java.sql.Types;

public enum JavaTypes {
    STRING,
    CHARACTER,
    CHAR,
    INTEGER,
    INT;

    public int toJdbcType() {


        switch (this) {
            case STRING:
            case CHARACTER:
            case CHAR:
                return Types.VARCHAR;
            case INTEGER:
            case INT:
                return Types.INTEGER;
            default:
                throw new IllegalStateException("Unexpected value: " + this.name());
        }
    }
}
