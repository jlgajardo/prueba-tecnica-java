package cl.jlgajardo.pruebatecnica.controller;

import cl.jlgajardo.pruebatecnica.model.Direccion;
import cl.jlgajardo.pruebatecnica.model.Persona;
import cl.jlgajardo.pruebatecnica.model.PruebaTecnicaResponse;
import cl.jlgajardo.pruebatecnica.model.ResponseApiBuilder;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/prueba_tecnica/${info.version}/clientes")
public class ClientesController {


    @GetMapping()
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = PruebaTecnicaResponse.class),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    @ApiOperation(value = "Servicio que carga todas las compras", notes = "Servicio que carga las compras")
    public ResponseEntity<PruebaTecnicaResponse> findAllData(@RequestHeader String token) {


        List<Persona> personaList = new ArrayList<>();

        Direccion direccion = new Direccion();
        direccion.setCalle("Av. Matta");
        direccion.setNumero(123);
        direccion.setComuna("Santiago");
        Persona persona1 = new Persona()
                .setId(1)
                .setNombre("Omar")
                .setApellido("Reyes")
                .setTelefono(999999999)
                .setFechaNacimiento("12/07/1989")
                .setRut("21984968-0")
                .setDireccion(direccion)
                .setActivo(1);

        Persona persona2 = new Persona()
                .setId(1)
                .setNombre("Fransico")
                .setApellido("Lopez")
                .setTelefono(999999999)
                .setRut("16770935-4")
                .setFechaNacimiento("12/07/1989")
                .setDireccion(direccion)
                .setActivo(1);

        Persona persona3 = new Persona()
                .setId(1)
                .setNombre("Alexander")
                .setApellido("Torres")
                .setTelefono(999999999)
                .setRut("9870890-1")
                .setFechaNacimiento("12/07/1989")
                .setDireccion(direccion)
                .setActivo(1);

        personaList.add(persona1);
        personaList.add(persona2);
        personaList.add(persona3);

        return ResponseEntity.ok().body(ResponseApiBuilder.createSuccessResponse(personaList, token));
    }
}
