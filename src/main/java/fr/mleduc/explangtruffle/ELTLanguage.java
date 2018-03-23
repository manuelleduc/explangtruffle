package fr.mleduc.explangtruffle;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.nodes.RootNode;
import fr.mleduc.explangtruffle.nodes.binary.ELTAddNodeGen;
import fr.mleduc.explangtruffle.nodes.statement.ELTBlockNode;
import fr.mleduc.explangtruffle.nodes.statement.ELTFunctionLiteralNode;
import fr.mleduc.explangtruffle.nodes.statement.ELTPrintNode;
import fr.mleduc.explangtruffle.nodes.values.*;

import java.util.HashMap;
import java.util.Map;

@TruffleLanguage.Registration(id = "etl", name = "ELT",
        version = "0.12", mimeType = ELTLanguage.MIME_TYPE)
public class ELTLanguage extends TruffleLanguage<ELTContext> {
    public static final String MIME_TYPE = "application/x-elt";


    @Override
    protected ELTContext createContext(Env env) {
        return new ELTContext(new ELTFunctionRegistry(this));
    }

    @Override
    protected Object getLanguageGlobal(ELTContext context) {
        return null;
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        return false;
    }

    static class LexicalScope {
        protected final LexicalScope outer;
        protected final Map<String, FrameSlot> locals;

        LexicalScope(LexicalScope outer) {
            this.outer = outer;
            this.locals = new HashMap<>();
            if (outer != null) {
                locals.putAll(outer.locals);
            }
        }
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        final ELTExpressionNode p1 = program1();


        final FrameDescriptor frameDescriptorAdd = new FrameDescriptor();
        this.createAssignment("y", new ELTArgumentNode(0), frameDescriptorAdd, new LexicalScope(null));
        final ELTExpressionNode xV = new ELTArgumentNode(0);
        final ELTIntNode rightChild = new ELTIntNode(42);
        final ELTBlockNode addFunction = new ELTBlockNode(new ELTStatementNode[]{
                new ELTPrintNode(ELTAddNodeGen.create(xV, rightChild))
        });


        final FrameDescriptor frameDescriptor = new FrameDescriptor();
        final ContextReference<ELTContext> contextReference = this.getContextReference();
        final ELTContext eltContext = contextReference.get();
        final ELTFunctionRegistry functionRegistry = eltContext.getFunctionRegistry();
        functionRegistry.register("add", new ELTRootNode(this, frameDescriptorAdd, addFunction));

        final LexicalScope lexicalScope = new LexicalScope(null);
        final ELTBlockNode block = new ELTBlockNode(new ELTStatementNode[]{
                this.createAssignment("x", new ELTIntNode(1), frameDescriptor, lexicalScope),
                new ELTInvokeNode(new ELTFunctionLiteralNode(this, "add"), new ELTExpressionNode[]{
                        ELTVariableRefNodeGen.create(frameDescriptor.findFrameSlot("x"))
                })
        });

        final RootNode evalMain = new ELTRootNode(this, frameDescriptor, block);
        return Truffle.getRuntime().createCallTarget(evalMain);
    }

    private ELTStatementNode createAssignment(String name, ELTExpressionNode valueNode, FrameDescriptor frameDescriptor, LexicalScope lexicalScope) {
        final FrameSlot frameSlot = initFrameSlot(name, frameDescriptor, lexicalScope);
        return ELTVariableNodeGen.create(valueNode, frameSlot);
    }

    private FrameSlot initFrameSlot(String name, FrameDescriptor frameDescriptor, LexicalScope lexicalScope) {
        final FrameSlot frameSlot = frameDescriptor.findOrAddFrameSlot(name);
        lexicalScope.locals.put(name, frameSlot);
        return frameSlot;
    }

    private ELTExpressionNode program2() {
        /*HashMap<String, FrameSlot> locals = new HashMap<>();
        FrameDescriptor frameDescriptor = new FrameDescriptor();
        FrameSlot frameSlota = frameDescriptor.findOrAddFrameSlot("a");

        frameSlota.setKind(FrameSlotKind.Object);

        frame.setObject(frameSlota, new ELTIntNode(42));*/

        //return ELTAddNodeGen.create(new ELTIntNode(1), ELTVariableRefNodeGen.create());

        return null;
    }

    private ELTExpressionNode program1() {
//        final ELTAddNode p1 = ELTAddNodeGen.create(new ELTIntNode(1), new ELTIntNode(2));
//        final ELTAddNode p2 = ELTAddNodeGen.create(ELTSubNodeGen.create(new ELTIntNode(42), new ELTIntNode(10)), new ELTIntNode(5));
//        final ELTMultNode p3 = ELTMultNodeGen.create(new ELTIntNode(100), p2);
//        final ELTDivNode p4 = ELTDivNodeGen.create(p3, new ELTIntNode(5));
//        final ELTDivNode p5 = ELTDivNodeGen.create(new ELTIntNode(5), new ELTIntNode(4));
//        final ELTFloatNode f740 = new ELTFloatNode(740);
//        return ELTGreaterNodeGen.create(p4, f740);
        return null;
    }
}
