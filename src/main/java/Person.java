public class Person {

    private double health;
    private int level;

    Person() {
        this.health = 1000;
        this.level = 1;
    }

    public void setHealth(double health) {
        this.health = health;
    }
    public void setLevel(int lvl) {
        this.level = lvl;
    }

    public double getHealth() {
        return this.health;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    public void receiveDamage(double damage) {
        if (this.getHealth() < damage) {
            this.setHealth(0);
        } else {
            this.setHealth(this.getHealth() - damage);
        }
    }

    public void attack(Person victim, double damage) {
        if (!this.equals(victim)) {
            int lvlVictim = victim.getLevel();
            int lvlAttacker = this.getLevel();
            int diffLvl = lvlVictim - lvlAttacker;
            double damageModifier = 1;
            if (diffLvl >= 5) {
                damageModifier *= 0.5;
            } else if (diffLvl <= -5) {
                damageModifier *= 1.5;
            }

            victim.receiveDamage(damage * damageModifier);
        }
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
        if (this.equals(person)) {
            person.receiveLife(i);
        }
    }
}
