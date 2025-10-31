package lecture.test;

import lecture.livecoding.Rectangle;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    @BeforeAll
    public static void runBeforeAll() {
        // TODO Don't rely on these messages being read :)
        // This is run before any of the defined test methods
        System.out.println("Rectangles here we go!");
    }


    @AfterAll
    public static void runAfterAll() {
        // TODO Don't rely on these messages being read :)
        // This is run after all of the defined test methods
        System.out.println("Done");
    }

    @BeforeEach
    public void beforeEachTestMethod() {
        System.out.println("before each test");
    }

    @AfterEach
    public void afterEachTestMethod() {
        System.out.println("after each test");
    }

    @Test
    public void testRectangle() {
        Rectangle r1 = new Rectangle(1000, "R1", 3, 2);
        assertEquals(1000, r1.getId());
        assertEquals("R1", r1.getName());
        assertEquals(6, r1.getArea());
    }

    @Test
    public void testRectangleArea() {
        Rectangle r2 = new Rectangle(1000, "R1", 1, 1);
        assertEquals(1, r2.getArea());
        Rectangle r3 = new Rectangle(1000, "R1", 10, 1);
        assertEquals(9, r3.getArea());
    }


}
