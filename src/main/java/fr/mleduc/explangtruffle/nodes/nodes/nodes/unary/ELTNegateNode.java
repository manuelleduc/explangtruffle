package fr.mleduc.explangtruffle.nodes.nodes.nodes.unary;

import com.oracle.truffle.api.dsl.Specialization;

public class ELTNegateNode extends ELTUnaryNode {


    @Specialization
    protected int negate(int n) {
        return -n;
    }

    @Specialization
    protected float negate(float n) {
        return -n;
    }

}
