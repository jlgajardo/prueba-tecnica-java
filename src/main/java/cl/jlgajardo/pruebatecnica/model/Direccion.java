package cl.jlgajardo.pruebatecnica.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Direccion {
    private String calle;
    private long numero;
    private String comuna;
    private String nombre;

    @JsonProperty("calle")
    public String getCalle() {
        return calle;
    }

    @JsonProperty("calle")
    public void setCalle(String value) {
        this.calle = value;
    }

    @JsonProperty("numero")
    public long getNumero() {
        return numero;
    }

    @JsonProperty("numero")
    public void setNumero(long value) {
        this.numero = value;
    }

    @JsonProperty("comuna")
    public String getComuna() {
        return comuna;
    }

    @JsonProperty("comuna")
    public void setComuna(String value) {
        this.comuna = value;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String value) {
        this.nombre = value;
    }
}
