import lib.NumberMultipliers;
import lib.SimpleArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    private SimpleArrayList<Integer> array;
    private Random random;

    @BeforeEach
    void beforeEach() {
        array = new SimpleArrayList<>();
        random = new Random();
        for (int i = 0; i < 10; i++) {
            array.add(random.nextInt(100));
        }
    }

    @Test
    void testMultipliers1() {
        int testNumber = 10;
        NumberMultipliers numberMultipliers = new NumberMultipliers(testNumber);

        int[] multipliers = numberMultipliers.getMultipliers();

        assertEquals(2, multipliers.length);
        assertEquals(2, multipliers[0]);
        assertEquals(5, multipliers[1]);
    }

    @Test
    void testMultipliers2() {
        int testNumber = 16;
        NumberMultipliers numberMultipliers = new NumberMultipliers(testNumber);

        int[] multipliers = numberMultipliers.getMultipliers();

        assertEquals(3, multipliers.length);
        assertEquals(2, multipliers[0]);
        assertEquals(8, multipliers[1]);
        assertEquals(4, multipliers[2]);
    }
}
