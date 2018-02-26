package lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleArrayListTest {
    private SimpleArrayList<Integer> array;
    private Random random;
    private Integer checkItem;

    @BeforeEach
    void beforeEach() {
        array = new SimpleArrayList<>();
        random = new Random();
        for (int i = 0; i < 10; i++) {
            if (i == 1) {
                checkItem = random.nextInt(100);
                array.add(checkItem);
            } else {
                array.add(random.nextInt(100));
            }
        }
    }

    @Test
    void testSize() {
        assertEquals(10, array.size());
    }

    @Test
    void testIsNotEmpty() {
        assertFalse(array.isEmpty());
    }

    @Test
    void testIsEmpty() {
        SimpleArrayList<Integer> newArray = new SimpleArrayList<>();
        assertTrue(newArray.isEmpty());
    }

    @Test
    void testGet() {
        assertEquals(checkItem, array.get(1));
    }

    @Test
    void testSet() {
        int testValue = random.nextInt(100);
        array.set(1, testValue);

        assertEquals(Integer.valueOf(testValue), array.get(1));
    }

    @Test
    void testAdd() {
        array.add(150);

        assertEquals(Integer.valueOf(150), array.get(10));
    }

    @Test
    void testRemove() {
        Integer testItem = array.get(5);
        array.remove(5);

        assertEquals(9, array.size());
        assertNotEquals(testItem, array.get(5));
    }

    @Test
    void testClear() {
        array.clear();

        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
    }
}
