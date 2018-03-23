package fr.mleduc.explangtruffle.nodes.values;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import fr.mleduc.explangtruffle.nodes.ELTExpressionNode;

@NodeInfo(description = "bool const")
public final class ELTBoolNode extends ELTExpressionNode {
    private final boolean value;

    public ELTBoolNode(boolean value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public boolean executeBool(VirtualFrame frame) throws UnexpectedResultException {
        return value;
    }
}
