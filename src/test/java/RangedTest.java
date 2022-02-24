import org.junit.Test;

import static org.junit.Assert.*;

public class RangedTest {

    @Test
    public void testRangeMustBe20() {
        Ranged ranged = new Ranged();
        double range = ranged.getMaxRange();

        assertEquals(20, range, 0);
    }

}
