package pl.decyzje.Documents;

import lombok.RequiredArgsConstructor;
import pl.decyzje.Exceptions.ISMException;


import java.util.*;



@RequiredArgsConstructor
public class ConsoleArgsParser {
    private final String[] args;

    public List<String> pareProposeVectorValues() throws ISMException {
        final int termsStart = this.findProposeStartIndex();
        final var proposeVector = new ArrayList<String>();
        for (int i = termsStart; i < args.length; i++) {
            if (!args[i].equals("-d") && !args[i].equals("-t") && !args[i].equals("-p"))
                proposeVector.add(args[i]);
            else
                break;
        }
        return proposeVector;
    }
    private int findDocumentsStartIndex() throws ISMException {
        for(int i = 0; i < args.length; i++) {
            if (args[i].equals("-d"))
                return i + 1;
        }
        throw new ISMException("Did not specified documents");
    }

    private int findTermsStartIndex() throws ISMException {
        for(int i = 0; i < args.length; i++) {
            if (args[i].equals("-t"))
                return i + 1;
        }
        throw new ISMException("Did not specified terms");
    }

    private int findProposeStartIndex() throws ISMException {
        for(int i = 0; i < args.length; i++) {
            if (args[i].equals("-p"))
                return i + 1;
        }
        throw new ISMException("Did not specified propose vector");
    }
}
