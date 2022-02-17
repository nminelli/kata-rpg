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
         Person peter = new Person();

         peter.attack(person,1);

         assertEquals(health - 1, person.getHealth());
    }

    @Test
    public void testHealthCantBeLesserThan0() {
        Person person = new Person();
        int health = person.getHealth();
        Person peter = new Person();

        peter.attack(person,health + 1);
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
        Person peter = new Person();

        peter.attack(person,1);
        person.receiveLife(1);

        assertEquals(health, person.getHealth());
    }

    @Test
    public void testDeadCantBeHealed() {
        Person person = new Person();
        person.setHealth(0);

        person.receiveLife(1);

        assertEquals(0, person.getHealth());
    }

    @Test
    public void testHealthCantBeHigherThan1000() {
        Person person = new Person();

        person.receiveLife(1);

        assertEquals(1000, person.getHealth());
    }

    @Test
    public void testPersonHealthCantBeHealedMoreThan1000() {
        Person person = new Person();
        Person peter = new Person();

        peter.attack(person,2);
        person.receiveLife(10);

        assertEquals(1000, person.getHealth());
    }

    @Test
    public void testShouldNotHealthAnotherPerson() {
        Person peter = new Person();
        Person nico = new Person();

        peter.attack(nico,43);

        peter.heal(nico, 43);

        assertFalse(1000 == nico.getHealth());
    }

    @Test
    public void testCharacterCantDamageHimSelf(){
        Person pedro = new Person();
        int health = pedro.getHealth();

        pedro.attack(pedro,15);

        assertEquals(pedro.getHealth(),health);
    }

    @Test
    public void testCanOnlyHealItself(){
        Person person = new Person();
        Person jhony = new Person();

        jhony.attack(person,500);

        int health = person.getHealth();

        person.heal(person,500);

        assertEquals(person.getHealth(), health+500);
    }

    @Test
    public void testAttackerLevel5OrMoreTarget(){
         Person attacker = new Person();
         Person target = new Person();
         target.setLevel(7);

         int healthTarget = target.getHealth();
         attacker.attack(target, 10);

         assertEquals(target.getHealth(), healthTarget - 5);
    }

    @Test
    public void testAttackerLevel5OrLessTarget(){
        Person attacker = new Person();
        Person target = new Person();
        target.setLevel(7);

        int healthTarget = target.getHealth();
        attacker.attack(target, 10);

        assertEquals(target.getHealth(), healthTarget - 5);
    }

}