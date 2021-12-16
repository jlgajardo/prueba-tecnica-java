package cl.jlgajardo.pruebatecnica.model;

import org.springframework.http.HttpStatus;


public class ResponseApiBuilder {

    public static final boolean SUCCESS = true;
    public static final String RESPUESTA_EXITOSA = "Respuesta exitosa";

    private ResponseApiBuilder() {
    }

    public static PruebaTecnicaResponse createSuccessResponse(Object data, String token) {
        return createCommonResponse(data, token);
    }


    private static PruebaTecnicaResponse createCommonResponse(Object data, String token) {

        PruebaTecnicaResponse pruebaTecnicaREsponse = new PruebaTecnicaResponse();
        pruebaTecnicaREsponse.setStatus(new Status(String.valueOf(HttpStatus.OK.value()), RESPUESTA_EXITOSA));
        pruebaTecnicaREsponse.setToken(token);
        pruebaTecnicaREsponse.setData(data);
        return pruebaTecnicaREsponse;

    }


}
