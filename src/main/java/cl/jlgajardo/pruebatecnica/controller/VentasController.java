package cl.jlgajardo.pruebatecnica.controller;

import cl.jlgajardo.pruebatecnica.model.PruebaTecnicaResponse;
import cl.jlgajardo.pruebatecnica.model.ResponseApiBuilder;
import cl.jlgajardo.pruebatecnica.service.ProductosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/prueba_tecnica/${info.version}/ventas")
public class VentasController {


    public static final String VENTAS = "aca deben ir todas las ventas";

    @GetMapping(value = "/")
    @ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = PruebaTecnicaResponse.class),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    @ApiOperation(value = "Servicio que carga todas las ventas", notes = "Servicio que carga las ventas")
    public ResponseEntity<PruebaTecnicaResponse> findAllData() {

        return ResponseEntity.ok().body(ResponseApiBuilder.createSuccessResponse(VENTAS,""));
    }


    @GetMapping(value = "/find/{id}")
    @ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = PruebaTecnicaResponse.class),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    @ApiOperation(value = "Servicio que carga todas las ventas", notes = "Servicio que carga las ventas")
    public ResponseEntity<PruebaTecnicaResponse> findById(@PathVariable String id) {

        return ResponseEntity.ok().body(ResponseApiBuilder.createSuccessResponse(VENTAS, ""));
    }


    @DeleteMapping(value = "/{id}")
    @ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = PruebaTecnicaResponse.class),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    @ApiOperation(value = "Servicio que carga todas las ventas", notes = "Servicio que carga las ventas")
    public ResponseEntity<PruebaTecnicaResponse> deleteById(@PathVariable String id) {

        return ResponseEntity.ok().body(ResponseApiBuilder.createSuccessResponse(VENTAS,""));
    }


    @PostMapping(value = "/")
    @ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = PruebaTecnicaResponse.class),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    @ApiOperation(value = "Servicio que carga todas las ventas", notes = "Servicio que carga las ventas")
    public ResponseEntity<PruebaTecnicaResponse> create(@RequestBody Object body) {

        return ResponseEntity.ok().body(ResponseApiBuilder.createSuccessResponse(VENTAS,""));
    }
}
