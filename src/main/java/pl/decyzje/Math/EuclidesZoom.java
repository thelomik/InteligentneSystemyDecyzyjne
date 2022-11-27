package pl.decyzje.Math;

import pl.decyzje.Exceptions.ISMException;
import pl.decyzje.Terms.Term;

import java.util.ArrayList;

public class EuclidesZoom extends Distance{
    private final int power;
    private final int sqrt;

    public EuclidesZoom(ArrayList<Term> terms,int zoom , int sqrt) {
        super(terms);
        this.power = zoom;
        this.sqrt = sqrt;
    }

    @Override
    double distanceBetween(Distance.DocsPair docsPair) throws ISMException {
        var sum = 0d;
        for (Term term : super.terms) {
            var diff =
                    term.getOccurrences(docsPair.doc1().getName()) - term.getOccurrences(docsPair.doc2().getName());
            sum += Math.pow(diff, this.power);
        }
        return Math.pow(sum, ((float)1/this.sqrt));
    }
}
