package br.com.aprendizado.modulo_01.requestconverter;

import br.com.aprendizado.modulo_01.exception.UnsuportedMathOperationException;

public class NumberConverter {


    public static Double convertToDouble(String strnumber) throws IllegalArgumentException {
        if (strnumber == null || strnumber.isEmpty())
            throw new UnsuportedMathOperationException("Please set a numeric value");
        String number = strnumber.replace(",", ".");
        return Double.parseDouble(number);

    }

    public static boolean isNumeric(String strnumber) {
        if (strnumber == null || strnumber.isEmpty()) return false;
        String number = strnumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static boolean isPositivo(String number) {
        return convertToDouble(number) >= 0;
    }


    public static void validatePositiveNumbers(String... numbers) {
        for (String number : numbers) {
            if (!isNumeric(number) || !isPositivo(number)) {
                throw new UnsuportedMathOperationException("Please set a numeric value");
            }
        }
    }

}
