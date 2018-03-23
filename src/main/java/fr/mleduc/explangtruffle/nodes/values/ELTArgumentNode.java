package fr.mleduc.explangtruffle.nodes.values;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.profiles.BranchProfile;
import fr.mleduc.explangtruffle.ELTExpressionNode;

public class ELTArgumentNode extends ELTExpressionNode {

    private final int index;

    private final BranchProfile outOfBoundsTaken = BranchProfile.create();

    public ELTArgumentNode(int index) {
        this.index = index;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        Object[] args = frame.getArguments();
        if (index < args.length) {
            return args[index];
        } else {
            /* In the interpreter, record profiling information that the branch was used. */
            outOfBoundsTaken.enter();
            /* Use the default null value. */
            return null;
        }
    }
}
