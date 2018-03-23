package fr.mleduc.explangtruffle.nodes.unary;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(description = "unary operation")
@NodeChild("child")
public abstract class ELTUnaryNode {
}
