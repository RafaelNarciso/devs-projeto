package br.com.aprendizado.modulo_01.math;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimpleMath {


    public Double sum(Double numOne,Double numTwo) {
        return numOne + numTwo;
    }

    public Double subtraction(Double numOne, Double numTwo) {
        return Math.abs(numOne - numTwo);
    }

    public Double multiplication(Double numOne, Double numTwo) {
        return Math.abs(numOne * numTwo);
    }

    public Double division(Double a, Double b) {
        return BigDecimal.valueOf(a)
                .divide(BigDecimal.valueOf(b), 2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public Double mean(Double numOne, Double numTwo) {
        return Math.abs(numOne + numTwo)/2;
    }

    public Double squareRoot(Double numOne) {
        double sqrt = Math.sqrt(numOne);
        return BigDecimal.valueOf(sqrt).setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

}
