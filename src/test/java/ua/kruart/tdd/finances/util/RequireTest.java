package ua.kruart.tdd.finances.util;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Arthur on 19.12.2016.
 */
public class RequireTest {

    @Ignore
    @Test
    public void that() {
        try{
            Require.that(false, "some message");
            fail("expected exception");
        } catch (RequireException e) {
            assertEquals("some message", e.getMessage());
        }
    }
}

class RequireException extends RuntimeException {
    private static final long serialVersionUID = 1L;


}