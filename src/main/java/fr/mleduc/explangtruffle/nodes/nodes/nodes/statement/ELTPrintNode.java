package fr.mleduc.explangtruffle.nodes.nodes.nodes.statement;


import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.ELTExpressionNode;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.ELTStatementNode;


@NodeInfo(description = "Print a expression value")
public class ELTPrintNode extends ELTStatementNode {

    @Child
    private ELTExpressionNode value;

    public ELTPrintNode(ELTExpressionNode value) {
        this.value = value;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        Object res = this.value.executeGeneric(frame);
        System.out.println(res);
    }
}
