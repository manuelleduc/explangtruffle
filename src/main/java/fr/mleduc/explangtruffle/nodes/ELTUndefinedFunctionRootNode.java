package fr.mleduc.explangtruffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import fr.mleduc.explangtruffle.ELTLanguage;
import fr.mleduc.explangtruffle.ELTUndefinedNameException;
import fr.mleduc.explangtruffle.nodes.ELTRootNode;

public class ELTUndefinedFunctionRootNode extends ELTRootNode {
    public ELTUndefinedFunctionRootNode(ELTLanguage language, String name) {
        super(language, null);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        throw ELTUndefinedNameException.undefinedFunction(getName());
    }
}
