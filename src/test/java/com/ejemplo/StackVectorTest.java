package test.java.com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackVectorTest {

    @Test
    void testPush() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
    }

    @Test
    void testPop() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(1);
        int value = stack.pop();
        assertEquals(1, value);
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPeek() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    @Test
    void testSize() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    void testIsEmpty() {
        StackVector<Integer> stack = new StackVector<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}
