package cl.jlgajardo.pruebatecnica.repository.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SPResponse {

    @JsonProperty("outTotalReg")
    private int outTotalReg;
    @JsonProperty("outPaginacion")
    private int outPaginacion;
    @JsonProperty("outRetorno")
    private int outRetorno;
    @JsonProperty("errorMsg")
    private String errorMsg;
    @JsonProperty("successMsg")
    private String successMsg;

    @JsonProperty("#result-set-1")
    private List<Map<String, Object>> items = new ArrayList<>();

    @JsonProperty("#result-set-2")
    private List<Map<String, Object>> grafico = new ArrayList<>();

    @JsonProperty("#result-set-3")
    private List<Map<String, Object>> crossAxis = new ArrayList<>();

    public int getOutTotalReg() {
        return outTotalReg;
    }

    public SPResponse setOutTotalReg(int outTotalReg) {
        this.outTotalReg = outTotalReg;
        return this;
    }

    public int getOutPaginacion() {
        return outPaginacion;
    }

    public SPResponse setOutPaginacion(int outPaginacion) {
        this.outPaginacion = outPaginacion;
        return this;
    }

    public int getOutRetorno() {
        return outRetorno;
    }

    public SPResponse setOutRetorno(int outRetorno) {
        this.outRetorno = outRetorno;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public SPResponse setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public SPResponse setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
        return this;
    }

    public List<Map<String, Object>> getItems() {
        return new ArrayList<>(items);
    }

    public SPResponse setItems(List<Map<String, Object>> items) {
        this.items.clear();
        this.items.addAll(items);
        return this;
    }

    public List<Map<String, Object>> getGrafico() {
        return new ArrayList<>(grafico);
    }

    public SPResponse setGrafico(List<Map<String, Object>> grafico) {
        this.grafico.clear();
        this.grafico.addAll(grafico);
        return this;
    }


    public List<Map<String, Object>> getCrossAxis() {
        return new ArrayList<>(crossAxis);
    }

    public SPResponse setCrossAxis(List<Map<String, Object>> crossAxis) {
        this.crossAxis.clear();
        this.crossAxis.addAll(crossAxis);
        return this;
    }
}
