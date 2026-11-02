package lecture.livecoding.test;

import lecture.livecoding.domain.Square;
import lecture.livecoding.domain.UnitSquare;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTest {

    @Test
    public void squareOneTest() {
        Square one = UnitSquare.getInstance();

        Assertions.assertEquals(1, one.getArea());
    }

}
