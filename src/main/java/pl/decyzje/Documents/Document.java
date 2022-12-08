package pl.decyzje.Documents;


import pl.decyzje.Terms.Term;

import javax.annotation.processing.FilerException;

public interface Document {
    int countAppearances(Term term) throws RuntimeException;
    Name getName();

    record Name(String name){}
}
