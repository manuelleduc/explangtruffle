package fr.mleduc.explangtruffle.nodes.binary;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = ">")
public abstract class ELTSmallerEqualNode extends ELTBinaryNode {

    @Specialization
    protected boolean compare(int a, int b) {
        return a <= b;
    }

    @Specialization
    protected boolean compare(int a, float b) {
        return a <= b;
    }

    @Specialization
    protected boolean compare(float a, int b) {
        return a <= b;
    }

    @Specialization
    protected boolean compare(float a, float b) {
        return a <= b;
    }

}
