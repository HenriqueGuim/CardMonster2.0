package academy.mindswap.SuperNatural.Monsters;

import academy.mindswap.Random;

public class Vampire extends Monsters{

    public Vampire() {
        super(20);
    }

    private void bite() {
        if(Random.getRandomNumber(1,10)<3){
            System.out.println("The vampire has bitten the opponent");
            if(getlife()+getDamage()> 100) {
                increaseLife((getlife()+getDamage())-100);
                return;
            }
            increaseLife(getDamage());
        }
    }

    @Override
    public int attack() {
        bite();
        return super.attack();
    }
}
