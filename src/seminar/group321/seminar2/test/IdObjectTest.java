package seminar.group321.seminar2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import seminar.group321.seminar2.IdObject;

public class IdObjectTest {

    @Test
    public void testIdObject() {
        IdObject obj = new IdObject(1001);
        assertEquals(1001, obj.getId());
    }

}
