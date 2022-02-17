public class Person {

    private int health;
    private int level;

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

    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    public void receiveDamage(int damage) {
        if (this.getHealth() < damage) {
            this.setHealth(0);
        } else {
            this.setHealth(this.getHealth() - damage);
        }
    }

    public void attack(Person person, int damage) {
        person.receiveDamage(damage);
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
        person.receiveLife(i);
    }
}
