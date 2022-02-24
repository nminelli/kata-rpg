import org.junit.Test;

import static org.junit.Assert.*;

public class MeleeTest {

    @Test
    public void testMaxRange() {
        Melee nico = new Melee();
        double maxRange = nico.getMaxRange();

        assertEquals(2, maxRange, 0);
    }
}
