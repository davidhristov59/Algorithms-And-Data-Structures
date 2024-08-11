package Listi.SLL;

import java.util.Scanner;

class Card {
    private int type;
    private int health;
    private int magicPower;

    public Card(int type, int health, int magicPower) {
        this.type = type;
        this.health = health;
        this.magicPower = magicPower;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public int significance() {
        return health * magicPower;
    }

    @Override
    public String toString() {
        return String.valueOf(type);
    }
}

public class MysticalCardLab {

    public static void startDuel(SLL<Card> firstSorcererCards, SLL<Card> secondSorcererCards) {

        SLLNode<Card> best = firstSorcererCards.getFirst();
        SLLNode<Card> tmp = firstSorcererCards.getFirst().succ;

        while(tmp != null ){

            if(tmp.element.significance() > best.element.significance()){

                best = tmp; //se naoga najdobrata
            }
            tmp = tmp.succ;
        }
        firstSorcererCards.delete(best);

        SLLNode<Card> middle = secondSorcererCards.getFirst();

        for (int i = 0; i < 4; i++) { //odi do 4 bidejki vika imaat 8 karti i deli na pola

            middle = middle.succ;
        }

        secondSorcererCards.insertBefore(best.element,middle);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SLL<Card> firstSorcererCards = new SLL<Card>();
        SLL<Card> secondSorcererCards = new SLL<Card>();

        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            firstSorcererCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            secondSorcererCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        startDuel(firstSorcererCards, secondSorcererCards);
        System.out.println(firstSorcererCards);
        System.out.println(secondSorcererCards);
    }
}
