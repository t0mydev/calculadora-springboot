package cl.usm.calculadoraspringboot.services;


import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
    public double calcular(String operation, double number1, double number2) throws NumberFormatException{
        switch(operation){
            case "+": return number1 + number2;
            case "-": return number1 - number2;
            case "*": return number1 * number2;
            case "/": {
                if (number2 == 0) {
                    throw new NumberFormatException("Can't divide by zero");
                }
                return number1/number2;
            }
        }
        throw new NumberFormatException("Invalid");
    }
}