package pl.decyzje;

import com.google.common.collect.Lists;
import pl.decyzje.Documents.Document;
import pl.decyzje.Documents.DocumentFactory;
import pl.decyzje.Math.DistanceMatrixCalculator;
import pl.decyzje.Terms.Term;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws RuntimeException, FileNotFoundException {



        final var terms= Lists.newArrayList(new Term("computer"),
                new Term("player"), new Term("controller"),
                new Term("gameplay"), new Term("experience"),
                new Term("game"), new Term("score"),
                new Term("opponent"), new Term("board"),
                new Term("strategy"));

        
        final var docs = Lists.newArrayList(DocumentFactory.createDocument("uv", "Documents/user_vector.pdf"),
                DocumentFactory.createDocument("D0", "Documents/D0.pdf"),
                DocumentFactory.createDocument("D1", "Documents/D1.pdf"),
                DocumentFactory.createDocument("D2", "Documents/D2.pdf"),
                DocumentFactory.createDocument("D3", "Documents/D3.pdf"),
                DocumentFactory.createDocument("D4", "Documents/D4.pdf"),
                DocumentFactory.createDocument("D5", "Documents/D5.pdf"),
                DocumentFactory.createDocument("D6", "Documents/D6.pdf"),
                DocumentFactory.createDocument("D7", "Documents/D6.pdf"),
                DocumentFactory.createDocument("D8", "Documents/D8.pdf"),
                DocumentFactory.createDocument("D9", "Documents/D9.pdf"),
                DocumentFactory.createDocument("10", "Documents/D10.pdf"),
                DocumentFactory.createDocument("11", "Documents/D11.pdf"),
                DocumentFactory.createDocument("12", "Documents/D12.pdf")


        );
        for (final var term : terms) {
            for (final var doc : docs) {
                term.visit(doc);
            }


        }

        for (final Term term : terms) {
            java.lang.System.out.printf("\t %-12s->", term.value);
            for (Document doc : docs) {
                term.visit(doc);
                java.lang.System.out.printf("\t %-3s: %-5d", doc.getName().name(), term.getOccurrences(doc.getName()));
            }
            java.lang.System.out.print("\n");

        }

        printEuclides(docs, terms);
        printEuclidesZoom(docs, terms, 2, 3);
        printManhattan(docs, terms);
        printCzebyszew(docs, terms);
        printBestMatch(docs, terms);
    }

    private static void printEuclides(ArrayList<Document> docs, ArrayList<Term> terms) throws RuntimeException {
        java.lang.System.out.print("\n Euclides: \n");
        final var euclidesDistanceMatrix = DistanceMatrixCalculator.euclides(docs, terms);
        final var distancesMatrix = euclidesDistanceMatrix.calcDistancesBetweenDocs();
        for (var distances : distancesMatrix) {
            java.lang.System.out.print("\t " + distances.doc().getName().name() + " -> ");
            for (var key : distances.distancesTo().keySet()) {
                java.lang.System.out.printf("\t %-3s: %-8.2f", key.getName().name(), distances.distancesTo().get(key));
            }
            java.lang.System.out.print("\n");

        }
    }

    private static void printCzebyszew(ArrayList<Document> docs, ArrayList<Term> terms) throws RuntimeException {
        System.out.print("\n Czebyszew: \n");
        final var czebyszewDistanceMatrix = DistanceMatrixCalculator.czebyszew(docs, terms);
        final var distancesMatrix = czebyszewDistanceMatrix.calcDistancesBetweenDocs();
        for (var distances : distancesMatrix) {
            System.out.print("\t" + distances.doc().getName().name() + " ->");
            for (var key : distances.distancesTo().keySet()) {
                java.lang.System.out.printf("\t %-3s: %-8.2f", key.getName().name(), distances.distancesTo().get(key));
            }
            System.out.print("\n");

        }
    }

    private static void printManhattan(ArrayList<Document> docs, ArrayList<Term> terms) throws RuntimeException {
        System.out.print("\n Manhattan: \n");
        final var manhattanDistanceMatrix = DistanceMatrixCalculator.manhattan(docs, terms);
        final var distancesMatrix = manhattanDistanceMatrix.calcDistancesBetweenDocs();
        for (var distances : distancesMatrix) {
            System.out.print("\t" + distances.doc().getName().name() + " ->");
            for (var key : distances.distancesTo().keySet()) {
                System.out.printf("\t%-3s: %-8.2f", key.getName().name(), distances.distancesTo().get(key));
            }
            System.out.print("\n");

        }
    }

    private static void printEuclidesZoom(ArrayList<Document> docs, ArrayList<Term> terms, int pow, int sqrt) throws RuntimeException {
        System.out.printf("\n Euclides zoom pow %d, sqrt %d : \n", pow, sqrt);
        final var euclidesZoomDistanceMatrix = DistanceMatrixCalculator.euclidesZoom(docs, terms, pow, sqrt);
        final var distancesMatrix = euclidesZoomDistanceMatrix.calcDistancesBetweenDocs();
        for (var distances : distancesMatrix) {
            System.out.print("\t" + distances.doc().getName().name() + " ->");
            for (var key : distances.distancesTo().keySet()) {
                System.out.printf("\t%-3s: %-8.2f", key.getName().name(), distances.distancesTo().get(key));
            }
            System.out.print("\n");

        }
    }

    private static void printBestMatch(ArrayList<Document> docs, ArrayList<Term> terms) throws RuntimeException  {
        System.out.print("\n\n");
        final var euclidesDistanceMatrix = DistanceMatrixCalculator.euclides(docs, terms);
        final var distancesMatrix = euclidesDistanceMatrix.calcDistancesBetweenDocs();
        Document closestDoc = null;
        DistanceMatrixCalculator.Distances userVectorDistances = null;
        for (final var distances : distancesMatrix) {

            if (distances.doc().getName().name().equals("uv")) {
                userVectorDistances = distances;

                for (final var doc : userVectorDistances.distancesTo().keySet()) {
                    double distance = userVectorDistances.distancesTo().get(doc);
                    if ((closestDoc == null || distance < userVectorDistances.distancesTo().get(closestDoc)) && !doc.getName().name().equals("uv"))
                        closestDoc = doc;
                }
            }
        }
        System.out.println("\t----------------------------------");
        System.out.println("\t User vector is similar to : " + closestDoc.getName().name());
        System.out.println("\t "+userVectorDistances.distancesTo().get(closestDoc));
        System.out.println("\t----------------------------------");
    }
}


