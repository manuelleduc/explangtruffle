package fr.mleduc.explangtruffle.nodes.values;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.StandardTags;
import com.oracle.truffle.api.nodes.NodeInfo;
import fr.mleduc.explangtruffle.ELTDispatchNode;
import fr.mleduc.explangtruffle.ELTDispatchNodeGen;
import fr.mleduc.explangtruffle.nodes.ELTExpressionNode;

@NodeInfo(shortName = "invoke")
public class ELTInvokeNode extends ELTExpressionNode {

    @Child
    private ELTExpressionNode functionNode;
    @Children
    private final ELTExpressionNode[] argumentNodes;
    @Child
    private ELTDispatchNode dispatchNode;

    public ELTInvokeNode(ELTExpressionNode functionNode, ELTExpressionNode[] argumentNodes) {
        this.functionNode = functionNode;
        this.argumentNodes = argumentNodes;
        this.dispatchNode = ELTDispatchNodeGen.create();
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        Object function = functionNode.executeGeneric(frame);

        /*
         * The number of arguments is constant for one invoke node. During compilation, the loop is
         * unrolled and the execute methods of all arguments are inlined. This is triggered by the
         * ExplodeLoop annotation on the method. The compiler assertion below illustrates that the
         * array length is really constant.
         */
        CompilerAsserts.compilationConstant(argumentNodes.length);

        Object[] argumentValues = new Object[argumentNodes.length];
        for (int i = 0; i < argumentNodes.length; i++) {
            argumentValues[i] = argumentNodes[i].executeGeneric(frame);
        }
        return dispatchNode.executeDispatch(function, argumentValues);
    }

    @Override
    protected boolean isTaggedWith(Class<?> tag) {
        if (tag == StandardTags.CallTag.class) {
            return true;
        }
        return super.isTaggedWith(tag);
    }
}
