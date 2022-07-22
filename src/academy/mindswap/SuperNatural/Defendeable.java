package academy.mindswap.SuperNatural;

public interface Defendeable {
    int getlife();
    void defend(int damage);
    boolean isAlive();
    void increaseLife(int life);
    void reduceLife(int damage);
}
