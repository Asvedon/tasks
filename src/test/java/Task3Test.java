import lib.Polyndrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    void testIsPolyndrome1() {
        Polyndrome polyndrome = new Polyndrome("ababaababa");

        assertTrue(polyndrome.isPolyndrome());
    }

    @Test
    void testIsPolyndrome2() {
        Polyndrome polyndrome = new Polyndrome("abababababa");

        assertTrue(polyndrome.isPolyndrome());
    }

    @Test
    void testIsNotPolyndrome() {
        Polyndrome polyndrome = new Polyndrome("abababbba");

        assertFalse(polyndrome.isPolyndrome());
    }
}
