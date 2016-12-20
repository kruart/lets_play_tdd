package ua.kruart.tdd.finances.util;

/**
 * Created by Arthur on 20.12.2016.
 */
public class UnreachableCodeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnreachableCodeException() {
        super("Unreachable code was executed");
    }
}
