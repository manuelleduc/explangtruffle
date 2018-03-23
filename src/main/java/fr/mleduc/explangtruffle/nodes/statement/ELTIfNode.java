package fr.mleduc.explangtruffle.nodes.statement;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.profiles.ConditionProfile;
import fr.mleduc.explangtruffle.nodes.ELTStatementNode;
import fr.mleduc.explangtruffle.nodes.ELTExpressionNode;

@NodeInfo(shortName = "if", description = "Conditional statement")
public final class ELTIfNode extends ELTStatementNode {

    @Child
    private ELTExpressionNode testNode;
    @Child
    private ELTExpressionNode thenNode;
    @Child
    private ELTExpressionNode elseNode;


    /*
    Speculative inference of which branch will be used.
     */
    private final ConditionProfile conditionProfile = ConditionProfile.createBinaryProfile();


    public ELTIfNode(ELTExpressionNode testNode, ELTExpressionNode thenNode, ELTExpressionNode elseNode) {
        this.testNode = testNode;
        this.thenNode = thenNode;
        this.elseNode = elseNode;
    }


    @Override
    public void executeVoid(VirtualFrame frame) {
        try {
            if (this.conditionProfile.profile(this.testResult(frame))) {
                this.thenNode.executeGeneric(frame);
            } else {
                this.elseNode.executeGeneric(frame);
            }
        } catch (UnexpectedResultException e) {
            e.printStackTrace();
        }
    }

    private boolean testResult(VirtualFrame frame) throws UnexpectedResultException {
        return this.testNode.executeBool(frame);
    }

}
