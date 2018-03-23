package fr.mleduc.explangtruffle;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.Node;

public abstract class ELTDispatchNode extends Node {
    public abstract Object executeDispatch(Object function, Object[] arguments);

    public static final int INLINE_CACHE_SIZE = 2;


    @Specialization(limit = "INLINE_CACHE_SIZE", //
            guards = "function.getCallTarget() == cachedTarget", //
            assumptions = "callTargetStable")
    @SuppressWarnings("unused")
    protected static Object doDirect(ELTFunction function, Object[] arguments,
                                     @Cached("function.getCallTargetStable()") Assumption callTargetStable,
                                     @Cached("function.getCallTarget()") RootCallTarget cachedTarget,
                                     @Cached("create(cachedTarget)") DirectCallNode callNode) {

        /* Inline cache hit, we are safe to execute the cached call target. */
        return callNode.call(arguments);
    }
}
