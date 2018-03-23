package fr.mleduc.explangtruffle.nodes.binary;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "/")
public abstract class ELTDivNode extends ELTBinaryNode {

    @Specialization
    protected int div(int left, int right) {
        return left / right;
    }

    @Specialization
    protected float div(float left, float right) {
        return left / right;
    }

   
}
