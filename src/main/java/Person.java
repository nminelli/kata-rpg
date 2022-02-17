public class Person {

    private int health;
    private int level;

    private static int DIF_LEVEL = 5;
    private static int DIV_DAMAGE = 2;


    Person() {
        this.health = 1000;
        this.level = 1;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    private void receiveDamage(int damage) {
        if (this.getHealth() < damage) {
            this.setHealth(0);
        } else {
            this.setHealth(this.getHealth() - damage);
        }
    }

    public void attack(Person defender, int damage) {

        if (defender == this) return;

        if (calculateDifLevel(defender) > DIF_LEVEL) {
            damage = damage / DIV_DAMAGE;
        } else if (calculateDifLevel(defender) <= DIF_LEVEL ) {
            damage = damage + (damage / DIV_DAMAGE);
        }

        defender.receiveDamage(damage);

    }

    public void receiveLife(int i) {
        if(this.isAlive()) {
            if ((this.getHealth() + i) >= 1000) {
                setHealth(1000);
            } else {
                setHealth(getHealth()+i);
            }
        }

    }

    public void heal(Person person, int i) {
        if (person == this){
            person.receiveLife(i);
        }
    }

    private int calculateDifLevel(Person target) {
        return this.getLevel() - target.getLevel();
    }
}
