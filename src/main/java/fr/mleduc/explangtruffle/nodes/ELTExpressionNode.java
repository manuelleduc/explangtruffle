package fr.mleduc.explangtruffle.nodes;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import fr.mleduc.explangtruffle.ELTTypes;
import fr.mleduc.explangtruffle.ELTTypesGen;

@TypeSystemReference(ELTTypes.class)
@NodeInfo(description = "Abstract expression node")
public abstract class ELTExpressionNode extends ELTStatementNode {
    public abstract Object executeGeneric(VirtualFrame frame);


    @Override
    public void executeVoid(VirtualFrame frame) {
        executeGeneric(frame);
    }

    public int executeInt(VirtualFrame frame) throws UnexpectedResultException {
        return ELTTypesGen.expectInteger(executeGeneric(frame));
    }

    public boolean executeBool(VirtualFrame frame) throws UnexpectedResultException {
        return ELTTypesGen.expectBoolean(executeGeneric(frame));
    }

    public float executeFloat(VirtualFrame frame) throws UnexpectedResultException {
        return ELTTypesGen.expectFloat(executeGeneric(frame));
    }

    public String executeString(VirtualFrame frame) throws UnexpectedResultException {
        return ELTTypesGen.expectString(executeGeneric(frame));
    }
}
