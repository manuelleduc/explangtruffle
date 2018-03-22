package fr.mleduc.explangtruffle.nodes.nodes.nodes;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "-")
public abstract class ELTSubNode extends ELTBinaryNode {

    @Specialization
    protected int sub(int left, int right) {
        return left - right;
    }

    @Specialization
    protected float sub(float left, float right) {
        return left - right;
    }


}
