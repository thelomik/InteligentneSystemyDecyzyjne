package pl.decyzje.Math;

import pl.decyzje.Terms.Term;

import java.util.ArrayList;

public class Euclides extends Distance{



    public Euclides(ArrayList<Term> terms) {
        super(terms);
    }

    @Override
    double distanceBetween(DocsPair docsPair) throws RuntimeException {
        var sum = 0d;
        for (Term term : super.terms) {
            var diff =
                    term.getOccurrences(docsPair.doc1().getName()) - term.getOccurrences(docsPair.doc2().getName());
            sum += Math.pow(diff, 2);
        }
        return Math.sqrt(sum);
    }
}
