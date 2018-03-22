package fr.mleduc.explangtruffle.nodes.nodes.nodes.binary;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

import java.util.Objects;

@NodeInfo(shortName = ">")
public abstract class ELTEqualNode extends ELTBinaryNode {



    @Specialization
    protected boolean eq(int a, int b) {
        return a == b;
    }

    @Specialization
    protected boolean eq(int a, float b) {
        return a == b;
    }


    @Specialization
    protected boolean eq(float a, int b) {
        return a == b;
    }

    @Specialization
    protected boolean eq(float a, float b) {
        return a == b;
    }


    @Specialization
    protected boolean eq(boolean a, boolean b) {
        return a == b;
    }


    @Specialization
    protected boolean eq(Object a, Object b) {
        return Objects.equals(a, b);
    }
}
