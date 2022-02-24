public class Melee extends Person{

    private final int range;

    Melee(){
        this.range = 2;
    }

    @Override
    public int getRange() {
        return this.range;
    }
}
