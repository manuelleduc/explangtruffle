package fr.mleduc.explangtruffle.nodes.binary;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "*")
public abstract class ELTMultNode extends ELTBinaryNode {

    @Specialization
    protected int mult(int left, int right) {
        return left * right;
    }

    @Specialization
    protected float mult(float left, float right) {
        return left * right;
    }

    
}
