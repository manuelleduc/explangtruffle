package fr.mleduc.explangtruffle.nodes.nodes.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.profiles.ConditionProfile;

public class ELTIfNode extends ELTExpressionNode {

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
    public Object executeGeneric(VirtualFrame frame) {
        try {
            if (this.conditionProfile.profile(this.testResult(frame))) {
                return this.thenNode.executeGeneric(frame);
            } else {
                return this.elseNode.executeGeneric(frame);
            }
        } catch (UnexpectedResultException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean testResult(VirtualFrame frame) throws UnexpectedResultException {

        return this.testNode.executeBool(frame);

    }

}
