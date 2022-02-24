import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

     @Test
     public void testHealthStartsAt1000() {
         Person person = new Melee();

         assertEquals(1000, person.getHealth());
     }

     @Test
     public void testLevelStartingAt1() {
         Person person = new Melee();

         assertEquals(1, person.getLevel());
     }

     @Test
     public void testStartingItsAlive() {
         Person person = new Melee();

         assertTrue(person.isAlive());
     }

     @Test
     public void testReceivedDamage() {
         Person person = new Melee();
         int health = person.getHealth();
         Person peter = new Melee();

         peter.attack(person,1);

         assertEquals(health - 1, person.getHealth());
    }

    @Test
    public void testHealthCantBeLesserThan0() {
        Person person = new Melee();
        int health = person.getHealth();
        Person peter = new Melee();

        peter.attack(person,health + 1);
        assertEquals(0, person.getHealth());
    }

    @Test
    public void testReceiveDamageAnotherMelee() {
        Person henrique = new Melee();
        Person pedro = new Melee();

        int healthHenrique = henrique.getHealth();

        pedro.attack(henrique, 1);

        assertEquals(healthHenrique - 1, henrique.getHealth());
    }

    @Test
    public void testDamageKill() {
        Person henrique = new Melee();
        Person pedro = new Melee();

        pedro.attack(henrique, 1000);

        assertFalse(henrique.isAlive());
        assertEquals(0, henrique.getHealth());
    }

    @Test
    public void testReceiveLife() {
        Person person = new Melee();
        int health = person.getHealth();
        Person peter = new Melee();

        peter.attack(person,1);
        person.receiveLife(1);

        assertEquals(health, person.getHealth());
    }

    @Test
    public void testDeadCantBeHealed() {
        Person person = new Melee();
        person.setHealth(0);

        person.receiveLife(1);

        assertEquals(0, person.getHealth());
    }

    @Test
    public void testHealthCantBeHigherThan1000() {
        Person person = new Melee();

        person.receiveLife(1);

        assertEquals(1000, person.getHealth());
    }

    @Test
    public void testPersonHealthCantBeHealedMoreThan1000() {
        Person person = new Melee();
        Person peter = new Melee();

        peter.attack(person,2);
        person.receiveLife(10);

        assertEquals(1000, person.getHealth());
    }

    @Test
    public void testShouldNotHealthAnotherMelee() {
        Person peter = new Melee();
        Person nico = new Melee();

        peter.attack(nico,43);

        peter.heal(nico, 43);

        assertFalse(1000 == nico.getHealth());
    }

    @Test
    public void testCharacterCantDamageHimSelf(){
        Person pedro = new Melee();
        int health = pedro.getHealth();

        pedro.attack(pedro,15);

        assertEquals(pedro.getHealth(),health);
    }

    @Test
    public void testCanOnlyHealItself(){
        Person person = new Melee();
        Person jhony = new Melee();

        jhony.attack(person,500);

        int health = person.getHealth();

        person.heal(person,500);

        assertEquals(person.getHealth(), health+500);
    }

    @Test
    public void testAttackerLevel5OrMoreTarget(){
         Person attacker = new Melee();
         Person target = new Melee();
         int damage = 500;
         attacker.setLevel(7);

         int healthTarget = target.getHealth();
         attacker.attack(target, damage);

         if (healthTarget - (damage + (damage / 2)) < 0) {
             assertEquals(0, target.getHealth());
         } else {
             assertEquals(healthTarget - (damage + (damage / 2)), target.getHealth());
         }
    }

    @Test
    public void testAttackerLevel5OrLessTarget(){
        Person attacker = new Melee();
        Person target = new Melee();
        int damage = 30;
        target.setLevel(7);

        int healthTarget = target.getHealth();
        attacker.attack(target, damage);

        if (healthTarget - (damage / 2) < 0) {
            assertEquals(healthTarget - (damage / 2), 0);
        } else {
            assertEquals(healthTarget - (damage / 2), target.getHealth());
        }

    }

    @Test
    public void testAttackRange(){
         Person attacker = new Melee();
         Person target = new Melee();
         int damage = 30;
         target.setLevel(7);
         target.setPosition(40);
         attacker.setLevel(7);

         int healthTarget = target.getHealth();
        attacker.attack(target, damage);

        assertEquals(healthTarget, target.getHealth());


    }

}