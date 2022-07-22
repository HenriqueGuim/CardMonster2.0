package academy.mindswap;


import academy.mindswap.SuperNatural.Monsters.Monsters;
import academy.mindswap.SuperNatural.Monsters.Mummy;
import academy.mindswap.SuperNatural.Monsters.Vampire;
import academy.mindswap.SuperNatural.Monsters.Werewolf;

public class Player {
    private String name;
    private int cardAmount;


    private int deadCards;
    private Monsters[] deck;

    public Player(String name, int cardAmount) {
        this.name = name;
        this.cardAmount = cardAmount;
        this.deck = new Monsters[cardAmount];
    }

    private Monsters pickACard(){
        int position = Random.getRandomNumber(0,this.cardAmount-1);
        if(!deck[position].isAlive()){
            return pickACard();
        }
        return deck[position];
    }

    private int attack(){
        Monsters card = pickACard();
        String cardType = findCardType(card);
        int attackPower = card.attack();
        if (attackPower == 0){System.out.printf("The %s of %s unrolled!\n", cardType, getName());
            return 0;}
        System.out.printf("The %s of %s attacked the opponent!\n", cardType, getName());
        return attackPower;
    }


    private String findCardType(Monsters card) {
        return card.getClass().getSimpleName();
    }

    public void defend(int attackPower){
        Monsters card = pickACard();
        String cardType = findCardType(card);
        if(attackPower == 0){
            System.out.printf("The %s of %s doesn't have to defend!\n", cardType, getName());
            return;
        }
        System.out.printf("The %s of %s defended from an attack!\n", cardType, getName());
        card.defend(attackPower);
        if(!card.isAlive()){
            deadCards++;
        }
    }
    public int playerAttacks(){
        return attack();
    }

    public String getName() {
        return name;
    }

    public void generateDeck() {
        for (int i = 0; i < this.deck.length; i++) {
            CreatureType monster = CreatureType.values()[Random.getRandomNumber(0,2)];

            switch (monster){
                case WEREWOLF: deck[i] = new Werewolf();
                    //System.out.println("Werewolf");
                    break;
                case VAMPIRE: deck[i] = new Vampire();
                    //System.out.println("Vampire");
                    break;
                default: deck[i] = new Mummy();
                    //System.out.println("Mummy");

            }
        }
    }
    public int getDeadCards() {
        return deadCards;
    }
}