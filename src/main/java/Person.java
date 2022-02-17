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

    public void setLevel(int level) { this.level = level; }

    public int getLevel() { return this.level; }

    public void increasseLevel() {this.level++;}

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
        if (person != this) {
            damage = calculateDamage(person.getLevel(), damage);
            person.receiveDamage(damage);
        }
    }

    public int calculateDamage(int anotherCharacterlevel, int damage){
        int dif = anotherCharacterlevel - this.level;

        if (dif >= 5){
            return (int) Math.round(damage * 0.5);
        }

        if (dif <= -5) {
            return (int) Math.round(damage * 1.5);
        }

        return damage;
    }

    public void heal(int i) {
        if(this.isAlive()) {
            if ((this.getHealth() + i) >= 1000) {
                setHealth(1000);
            } else {
                setHealth(getHealth()+i);
            }
        }

    }
}
