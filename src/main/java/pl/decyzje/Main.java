package pl.decyzje;

import com.google.common.collect.Lists;
import pl.decyzje.Documents.Document;
import pl.decyzje.Documents.DocumentFactory;
import pl.decyzje.Exceptions.ISMException;
import pl.decyzje.Math.Distance;
import pl.decyzje.Math.DistanceMatrixCalculator;
import pl.decyzje.Terms.Term;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws ISMException {
        final var terms = Lists.newArrayList(
                new Term("computer"),
                new Term("player"),
                new Term("controller"),
                new Term("gameplay"),
                new Term("experience"),
                new Term("game"),
                new Term("score"),
                new Term("opponent"),
                new Term("board"),
                new Term("strategy"));
        final var docs = Lists.newArrayList(
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
                DocumentFactory.createDocument("D10", "Documents/D10.pdf"),
                DocumentFactory.createDocument("D11", "Documents/D11.pdf"),
                DocumentFactory.createDocument("D12", "Documents/D12.pdf")
//                DocumentFactory.createDocument("User vector", "D:\\InteligentneSystemyDecyzyjne\\InteligentneSystemyDecyzyjne\\Documents\\D11.pdf")
        );
        for (final var term : terms) {
            for (final var doc : docs) {
                term.visit(doc);
            }


        }

        for (final Term term : terms) {
            java.lang.System.out.printf("%-12s ->[", term.value);
            for (Document doc : docs) {
                term.visit(doc);
                java.lang.System.out.printf("%-3s: %-5d, ", doc.getName().name(), term.getOccurrences(doc.getName()));
            }
            java.lang.System.out.print("]\n");
        }

        printEuklidesDistanceMatrix(docs, terms);
        printEuklidesZoomDistanceMatrix(docs,terms,2,3);
        printBestMatch(docs,terms);
        printManhatanDistanceMatrix(docs,terms);
        printCzebyszewDistanceMatrix(docs,terms);
    }

    private static void printEuklidesDistanceMatrix(ArrayList<Document> docs, ArrayList<Term> terms) throws ISMException {
        java.lang.System.out.print("\n Euklides: \n");
        final var euklidesDistanceMatrix = DistanceMatrixCalculator.euklides(docs, terms);
        final var distancesMatrix = euklidesDistanceMatrix.calcDistancesBetweenDocs();
        for (var distances : distancesMatrix) {
            java.lang.System.out.print(distances.doc().getName().name() + " -> [");
            for (var key : distances.distancesTo().keySet()) {
                java.lang.System.out.printf("%-3s: %-8.2f, ", key.getName().name(), distances.distancesTo().get(key));
            }
            java.lang.System.out.print("]\n");
        }
    }

    private static void printCzebyszewDistanceMatrix(ArrayList<Document> docs, ArrayList<Term> terms) throws ISMException {
        java.lang.System.out.print("\n Czebyszew: \n");
        final var euklidesDistanceMatrix = DistanceMatrixCalculator.czebyszew(docs, terms);
        final var distancesMatrix = euklidesDistanceMatrix.calcDistancesBetweenDocs();
        for (var distances : distancesMatrix) {
            java.lang.System.out.print(distances.doc().getName().name() + " -> [");
            for (var key : distances.distancesTo().keySet()) {
                java.lang.System.out.printf("%-3s: %-8.2f, ", key.getName().name(), distances.distancesTo().get(key));
            }
            java.lang.System.out.print("]\n");
        }
    }
        private static void printManhatanDistanceMatrix(ArrayList<Document> docs, ArrayList<Term> terms) throws ISMException {
            java.lang.System.out.print("\n Manhatan: \n");
            final var euklidesDistanceMatrix = DistanceMatrixCalculator.manhatan(docs, terms);
            final var distancesMatrix = euklidesDistanceMatrix.calcDistancesBetweenDocs();
            for (var distances : distancesMatrix) {
                java.lang.System.out.print(distances.doc().getName().name() + " -> [");
                for (var key : distances.distancesTo().keySet()) {
                    java.lang.System.out.printf("%-3s: %-8.2f, ", key.getName().name(), distances.distancesTo().get(key));
                }
                java.lang.System.out.print("]\n");
            }
        }
        private static void printEuklidesZoomDistanceMatrix(ArrayList<Document> docs, ArrayList<Term> terms, int pow, int sqrt) throws ISMException {
            java.lang.System.out.printf("\n Euklides zoom pow %d, sqrt %d : \n", pow, sqrt);
            final var euklidesDistanceMatrix =
                    DistanceMatrixCalculator.euklidesZoom(docs, terms, pow, sqrt);
            final var distancesMatrix = euklidesDistanceMatrix.calcDistancesBetweenDocs();
            for (var distances : distancesMatrix) {
                java.lang.System.out.print(distances.doc().getName().name() + " -> [");
                for (var key : distances.distancesTo().keySet()) {
                    java.lang.System.out.printf("%-3s: %-8.2f, ", key.getName().name(), distances.distancesTo().get(key));
                }
                java.lang.System.out.print("]\n");
            }
        }
    private static void printBestMatch(ArrayList<Document> docs, ArrayList<Term> terms) throws ISMException {
        java.lang.System.out.print("\n\n");
        final var euklidesDistanceMatrix = DistanceMatrixCalculator.euklides(docs, terms);
        final var distancesMatrix = euklidesDistanceMatrix.calcDistancesBetweenDocs();
        for (final var distances : distancesMatrix) {
            DistanceMatrixCalculator.Distances userVectorDistances;
            if (distances.doc().getName().name().equals("User vector")) {
                userVectorDistances = distances;
                Document closestDoc = null;
                for (final var doc : userVectorDistances.distancesTo().keySet()) {
                    double distance = userVectorDistances.distancesTo().get(doc);
                    if ((closestDoc == null || distance < userVectorDistances.distancesTo().get(closestDoc))
                            && !doc.getName().name().equals("User vector"))
                        closestDoc = doc;
                }
                java.lang.System.out.println("Best Document similarity match is: " + closestDoc.getName().name() + "\n Based on the distance to other documents counted throughout various distance algorithms");
            }
        }

    }
    }

