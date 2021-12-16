package cl.jlgajardo.pruebatecnica.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status", "result", "paginacion", "data"})
public class GetResponse extends PruebaTecnicaResponse {


    @JsonProperty("paginacion")
    private Object paginacion;

    public GetResponse() {
        super();
    }

    public Object getPaginacion() {
        return paginacion;
    }

    public GetResponse setPaginacion(Object paginacion) {
        this.paginacion = paginacion;
        return this;
    }
}
