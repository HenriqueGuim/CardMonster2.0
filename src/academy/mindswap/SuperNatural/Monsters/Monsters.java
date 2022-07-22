package academy.mindswap.SuperNatural.Monsters;


import academy.mindswap.SuperNatural.Attackable;
import academy.mindswap.SuperNatural.Defendeable;
import academy.mindswap.SuperNatural.SuperNatural;

public abstract class Monsters extends SuperNatural implements Defendeable, Attackable {
    private int life = 100;

    public Monsters(int damage){
        super(damage);
    }

    @Override
    public int getlife() {
        return this.life;
    }

    @Override
    public void defend(int damage) {
        if(damage == 0){
            System.out.println("No defence needed!");
            return;
        }
        System.out.printf("Was hit with a damage of: %s\n", damage);
        reduceLife(damage);
        if(this.getlife() <=0){
            this.life = 0;
        }
    }

    @Override
    public boolean isAlive() {
        return getlife()>1;
    }

    @Override
    public void increaseLife(int life) {
    this.life += life;
    }

    @Override
    public void reduceLife(int damage) {
    this.life -= damage;
    }
}
