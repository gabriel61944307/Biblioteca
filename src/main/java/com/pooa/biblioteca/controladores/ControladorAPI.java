package com.pooa.biblioteca.controladores;

import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pessoa")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
}
)

public class ControladorAPI {
    
    @GetMapping("/pendencias/{id}")
    public static ResponseEntity<Boolean> verificarPendenciaResponse(@PathVariable("id") String numeroUfscar) {
        // Pessoa com pendencia = 3fa85f64-5717-4562-b3fc-2c963f66afa6
        boolean pendencia = ControladorPessoas.verificarPendencia(numeroUfscar);
        System.out.printf(String.valueOf(pendencia));
        return new ResponseEntity<>(pendencia, HttpStatus.OK);
    }
}
