package academy.mindswap.SuperNatural;

public abstract class SuperNatural implements Attackable {
    private int damage;
    private int life= 100;
   public SuperNatural(int damage){
        this.damage = damage;
    }


    public int getDamage() {
        return damage;
    }

    @Override
    public int attack() {
       int damage = this.damage;
        return damage;
    }
}
