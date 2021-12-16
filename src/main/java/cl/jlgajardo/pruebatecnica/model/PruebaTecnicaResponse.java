package cl.jlgajardo.pruebatecnica.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status", "result", "data"})
public class PruebaTecnicaResponse {


    @JsonProperty("status")
    private Status status;
    @JsonProperty("token")
    private String token;
    private Object data;

    public PruebaTecnicaResponse() {
    }


    public Status getStatus() {
        return status;
    }

    public PruebaTecnicaResponse setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getToken() {
        return token;
    }

    public PruebaTecnicaResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public Object getData() {
        return data;
    }

    public PruebaTecnicaResponse setData(Object data) {
        this.data = data;
        return this;
    }
}

