package academy.mindswap.SuperNatural;

public class Witch extends SuperNatural implements Attackable, Defendeable{
    private int life = 100;
    public Witch() {
        super(5);
    }

    @Override
    public int getlife() {
        return this.life;
    }

        @Override
        public void defend(int damage) {
            damage /=2;
            if(damage == 0){
                System.out.println("The Witch hasn't need to defence needed!");
                return;
            }
            System.out.printf("Witch was hit with a damage of: %s\n", damage);
            reduceLife(damage);
        }


    @Override
    public boolean isAlive() {
        return this.life < 1;
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
