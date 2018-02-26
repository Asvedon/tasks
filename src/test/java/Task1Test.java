import lib.SimpleArrayList;
import lib.SimpleSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    private SimpleArrayList<Integer> array;
    private Random random;
    private SimpleSort sorter;

    @BeforeEach
    void beforeEach() {
        array = new SimpleArrayList<>();
        random = new Random();
        for (int i = 0; i < 10; i++) {
            array.add(random.nextInt(100));
        }
    }

    @Test
    void testSecondMaximum() {
        array.add(110);
        array.remove(3);
        array.add(75);
        array.remove(5);
        array.add(113);

        sorter = new SimpleSort(array);

        assertEquals(110, sorter.getMaxByIndex(2));
    }

    @Test
    void testSecondMinimum() {
        array.add(0);
        array.remove(3);
        array.add(4);
        array.remove(5);
        array.add(1);

        sorter = new SimpleSort(array);

        assertEquals(1, sorter.getMinByIndex(2));
    }
}
