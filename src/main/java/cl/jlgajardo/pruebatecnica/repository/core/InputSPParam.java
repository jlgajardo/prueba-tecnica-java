package cl.jlgajardo.pruebatecnica.repository.core;

import java.util.function.Supplier;

public class InputSPParam {

    private String paramName;
    private Object value;

    public InputSPParam(String paramName, Object value) {
        this.paramName = paramName;
        this.value = value;
    }

    public InputSPParam(String paramName, Supplier<Object> value) {
        this.paramName = paramName;
        this.value = value.get();
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
