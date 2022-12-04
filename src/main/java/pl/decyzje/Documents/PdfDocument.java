package pl.decyzje.Documents;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import pl.decyzje.Exceptions.ISMException;
import pl.decyzje.Terms.Term;

import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

final class PdfDocument implements Document {

    public final Name name;
    private final List<String> pages = new LinkedList<>();
    private int n = 1;
    PdfDocument(Name name, Path pdfPath) {
        this.name = name;
        try {
            PdfReader reader = new PdfReader(pdfPath.toAbsolutePath().toString());
            for (int pageNo = 1; pageNo <= reader.getNumberOfPages(); pageNo++) {
                String textFromPage = PdfTextExtractor.getTextFromPage(reader, pageNo).toLowerCase();
                this.pages.add(textFromPage);
            }
        }catch (IOException e) {
            throw new RuntimeException(new ISMException(String.format("Could not read PDF: %s", pdfPath), e));
        }
    }



    @Override
    public int countAppearances(Term term) throws ISMException {
        int appearances = 0;
        for (var page : this.pages) {
            var splits = page.split(term.value);
            if(splits.length > 0)
                appearances += splits.length - 1;
        }
        return appearances;
    }

    @Override
    public Name getName() {
        return this.name;
    }
}