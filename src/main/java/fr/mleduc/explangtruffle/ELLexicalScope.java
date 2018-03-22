package fr.mleduc.explangtruffle;

import com.oracle.truffle.api.frame.FrameSlot;

import java.util.Map;

public class ELLexicalScope {
    public final Map<String, FrameSlot> locals;

    public ELLexicalScope(Map<String, FrameSlot> locals) {
        this.locals = locals;
    }
}
