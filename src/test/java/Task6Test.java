import lib.Encoder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    void testEncode() {
        Encoder encoder = new Encoder();

        assertEquals("3a2b1c3d", encoder.encode("aaabbcddd"));
    }
}
