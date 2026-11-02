package lecture.livecoding.test;

import lecture.livecoding.domain.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    @Test
    public void rectangleFirstTest() {
        Rectangle r1 = new Rectangle(1000, "One", 4, 3);
        Assertions.assertEquals(12, r1.getArea());
        Assertions.assertEquals(1000, r1.getId());
    }

    @Test
    public void rectangleSecondTest() {
        Rectangle r1 = new Rectangle(1001, "One", 4, 3);
        Assertions.assertEquals(1001, r1.getId());
        Assertions.assertEquals("One", r1.getName());
    }

}
