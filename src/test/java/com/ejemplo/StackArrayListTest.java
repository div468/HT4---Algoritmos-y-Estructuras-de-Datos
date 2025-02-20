package test.java.com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ejemplo.StackArrayList;

class StackArrayListTest {

    @Test
    void testPush() {
        StackArrayList<Integer> stack = new StackArrayList<>();
        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
    }

    @Test
    void testPop() {
        StackArrayList<Integer> stack = new StackArrayList<>();
        stack.push(1);
        int value = stack.pop();
        assertEquals(1, value);
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPeek() {
        StackArrayList<Integer> stack = new StackArrayList<>();
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    @Test
    void testSize() {
        StackArrayList<Integer> stack = new StackArrayList<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    void testIsEmpty() {
        StackArrayList<Integer> stack = new StackArrayList<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}
