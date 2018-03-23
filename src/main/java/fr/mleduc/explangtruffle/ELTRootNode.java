package fr.mleduc.explangtruffle;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;

@NodeInfo(language = "ELT", description = "Root node")
public class ELTRootNode extends RootNode {

    @Child
    private ELTStatementNode child;

    public ELTRootNode(TruffleLanguage<?> language, ELTStatementNode child) {
        super(language);
        this.child = child;
    }

    public ELTRootNode(TruffleLanguage<?> language, FrameDescriptor frameDescriptor, ELTStatementNode child) {
        super(language, frameDescriptor);
        this.child = child;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        child.executeVoid(frame);
        return null;
    }
}
