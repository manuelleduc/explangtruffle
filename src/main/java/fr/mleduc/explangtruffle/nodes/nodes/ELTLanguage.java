package fr.mleduc.explangtruffle.nodes.nodes;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.source.Source;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.ELTAddNodeGen;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.ELTLiteralNode;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.ELTRootNode;

@TruffleLanguage.Registration(id = "etl", name = "ELT",
        version = "0.12", mimeType = ELTLanguage.MIME_TYPE)
//@ProvidedTags({StandardTags.CallTag.class, StandardTags.StatementTag.class, StandardTags.RootTag.class, DebuggerTags.AlwaysHalt.class})
public class ELTLanguage extends TruffleLanguage<ELTContext> {
    public static final String MIME_TYPE = "application/x-elt";

    @Override
    protected ELTContext createContext(Env env) {
        return null;
    }

    @Override
    protected Object getLanguageGlobal(ELTContext context) {
        return null;
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        return false;
    }


    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        Source source = request.getSource();
        RootNode evalMain = new ELTRootNode(this, ELTAddNodeGen.create(new ELTLiteralNode(1), new ELTLiteralNode(2)));
        return Truffle.getRuntime().createCallTarget(evalMain);
    }
}
