package academy.mindswap;


import academy.mindswap.SuperNatural.Defendeable;
import academy.mindswap.SuperNatural.Fairy;
import academy.mindswap.SuperNatural.SuperNatural;
import academy.mindswap.SuperNatural.Witch;

public class GameProcess {
    Player player1;
    Player player2;
    int numberOfCards;

    public GameProcess(String player1, String player2, int numberOfCards){
        this.player1 = new Player(player1, numberOfCards);
        this.player2 = new Player(player2, numberOfCards);
        this.numberOfCards = numberOfCards;
    }




    public void play(){
        player1.generateDeck();
        player2.generateDeck();
        if(Random.getRandomNumber(0,1) == 0){
            game(player1, player2);
            return;
        }
        game(player2,player1);

    }



    private void obstacle(Player player, Player opponent, int randomNumber){
        SuperNatural obstacle;
         obstacle = randomNumber ==3 ? new Fairy() : new Witch();

         if( obstacle instanceof Defendeable){
             System.out.printf("A witch as appeared!");
             player.defend(obstacle.attack());
             if(gameEnded(player,opponent)){
                 return;
             }
             opponent.defend(obstacle.attack());
             if(gameEnded(player,opponent)){
                 return;
             }
             ((Defendeable) obstacle).defend(player.playerAttacks());
             ((Defendeable) obstacle).defend(opponent.playerAttacks());
             return;
         }
        System.out.println("A fairy as appeared!");
        player.defend(obstacle.attack());
        if(gameEnded(player,opponent)){
            return;
        }
        opponent.defend(obstacle.attack());
        if(gameEnded(player,opponent)){
            return;
        }
    }

    private GameProcess game(Player player, Player opponent){
        int random = Random.getRandomNumber(1,4);
        if( random >2){
            obstacle(player, opponent, random);
        }
        if(gameEnded(player,opponent)){
            return null;
        }


        player.defend(opponent.playerAttacks());

        if(gameEnded(player,opponent)){
            return null;
        }

        random = Random.getRandomNumber(1,4);
        if( random >2){
            obstacle(player, opponent, random);
        }

        if(gameEnded(player,opponent)){
            return null;
        }

        opponent.defend(player.playerAttacks());
        if(gameEnded(player,opponent)){
            return null;
        }
        return game(player, opponent);
    }



    public boolean gameEnded(Player player, Player opponent){

        if(player.getDeadCards() == numberOfCards){
            System.out.printf("%s has won!\n", opponent.getName());
            return true;
        }
        if(opponent.getDeadCards() == numberOfCards){
            System.out.printf("%s has won!\n", player.getName());
            return true;
        }
        return false;
    }
}
