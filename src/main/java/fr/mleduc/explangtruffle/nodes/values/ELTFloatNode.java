package fr.mleduc.explangtruffle.nodes.values;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import fr.mleduc.explangtruffle.nodes.ELTExpressionNode;

@NodeInfo(description = "float const")
public final class ELTFloatNode extends ELTExpressionNode {
    private final float value;

    public ELTFloatNode(float value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public float executeFloat(VirtualFrame frame) throws UnexpectedResultException {
        return value;
    }
}
