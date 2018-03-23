package fr.mleduc.explangtruffle;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.nodes.Node;


// @TypeSystem({int.class, float.class, boolean.class, String.class})
@TypeSystemReference(ELTTypes.class)
public abstract class ELTTypeToForeignNode extends Node {


    public abstract Object executeConvert(Object value);

    @Specialization
    static int fromInt(int value) {
        return value;
    }

    @Specialization
    static float fromFloat(float value) {
        return value;
    }

    @Fallback
    static Object identity(Object value) {
        return value;
    }
}
