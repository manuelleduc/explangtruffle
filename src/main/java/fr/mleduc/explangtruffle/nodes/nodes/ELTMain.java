package fr.mleduc.explangtruffle.nodes.nodes;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.source.MissingMIMETypeException;
import com.oracle.truffle.api.source.MissingNameException;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.vm.PolyglotEngine;

import static java.lang.System.in;
import static java.lang.System.out;

public class ELTMain {
    public static void main(String[] args) throws MissingNameException, MissingMIMETypeException {
        out.println("== running on " + Truffle.getRuntime().getName());
        PolyglotEngine engine = PolyglotEngine.newBuilder().setIn(in).setOut(out).build();
        //assert engine.getLanguages().containsKey(ELTLanguage.MIME_TYPE);
        Source source = Source.newBuilder("").mimeType(ELTLanguage.MIME_TYPE).name("YOLO").build();

//        Map<String, ? extends PolyglotEngine.Language> languages = engine.getLanguages();
//        PolyglotEngine.Language language = languages.get(ELTLanguage.MIME_TYPE);
        PolyglotEngine.Value result = engine.eval(source);
    }
}
