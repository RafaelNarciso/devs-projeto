package br.com.aprendizado.modulo_01.controller;


import br.com.aprendizado.modulo_01.exception.UnsuportedMathOperationException;
import br.com.aprendizado.modulo_01.math.SimpleMath;
import br.com.aprendizado.modulo_01.requestconverter.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static br.com.aprendizado.modulo_01.requestconverter.NumberConverter.convertToDouble;
import static br.com.aprendizado.modulo_01.requestconverter.NumberConverter.validatePositiveNumbers;


@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    //http://localhost:8080/math/sum?number1=10&number2=20
    @RequestMapping("/sum/{numOne}/{numTwo}")
    public Double sum(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo)
            throws Exception {
        if (!NumberConverter.isNumeric(numOne) || !NumberConverter.isNumeric(numTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value ");
        return math.sum(NumberConverter.convertToDouble(numOne) , NumberConverter.convertToDouble(numTwo));

    }

    //http://localhost:8080/math/sub/5/8
    @RequestMapping("/sub/{numOne}/{numTwo}")
    public Double subtraction(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo) {
        validatePositiveNumbers(numOne, numTwo);
        return Math.abs(math.subtraction(NumberConverter.convertToDouble(numOne) , NumberConverter.convertToDouble(numTwo)));
    }


    //http://localhost:8080/math/mult/5/9
    @RequestMapping("/mult/{numOne}/{numTwo}")
    public Double multiplication(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo) {
        validatePositiveNumbers(numOne, numTwo);
        return Math.abs(math.multiplication(NumberConverter.convertToDouble(numOne) , NumberConverter.convertToDouble(numTwo)));
    }

    @RequestMapping("/div/{numOne}/{numTwo}")
    public Double division(
            @PathVariable String numOne,
            @PathVariable String numTwo) {

        validatePositiveNumbers(numOne, numTwo);

        Double a = convertToDouble(numOne);
        Double b = convertToDouble(numTwo);

        if (b == 0) {
            throw new UnsuportedMathOperationException("Division by zero is not allowed.");
        }

        return math.division(NumberConverter.convertToDouble(numOne) , NumberConverter.convertToDouble(numTwo));
    }


    //http://localhost:8080/math/average/5/9
    @RequestMapping("/average/{numOne}/{numTwo}")
    public Double average(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo) {
        validatePositiveNumbers(numOne, numTwo);
        return math.mean(NumberConverter.convertToDouble(numOne) , NumberConverter.convertToDouble(numTwo));
    }

    //http://localhost:8080/math/sqrt/16
    @RequestMapping("/sqrt/{num}")
    public Double squareRoot(
            @PathVariable("num") String num) {
        validatePositiveNumbers(num);
        Double value = convertToDouble(num);
        Double sqrt = Math.sqrt(value);
        return math.squareRoot(NumberConverter.convertToDouble(num));
    }

}
