package cl.jlgajardo.pruebatecnica.repository.core;

public class DeclaredSpParam {

    private int jdbcType;
    private String paramName;

    public DeclaredSpParam(int jdbcType, String paramName) {
        this.jdbcType = jdbcType;
        this.paramName = paramName;
    }

    public int getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(int jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
}
