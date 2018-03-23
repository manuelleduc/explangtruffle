package fr.mleduc.explangtruffle.nodes.statement;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;
import fr.mleduc.explangtruffle.ELTStatementNode;

@NodeInfo(shortName = "block", description = "The node implementing a source code block")
public final class ELTBlockNode extends ELTStatementNode {

    @Children
    private final ELTStatementNode[] bodyNodes;

    public ELTBlockNode(ELTStatementNode[] bodyNodes) {
        this.bodyNodes = bodyNodes;
    }


    @Override
    @ExplodeLoop
    public void executeVoid(VirtualFrame frame) {
        CompilerAsserts.compilationConstant(bodyNodes.length);

        for (ELTStatementNode stmt : bodyNodes) {
            stmt.executeVoid(frame);
        }
    }
}
