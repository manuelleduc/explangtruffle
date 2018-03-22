package fr.mleduc.explangtruffle.nodes.nodes.nodes;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "+")
public abstract class ELTAddNode extends ELTBinaryNode {

    @Specialization
    protected int add(int left, int right) {
        return left + right;
    }

    @Specialization
    protected float add(float left, float right) {
        return left + right;
    }

    @Specialization
    protected String add(String left, String right) {
        return left + right;
    }


}
