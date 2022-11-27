package pl.decyzje.Documents;

import pl.decyzje.Exceptions.ISMException;
import pl.decyzje.Terms.Term;

import javax.annotation.processing.FilerException;

public interface Document {
    int countOccurrences(Term term) throws ISMException;
    Name getName();

    record Name(String name){}
}
