package fr.mleduc.explangtruffle.nodes.nodes;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.nodes.RootNode;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.*;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.values.ELTIntNode;

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
        ELTAddNode p1 = ELTAddNodeGen.create(new ELTIntNode(1), new ELTIntNode(2));
        ELTAddNode p2 = ELTAddNodeGen.create(ELTSubNodeGen.create(new ELTIntNode(42), new ELTIntNode(10)), new ELTIntNode(5));
        ELTMultNode p3 = ELTMultNodeGen.create(new ELTIntNode(100), p2);
        ELTDivNode p4 = ELTDivNodeGen.create(p3, new ELTIntNode(5));
        ELTDivNode p5 = ELTDivNodeGen.create(new ELTIntNode(5), new ELTIntNode(4));
        System.out.println(p4);
        final RootNode evalMain = new ELTRootNode(this, p4);
        return Truffle.getRuntime().createCallTarget(evalMain);
    }
}
