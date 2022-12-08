package pl.decyzje.Math;

import lombok.RequiredArgsConstructor;
import pl.decyzje.Documents.Document;

import pl.decyzje.Terms.Term;

import java.util.ArrayList;

@RequiredArgsConstructor
public abstract class Distance {
    record DocsPair(Document doc1, Document doc2){}
    final ArrayList<Term> terms;
    abstract double distanceBetween(final DocsPair docsPair) throws RuntimeException;



}
