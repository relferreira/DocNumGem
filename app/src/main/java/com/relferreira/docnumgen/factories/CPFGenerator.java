package com.relferreira.docnumgen.factories;

import java.util.Random;

import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.validation.CPFValidator;

/**
 * Created by renan on 29/01/2016.
 */
public class CPFGenerator extends CPFValidator implements Generator {

    @Override
    public String generateDoc() {
        final String cpfSemDigitos = new DigitoGenerator().generate(9);
        final String cpfComDigitos = cpfSemDigitos + calculaDigitos(cpfSemDigitos);
        return new CPFFormatter().format(cpfComDigitos);
    }

    private static String calculaDigitos(String cpfSemDigito) {
        DigitoPara digitoPara = new DigitoPara(cpfSemDigito);
        digitoPara.comMultiplicadoresDeAte(2, 11).complementarAoModulo().trocandoPorSeEncontrar("0", 10, 11).mod(11);

        String digito1 = digitoPara.calcula();
        digitoPara.addDigito(digito1);
        String digito2 = digitoPara.calcula();

        return digito1 + digito2;
    }


    public static class DigitoGenerator {
        private static final Random RANDOM = new Random();

        public String generate(int quantidade) {
            final StringBuilder digitos = new StringBuilder();
            for (int i = 0; i < quantidade; i++) {
                digitos.append(RANDOM.nextInt(10));
            }
            return digitos.toString();
        }
    }
}
