package pl.decyzje.Documents;



import java.io.FileNotFoundException;
import java.nio.file.Path;

public final class DocumentFactory {

    public static Document createDocument(String uniqueName, String source) throws RuntimeException, FileNotFoundException {
        if (source.endsWith(".pdf"))
            return new PdfDocument(new Document.Name(uniqueName), Path.of(source));




        throw new RuntimeException("Could not create document of certain type. Supported types are .pdf, .txt or existing WebPage");
    }

}