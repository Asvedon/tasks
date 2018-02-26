import lib.SimpleStringSercher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    void testContainString() {
        SimpleStringSercher sercher = new SimpleStringSercher("строка для поиска чтобы найти в ней подстроки");

        assertTrue(sercher.contain("поиск"));
    }

    @Test
    void testNotContainString() {
        SimpleStringSercher sercher = new SimpleStringSercher("not contain string");

        assertFalse(sercher.contain("zinger"));
    }
}
