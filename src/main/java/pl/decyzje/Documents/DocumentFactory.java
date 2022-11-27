package pl.decyzje.Documents;

import pl.decyzje.Exceptions.ISMException;

import java.nio.file.Path;

public final class DocumentFactory {

    public static Document createDocument(String uniqueName, String source) throws ISMException {
        if (source.endsWith(".pdf"))
            return new PdfDocument(new Document.Name(uniqueName), Path.of(source));

        throw new ISMException("Could not create document of certain type. Supported types are .pdf, .txt or existing WebPage");
    }

}