package fr.mleduc.explangtruffle.nodes.statement;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import fr.mleduc.explangtruffle.ELTContext;
import fr.mleduc.explangtruffle.ELTFunction;
import fr.mleduc.explangtruffle.ELTExpressionNode;
import fr.mleduc.explangtruffle.ELTLanguage;

import static com.oracle.truffle.api.CompilerDirectives.CompilationFinal;

@NodeInfo(shortName = "func")
public class ELTFunctionLiteralNode extends ELTExpressionNode {

    private final String functionName;
    private final ContextReference<ELTContext> reference;


    public ELTFunctionLiteralNode(ELTLanguage language, String functionName) {
        this.functionName = functionName;
        this.reference = language.getContextReference();
    }

    @CompilationFinal
    private ELTFunction cachedFunction;

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        if (cachedFunction == null) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            /* We are about to change a @CompilationFinal field. */
            CompilerDirectives.transferToInterpreterAndInvalidate();
            /* First execution of the node: lookup the function in the function registry. */
            cachedFunction = reference.get().getFunctionRegistry().lookup(functionName, true);
        }
        return cachedFunction;
    }
}
