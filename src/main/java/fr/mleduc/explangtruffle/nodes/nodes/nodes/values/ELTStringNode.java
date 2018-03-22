package fr.mleduc.explangtruffle.nodes.nodes.nodes.values;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.ELTExpressionNode;

@NodeInfo(description = "string const")
public final class ELTStringNode extends ELTExpressionNode {
    private final String value;

    public ELTStringNode(String value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public String executeString(VirtualFrame frame) throws UnexpectedResultException {
        return value;
    }
}
