package pl.decyzje.Terms;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.decyzje.Documents.Document;
import pl.decyzje.Documents.DocumentVisitor;


import java.util.HashMap;
import java.util.Map;


@Data
@RequiredArgsConstructor
public final class Term implements DocumentVisitor {

    @Getter public final String value;
    private final Map<Document.Name, Integer> documentOccurrences = new HashMap<>();

    @Override
    public void visit(Document document) throws RuntimeException {
        documentOccurrences.put(document.getName(), document.countAppearances(this));
    }

    public int getOccurrences(Document.Name name) throws RuntimeException {
        if (documentOccurrences.containsKey(name))
            return this.documentOccurrences.get(name);
        else
            throw new RuntimeException("The document have not been read yet");
    }
}
