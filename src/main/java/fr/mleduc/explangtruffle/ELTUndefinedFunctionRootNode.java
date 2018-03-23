package fr.mleduc.explangtruffle;

import com.oracle.truffle.api.frame.VirtualFrame;

public class ELTUndefinedFunctionRootNode extends ELTRootNode {
    public ELTUndefinedFunctionRootNode(ELTLanguage language, String name) {
        super(language, null);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        throw ELTUndefinedNameException.undefinedFunction(getName());
    }
}
