package cl.jlgajardo.pruebatecnica.repository.model;

import cl.jlgajardo.pruebatecnica.repository.annotations.InputOutputDefinition;
import cl.jlgajardo.pruebatecnica.repository.annotations.SPOutput;

@InputOutputDefinition
public class Facturas {


    @SPOutput
    private String errorMsg;
    @SPOutput
    private String outRetorno;
    @SPOutput
    private String successMsg;

    
    public String getErrorMsg() {
        return errorMsg;
    }

    public Facturas setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public String getOutRetorno() {
        return outRetorno;
    }

    public Facturas setOutRetorno(String outRetorno) {
        this.outRetorno = outRetorno;
        return this;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public Facturas setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
        return this;
    }

   
}
