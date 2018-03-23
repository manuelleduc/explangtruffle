package fr.mleduc.explangtruffle;

public class ELTUndefinedNameException extends ELTException {
    public static ELTUndefinedNameException undefinedFunction(String name) {
        return new ELTUndefinedNameException();
    }
}
