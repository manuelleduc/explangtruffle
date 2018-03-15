package fr.mleduc.explangtruffle.nodes.nodes.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;

@NodeInfo(language = "ELT", description = "Root node")
public class ELTRootNode extends RootNode {

    @Child
    private ELTExpressionNode child;

    public ELTRootNode(TruffleLanguage<?> language, ELTExpressionNode child) {
        super(language);
        this.child = child;
    }

    protected ELTRootNode(TruffleLanguage<?> language, FrameDescriptor frameDescriptor, ELTExpressionNode child) {
        super(language, frameDescriptor);
        this.child = child;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        Object res = child.executeGeneric(frame);
        System.out.println(res);
        return res;
    }
}
