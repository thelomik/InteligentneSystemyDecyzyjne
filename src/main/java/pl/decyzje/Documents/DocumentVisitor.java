package pl.decyzje.Documents;

import pl.decyzje.Exceptions.ISMException;

public interface DocumentVisitor  {
    void visit(Document document) throws ISMException;

}
