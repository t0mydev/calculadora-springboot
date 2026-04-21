package cl.usm.calculadoraspringboot.controllers;

import cl.usm.calculadoraspringboot.entities.CalculadoraRequest;
import cl.usm.calculadoraspringboot.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {
    @Autowired
    private CalculadoraService calculadoraService;

    @PostMapping("/calcular")
    public ResponseEntity<?> calcular(@RequestBody CalculadoraRequest calculadoraRequest){

        try {
            var result = calculadoraService.calcular(calculadoraRequest.getOperation(), calculadoraRequest.getNumber1(), calculadoraRequest.getNumber2());

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(NumberFormatException exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }catch(Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
