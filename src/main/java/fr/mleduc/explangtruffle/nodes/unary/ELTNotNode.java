package fr.mleduc.explangtruffle.nodes.unary;

import com.oracle.truffle.api.dsl.Specialization;

public class ELTNotNode extends ELTUnaryNode {
    @Specialization
    protected boolean doBoolean(boolean value) {
        return !value;
    }
}
