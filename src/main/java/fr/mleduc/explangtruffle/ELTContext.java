package fr.mleduc.explangtruffle;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.interop.TruffleObject;

import java.math.BigInteger;

public class ELTContext {
    private final ELTFunctionRegistry functionRegistry;

    public ELTContext(ELTFunctionRegistry functionRegistry) {
        this.functionRegistry = functionRegistry;
    }


    public ELTFunctionRegistry getFunctionRegistry() {
        return functionRegistry;
    }

    public static Object fromForeignValue(Object a) {
        if (a instanceof Long || a instanceof BigInteger || a instanceof String || a instanceof Boolean) {
            return a;
        } else if (a instanceof Character) {
            return String.valueOf(a);
        } else if (a instanceof Number) {
            return fromForeignNumber(a);
        } else if (a instanceof TruffleObject) {
            return a;
        } else if (a instanceof ELTContext) {
            return a;
        }
        CompilerDirectives.transferToInterpreter();
        throw new IllegalStateException(a + " is not a Truffle value");
    }

    @CompilerDirectives.TruffleBoundary
    private static long fromForeignNumber(Object a) {
        return ((Number) a).longValue();
    }
}
