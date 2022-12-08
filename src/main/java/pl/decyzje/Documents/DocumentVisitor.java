package pl.decyzje.Documents;



public interface DocumentVisitor  {
    void visit(Document document) throws RuntimeException;

}
