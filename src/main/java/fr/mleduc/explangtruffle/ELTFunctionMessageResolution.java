package fr.mleduc.explangtruffle;

import com.oracle.truffle.api.interop.CanResolve;
import com.oracle.truffle.api.interop.MessageResolution;
import com.oracle.truffle.api.interop.Resolve;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.nodes.Node;

import static fr.mleduc.explangtruffle.ELTContext.fromForeignValue;


@MessageResolution(receiverType = ELTFunction.class)
public class ELTFunctionMessageResolution {
    @Resolve(message = "EXECUTE")
    public abstract static class SLForeignFunctionExecuteNode extends Node {

        @Child private ELTDispatchNode dispatch = ELTDispatchNodeGen.create();
        @Child private ELTTypeToForeignNode toForeign = ELTTypeToForeignNodeGen.create();

        public Object access(ELTFunction receiver, Object[] arguments) {
            Object[] arr = new Object[arguments.length];
            // Before the arguments can be used by the SLFunction, they need to be converted to SL
            // values.
            for (int i = 0; i < arr.length; i++) {
                arr[i] = fromForeignValue(arguments[i]);
            }
            Object result = dispatch.executeDispatch(receiver, arr);
            return toForeign.executeConvert(result);
        }
    }

    /*
     * An SL function should respond to an IS_EXECUTABLE message with true.
     */
    @Resolve(message = "IS_EXECUTABLE")
    public abstract static class SLForeignIsExecutableNode extends Node {
        public Object access(Object receiver) {
            return receiver instanceof ELTFunction;
        }
    }

    @CanResolve
    public abstract static class CheckFunction extends Node {

        protected static boolean test(TruffleObject receiver) {
            return receiver instanceof ELTFunction;
        }
    }
}
