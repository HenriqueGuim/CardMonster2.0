package academy.mindswap;

public class Random {
    public static int getRandomNumber(int min, int max){
            return (int) (Math.random() * (max - min + 1) + min);
        }


    private Random(){}
}
