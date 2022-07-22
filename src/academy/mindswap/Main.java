package academy.mindswap;

import academy.mindswap.SuperNatural.Fairy;
import academy.mindswap.SuperNatural.Monsters.Mummy;
import academy.mindswap.SuperNatural.Monsters.Vampire;
import academy.mindswap.SuperNatural.Monsters.Werewolf;
import academy.mindswap.SuperNatural.SuperNatural;
import academy.mindswap.SuperNatural.Witch;

public class Main {
    public static void main(String[] args) {
        GameProcess game= new GameProcess("player1", "player2",4);

        game.play();
    }
}
