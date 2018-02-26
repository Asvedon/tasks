import lib.Encoder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    void testEncode() {
        Encoder encoder = new Encoder();

        assertEquals("aaabbcddd", encoder.decode("3a2b1c3d"));
    }
}
