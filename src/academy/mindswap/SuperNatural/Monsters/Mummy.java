package academy.mindswap.SuperNatural.Monsters;

public class Mummy extends Monsters{
    private int attackCounter = 0;


    public Mummy() {
        super(25);
    }

    @Override
    public int attack() {
        attackCounter++;
        if(attackCounter == 3){
            reduceLife(10);
            return 0;
        }
        return super.attack();
    }
}
