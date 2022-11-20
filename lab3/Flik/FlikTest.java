import org.junit.Test;
import static org.junit.Assert.*;
public class FlikTest {
    @Test
    public void testIsSameNumber() {
        boolean actual = Flik.isSameNumber(128, 128);
        boolean expected = true;
        assertEquals(expected, actual);
    }

}
