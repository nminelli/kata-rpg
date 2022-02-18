import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testHealthStartsAt1000() {
        Person person = new Person();
        assertEquals(1000, person.getHealth(), 0);
    }

    @Test
    public void testLevelStartingAt1() {
        Person person = new Person();

        assertEquals(1, person.getLevel());
    }

    @Test
    public void testStartingItsAlive() {
        Person person = new Person();

        assertTrue(person.isAlive());
    }

    @Test
    public void testReceivedDamage() {
        Person person = new Person();
        double health = person.getHealth();
        person.receiveDamage(1);
        assertEquals(health - 1, person.getHealth(), -1);
    }

    @Test
    public void testHealthCantBeLesserThan0() {
        Person person = new Person();
        double health = person.getHealth();
        person.receiveDamage(health + 1);
        assertEquals(0, person.getHealth(), -1000);
    }

    @Test
    public void testReceiveDamageAnotherPerson() {
        Person henrique = new Person();
        Person pedro = new Person();

        double healthHenrique = henrique.getHealth();

        pedro.attack(henrique, 1);

        assertEquals(healthHenrique - 1, henrique.getHealth(), -1);
    }

    @Test
    public void testDamageKill() {
        Person henrique = new Person();
        Person pedro = new Person();

        pedro.attack(henrique, 1000);

        assertFalse(henrique.isAlive());
        assertEquals(0, henrique.getHealth(), -1000);
    }

    @Test
    public void testReceiveLife() {
        Person person = new Person();
        double health = person.getHealth();
        person.receiveDamage(1);
        person.receiveLife(1);

        assertEquals(health, person.getHealth(), 1);
    }

    @Test
    public void testDeadCantBeHealed() {
        Person person = new Person();
        person.setHealth(0);

        person.receiveLife(1);

        assertEquals(0, person.getHealth(), 0);
    }

    @Test
    public void testHealthCantBeHigherThan1000() {
        Person person = new Person();

        person.receiveLife(1);

        assertEquals(1000, person.getHealth(), 0);
    }

    @Test
    public void testPersonHealthCantBeHealedMoreThan1000() {
        Person person = new Person();

        person.receiveDamage(2);
        person.receiveLife(10);

        assertEquals(1000, person.getHealth(), 0);
    }
    @Test
    public void testDamageSamePerson() {
        Person nico = new Person();

        nico.attack(nico,43);

        assertEquals(1000, nico.getHealth(), 0);
    }

    @Test
    public void testHealSamePerson() {
        //nico se cura a si mismo
        Person nico = new Person();

        nico.setHealth(100);
        nico.heal(nico,43);

        assertEquals(143, nico.getHealth(), 0);

        //nico no puede curar a otros
        Person peter = new Person();
        peter.setHealth(100);
        nico.heal(peter,43);

        assertEquals(100, peter.getHealth(), 0);


    }

    @Test
    public void testDamageLowerLvl() {
        Person peter = new Person();
        peter.setLevel(6);
        Person nico = new Person();

        nico.attack(peter,50);
        assertEquals(975, peter.getHealth(), 0);
    }

    @Test
    public void testDamageUpperLvl() {
        Person peter = new Person();
        peter.setLevel(6);
        Person nico = new Person();

        peter.attack(nico,50);
        assertEquals(925, nico.getHealth(), 0);
    }

}
