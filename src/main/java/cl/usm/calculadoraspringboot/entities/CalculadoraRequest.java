package cl.usm.calculadoraspringboot.entities;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CalculadoraRequest {
    private String operation;
    private Double number1;
    private Double number2; //fijarse en usar "Double" no "double" si quieres un numero en request, ya que las request pueden ser null, y double por defecto es 0 si está vacío

}
