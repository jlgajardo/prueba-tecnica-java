package cl.jlgajardo.pruebatecnica.repository.model;

import cl.jlgajardo.pruebatecnica.repository.annotations.InputOutputDefinition;
import cl.jlgajardo.pruebatecnica.repository.annotations.SPInput;
import cl.jlgajardo.pruebatecnica.repository.annotations.SPOutput;

@InputOutputDefinition
public class Compras {


    @SPInput
    private String idDealer;
    @SPInput
    private String idConcepto;
    @SPInput
    private String idEstado;
    @SPInput
    private String fechaCurseIni;
    @SPInput
    private String fechaCurseFin;
    @SPOutput
    private String outRetorno;
    @SPOutput
    private String errorMsg;
    @SPOutput
    private String successMsg;

    
    public String getIdDealer() {
        return idDealer;
    }

    public Compras setIdDealer(String idDealer) {
        this.idDealer = idDealer;
        return this;
    }

    public String getIdConcepto() {
        return idConcepto;
    }

    public Compras setIdConcepto(String idConcepto) {
        this.idConcepto = idConcepto;
        return this;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public Compras setIdEstado(String idEstado) {
        this.idEstado = idEstado;
        return this;
    }

    public String getFechaCurseIni() {
        return fechaCurseIni;
    }

    public Compras setFechaCurseIni(String fechaCurseIni) {
        this.fechaCurseIni = fechaCurseIni;
        return this;
    }

    public String getFechaCurseFin() {
        return fechaCurseFin;
    }

    public Compras setFechaCurseFin(String fechaCurseFin) {
        this.fechaCurseFin = fechaCurseFin;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Compras setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public String getOutRetorno() {
        return outRetorno;
    }

    public Compras setOutRetorno(String outRetorno) {
        this.outRetorno = outRetorno;
        return this;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public Compras setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
        return this;
    }

   
}
