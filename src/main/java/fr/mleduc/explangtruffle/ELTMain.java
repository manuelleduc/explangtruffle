package fr.mleduc.explangtruffle;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.vm.PolyglotEngine;

import static java.lang.System.in;
import static java.lang.System.out;

public class ELTMain {
    public static void main(String[] args) {
        out.println("== running on " + Truffle.getRuntime().getName());
        PolyglotEngine engine = PolyglotEngine.newBuilder().setIn(in).setOut(out).build();
        Source source = Source.newBuilder("").mimeType(ELTLanguage.MIME_TYPE).name("ELT").build();
        PolyglotEngine.Value result = engine.eval(source);

        engine.dispose();
    }
}
