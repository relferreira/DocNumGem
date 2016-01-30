package com.relferreira.docnumgen.factories;

import com.relferreira.docnumgen.model.Doc;

/**
 * Created by renan on 29/01/2016.
 */
public class GeneratorFactory {

    public static Generator generate(Doc document) {
        if (document.getName().equals("CPF")) {
            return new CPFGenerator();
        }
        return null;
    }
}
