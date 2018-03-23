package fr.mleduc.explangtruffle.nodes.values;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import fr.mleduc.explangtruffle.nodes.ELTExpressionNode;

@NodeInfo(description = "int const")
public final class ELTIntNode extends ELTExpressionNode {
    private final int value;

    public ELTIntNode(int value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public int executeInt(VirtualFrame frame) throws UnexpectedResultException {
        return value;
    }
}
