package fr.mleduc.explangtruffle.nodes.nodes.nodes.binary;


import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.nodes.NodeInfo;
import fr.mleduc.explangtruffle.nodes.nodes.nodes.ELTExpressionNode;

@NodeInfo(description = "binary operation")
@NodeChildren({@NodeChild("leftChild"), @NodeChild("rightChild")})
public abstract class ELTBinaryNode extends ELTExpressionNode {
}
