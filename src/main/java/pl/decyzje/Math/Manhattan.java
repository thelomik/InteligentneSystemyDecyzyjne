package pl.decyzje.Math;


import pl.decyzje.Terms.Term;

import java.util.ArrayList;

public class Manhattan extends Distance{
    public Manhattan(ArrayList<Term> terms) {
        super(terms);
    }

    @Override
    double distanceBetween(DocsPair docsPair) throws RuntimeException {
        var sum = 0d;
        for (Term term : super.terms) {
            var diff = Math.abs(term.getOccurrences(docsPair.doc1().getName()) - term.getOccurrences(docsPair.doc2().getName()));
            sum += diff;
        }
        return sum;
    }
    }

