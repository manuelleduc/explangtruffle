package fr.mleduc.explangtruffle.nodes.nodes;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.nodes.RootNode;
import fr.mleduc.explangtruffle.ELLexicalScope;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.ELTExpressionNode;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.ELTIfNode;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.ELTRootNode;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.binary.*;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.values.ELTFloatNode;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.values.ELTIntNode;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.values.ELTVariableRefNodeGen;

import java.util.HashMap;

@TruffleLanguage.Registration(id = "etl", name = "ELT",
        version = "0.12", mimeType = ELTLanguage.MIME_TYPE)
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
        final ELTExpressionNode p1 = program1();



        TruffleLanguage.InlineParsingRequest

        final ELTExpressionNode p2 = program2(request.getFrame());


        final ELTIfNode ifn = new ELTIfNode(p1, new ELTIntNode(1000), new ELTFloatNode(2000));


        final RootNode evalMain = new ELTRootNode(this, p2);
        return Truffle.getRuntime().createCallTarget(evalMain);
    }

    private ELTExpressionNode program2(MaterializedFrame frame) {
        HashMap<String, FrameSlot> locals = new HashMap<>();
        FrameDescriptor frameDescriptor = new FrameDescriptor();
        FrameSlot frameSlota = frameDescriptor.findOrAddFrameSlot("a");

        frameSlota.setKind(FrameSlotKind.Object);

        frame.setObject(frameSlota, new ELTIntNode(42));

        return ELTAddNodeGen.create(new ELTIntNode(1), ELTVariableRefNodeGen.create(frameSlota));
    }

    private ELTExpressionNode program1() {
        final ELTAddNode p1 = ELTAddNodeGen.create(new ELTIntNode(1), new ELTIntNode(2));
        final ELTAddNode p2 = ELTAddNodeGen.create(ELTSubNodeGen.create(new ELTIntNode(42), new ELTIntNode(10)), new ELTIntNode(5));
        final ELTMultNode p3 = ELTMultNodeGen.create(new ELTIntNode(100), p2);
        final ELTDivNode p4 = ELTDivNodeGen.create(p3, new ELTIntNode(5));
        final ELTDivNode p5 = ELTDivNodeGen.create(new ELTIntNode(5), new ELTIntNode(4));
        final ELTFloatNode f740 = new ELTFloatNode(740);
        return ELTGreaterNodeGen.create(p4, f740);
    }
}
