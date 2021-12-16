package cl.jlgajardo.pruebatecnica.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status", "result", "data"})
public class ResponseForum {


    @JsonProperty("status")
    private Status status;
    @JsonProperty("result")
    private boolean result;
    private Object data;

    public ResponseForum() {
    }

    public ResponseForum(Object data) {
        status = new Status("OK", "Respuesta Exitosa");
        result = true;
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public ResponseForum setStatus(Status status) {
        this.status = status;
        return this;
    }

    public boolean isResult() {
        return result;
    }

    public ResponseForum setResult(boolean result) {
        this.result = result;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseForum setData(Object data) {
        this.data = data;
        return this;
    }
}
