package ua.kruart.tdd.finances.util;

/**
 * Created by Arthur on 19.12.2016.
 */
public class Require {


    public static void that(boolean expression, String message) {
        if(!expression) throw new RequireException(message);
    }
}

class RequireException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RequireException(String message) {
        super(message);
    }
}