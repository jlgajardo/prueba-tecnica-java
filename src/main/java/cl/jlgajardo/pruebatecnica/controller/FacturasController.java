package cl.jlgajardo.pruebatecnica.controller;

import cl.jlgajardo.pruebatecnica.model.PruebaTecnicaResponse;
import cl.jlgajardo.pruebatecnica.model.ResponseApiBuilder;
import cl.jlgajardo.pruebatecnica.service.ProductosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping("/prueba_tecnica/${info.version}/facturas")
public class FacturasController {


    @GetMapping(value = "${info.version}/")
    @ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = PruebaTecnicaResponse.class),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    @ApiOperation(value = "Servicio que carga todas las facturas", notes = "Servicio que carga las facturas")
    public ResponseEntity<PruebaTecnicaResponse> findAllData() {

        return ResponseEntity.ok().body(ResponseApiBuilder.createSuccessResponse("aca deben ir todas las facturas",""));
    }
}
