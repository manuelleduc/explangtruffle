package fr.mleduc.explangtruffle.nodes.nodes.nodes.binary;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class ELTModuloNode extends ELTBinaryNode {

    @Specialization
    protected int modulo(int a, int b) {
        return a % b;
    }

    @Specialization
    protected float modulo(float a, float b) {
        return a % b;
    }

    @Specialization
    protected float modulo(float a, int b) {
        return a % b;
    }

    @Specialization
    protected float modulo(int a, float b) {
        return a % b;
    }
}
