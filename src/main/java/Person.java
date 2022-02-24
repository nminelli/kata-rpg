public abstract class Person {

    private double health;
    private int level;
    private Position position;
    protected double maxRange;

    Person() {
        this.health = 1000;
        this.level = 1;
        this.position = new Position(0, 0);
        this.maxRange = 1;
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
        Double distance = Position.calculateDistance(this.getPosition(), victim.getPosition());

        if (!this.equals(victim) && distance <= this.getMaxRange()) {
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
        if (this.isAlive()) {
            if ((this.getHealth() + i) >= 1000) {
                setHealth(1000);
            } else {
                setHealth(getHealth() + i);
            }
        }

    }

    public void heal(Person person, int i) {
        if (this.equals(person)) {
            person.receiveLife(i);
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public double getMaxRange() {
        return this.maxRange;
    }

    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }


}
