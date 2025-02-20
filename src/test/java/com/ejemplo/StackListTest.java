package test.java.com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ejemplo.StackList;

class StackListTest {

    @Test
    void testPush() {
        StackList<Integer> stack = new StackList<>("Simple");
        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
    }

    @Test
    void testPop() {
        StackList<Integer> stack = new StackList<>("Simple");
        stack.push(1);
        int value = stack.pop();
        assertEquals(1, value);
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPeek() {
        StackList<Integer> stack = new StackList<>("Simple");
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    @Test
    void testSize() {
        StackList<Integer> stack = new StackList<>("Simple");
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    void testIsEmpty() {
        StackList<Integer> stack = new StackList<>("Simple");
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}
