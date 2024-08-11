package Listi.SLL;

import java.util.Scanner;

public class PrvKol2022 {

    public static void startHeroesGame(SLL<Cards> firstFriendCards, SLL<Cards> secondFriendCards){

        SLLNode<Cards> najdobraKarta = firstFriendCards.getFirst();
        SLLNode<Cards> tmp = secondFriendCards.getFirst().succ;

        while(najdobraKarta != null){

            if(tmp.element.significance() > najdobraKarta.element.significance()){
                najdobraKarta = tmp;
            }

            najdobraKarta = najdobraKarta.succ;
        }
        firstFriendCards.delete(najdobraKarta);

        SLLNode<Cards> middle = secondFriendCards.getFirst();

        for (int i = 0; i < 3; i++) {

            middle = middle.succ;
        }

        secondFriendCards.insertBefore(najdobraKarta.element,middle);

    }

    public static void main(String[] args) {
        SLL<Cards> prv = new SLL<>();
        SLL<Cards> vtor = new SLL<>();
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<6;i++)
        {
            int id = scanner.nextInt();
            int power = scanner.nextInt();
            int numAttacks = scanner.nextInt();
            Cards c1 = new Cards(id,power,numAttacks);
            prv.insertLast(c1);
        }
        for(int j=0;j<6;j++)
        {
            int id = scanner.nextInt();
            int power = scanner.nextInt();
            int numAttacks = scanner.nextInt();
            Cards c1 = new Cards(id,power,numAttacks);
            vtor.insertLast(c1);
        }
        startHeroesGame(prv,vtor);
        System.out.println(prv.toString());
        System.out.println(vtor.toString());
    }

}
class Cards
{
    int id;
    int power;
    int numAttacks;

    public Cards(int id, int power, int numAttacks)
    {
        this.id = id;
        this.power = power;
        this.numAttacks = numAttacks;
    }

    public int getId() {
        return id;
    }

    public int getPower() {
        return power;
    }

    public int getNumAttacks() {
        return numAttacks;
    }

    public int significance(){
        return power * numAttacks;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

