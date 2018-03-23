package fr.mleduc.explangtruffle;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;

import java.util.HashMap;
import java.util.Map;

public class ELTFunctionRegistry {

    private final Map<String, ELTFunction> functions = new HashMap<>();

    private final ELTLanguage language;

    public ELTFunctionRegistry(ELTLanguage language) {
        this.language = language;
    }

    public ELTFunction lookup(String name, boolean createIfNotPresent) {
        ELTFunction result = functions.get(name);
        if (result == null && createIfNotPresent) {
            result = new ELTFunction(language, name);
            functions.put(name, result);
        }
        return result;
    }

    public ELTFunction register(String name, ELTRootNode rootNode) {
        ELTFunction function = lookup(name, true);
        RootCallTarget callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        function.setCallTarget(callTarget);
        return function;
    }
}
