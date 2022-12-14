package pl.decyzje.Math;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.decyzje.Documents.Document;
import pl.decyzje.Terms.Term;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public final class DistanceMatrixCalculator {

    private final Distance distanceCalculator;
    private final ArrayList<Document> documents;
    public record Distances(Document doc, LinkedHashMap<Document, Double> distancesTo){}

    public Set<Distances> calcDistancesBetweenDocs() throws RuntimeException {
        final var distancesMatrix = new LinkedHashSet<Distances>();
        for (Document doc1 : this.documents) {
            final var distancesToOthers = new LinkedHashMap<Document, Double>();
            for (Document doc2 : this.documents) {
             final var distance = distanceCalculator.distanceBetween(new Distance.DocsPair(doc1, doc2));
             distancesToOthers.put(doc2, distance);
            }
            distancesMatrix.add(new Distances(doc1, distancesToOthers));
        }
        return distancesMatrix;
    }
    public static DistanceMatrixCalculator
    euclidesZoom(ArrayList<Document> documents, ArrayList<Term> terms, int pow, int sqrt) {
        final var euclidesZoomCalc = new EuclidesZoom(terms, pow, sqrt);
        return new DistanceMatrixCalculator(euclidesZoomCalc, documents);
    }
    public static DistanceMatrixCalculator euclides(ArrayList<Document> documents, ArrayList<Term> terms) {
        final var euclidesCalculator = new Euclides(terms);
        return new DistanceMatrixCalculator(euclidesCalculator, documents);
    }

    public static DistanceMatrixCalculator manhattan(ArrayList<Document> documents, ArrayList<Term> terms) {
        final var manhattanCalculator = new Manhattan(terms);
        return new DistanceMatrixCalculator(manhattanCalculator, documents);
    }

    public static DistanceMatrixCalculator czebyszew(ArrayList<Document> documents, ArrayList<Term> terms) {
        final var czebyszewCalculator = new Czebyszew(terms);
        return new DistanceMatrixCalculator(czebyszewCalculator, documents);
    }

   }
