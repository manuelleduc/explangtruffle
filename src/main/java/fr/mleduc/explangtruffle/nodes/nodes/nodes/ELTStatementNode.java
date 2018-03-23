package fr.mleduc.explangtruffle.nodes.nodes.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;


@NodeInfo(language = "ELT", description = "The abstract base node of all ELT statements")
public abstract class ELTStatementNode extends Node {
    public abstract void executeVoid(VirtualFrame frame);
}
