package fr.mleduc.explangtruffle.nodes.nodes.nodes;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "+")
@NodeChildren({@NodeChild("leftChild"), @NodeChild("rightChild")})
public abstract class ELTAddNode extends ELTExpressionNode {

    @Specialization
    protected long add(long left, long right) {
        return left + right;
    }
}
