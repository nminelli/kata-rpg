import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testHealthStartsAt1000() {
        Person person = new Person();

        assertEquals(1000, person.getHealth());
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
        int health = person.getHealth();
        person.receiveDamage(1);
        assertEquals(health - 1, person.getHealth());
    }

    @Test
    public void testHealthCantBeLesserThan0() {
        Person person = new Person();
        int health = person.getHealth();
        person.receiveDamage(health + 1);
        assertEquals(0, person.getHealth());
    }

    @Test
    public void testReceiveDamageAnotherPerson() {
        Person henrique = new Person();
        Person pedro = new Person();

        int healthHenrique = henrique.getHealth();

        pedro.attack(henrique, 1);

        assertEquals(healthHenrique - 1, henrique.getHealth());
    }

    @Test
    public void testDamageKill() {
        Person henrique = new Person();
        Person pedro = new Person();

        pedro.attack(henrique, 1000);

        assertFalse(henrique.isAlive());
        assertEquals(0, henrique.getHealth());
    }

    @Test
    public void testReceiveLife() {
        Person person = new Person();
        int health = person.getHealth();
        person.receiveDamage(1);
        person.heal(1);

        assertEquals(health, person.getHealth());
    }

    @Test
    public void testDeadCantBeHealed() {
        Person person = new Person();
        person.setHealth(0);

        person.heal(1);

        assertEquals(0, person.getHealth());
    }

    @Test
    public void testHealthCantBeHigherThan1000() {
        Person person = new Person();

        person.heal(1);

        assertEquals(1000, person.getHealth());
    }

    @Test
    public void testPersonHealthCantBeHealedMoreThan1000() {
        Person person = new Person();

        person.receiveDamage(2);
        person.heal(10);

        assertEquals(1000, person.getHealth());
    }

    /*@Test
    public void testHealthAnotherPerson() {
        Person peter = new Person();
        Person nico = new Person();

        nico.receiveDamage(43);

        peter.heal(nico, 43);

        assertEquals(1000, nico.getHealth());
    }*/

    @Test
    public void testAtackSomeoneFiveLevelsAbove() {
        Person characterAmateur = new Person();
        Person characterCrackAndProfeesional = new Person();

        characterCrackAndProfeesional.setLevel(6);

        characterAmateur.attack(characterCrackAndProfeesional, 50);

        assertEquals(975, characterCrackAndProfeesional.getHealth());
    }

    @Test
    public void testAtackSomeoneFiveLevelsBellow() {
        Person characterAmateur = new Person();
        Person characterCrackAndProfeesional = new Person();

        characterCrackAndProfeesional.setLevel(6);

        characterCrackAndProfeesional.attack(characterAmateur, 25);

        assertEquals(962, characterAmateur.getHealth());
    }

    @Test
    public void testCannotDealDamageToItself() {
        Person peter = new Person();
        int expectedHealth = peter.getHealth();

        peter.attack(peter, 50);

        assertEquals(expectedHealth, peter.getHealth());
    }
}
