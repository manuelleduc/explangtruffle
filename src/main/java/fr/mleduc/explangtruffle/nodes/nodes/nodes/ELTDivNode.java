package fr.mleduc.explangtruffle.nodes.nodes.nodes;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "/")
public abstract class ELTDivNode extends ELTBinaryNode {

    @Specialization
    protected long add(long left, long right) {
        return left / right;
    }
}
