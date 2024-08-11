package Nizi;

import java.util.ArrayList;

/*
Нека се дадени две низи, кои треба да бидат со иста големина.
Да се напише функција која ќе прави промени во двете низи така што доколку на
дадена позиција тие имаат еднакви елементи, истите треба да се избришат и во
двете низи.
 */
public class Zad1<E> {

    public void compareAndChangeArrays(ArrayList<E> niza1, ArrayList<E> niza2){

        if(niza1.size() != niza2.size()){
            System.out.println("Nizite ne se so ista golemina");
        }

        int size = niza1.size();
        int i = 0;

        while(i < size){
            if(niza1.get(i).equals(niza2.get(i))){ //zemi go indeksot od ednata niza i so equals sporedi go dali se isti so drugata niza elementot
                // ako imaat na dadena pozicija isti elementi, izbrisi gi
                niza1.remove(i);
                niza2.remove(i);
                size--; //namali ja goleminata na nizata
            }
            else { //The else block ensures that the loop proceeds to the next position in the arrays when the elements are not equal.
                i++; //DVIZI NA SLEDNATA POZICIJA AKO NAJDAT ISTI ELEMENTI
            }
        }

    }

    public static void main(String[] args) {

        ArrayList<Integer> niza3 = new ArrayList<Integer> ( 3);
        niza3.add(10);
        niza3.add(13); //na isto mesto ima 13
        niza3.add(7);

        ArrayList<Integer> niza4 = new ArrayList<Integer> (3);
        niza4.add(5);
        niza4.add(13); //na isto mesto ima 13
        niza4.add(3);

        System.out.println("Nizite pred primenuvanjeto na funkcijata: ");
        System.out.println (niza3.toString());
        System.out.println(niza4.toString());

        Zad1<Integer> pom2 = new Zad1<Integer>();
        pom2.compareAndChangeArrays (niza3, niza4);
        System.out.println ("Nizite po primenuvanjeto na funkcijata: ");
        System.out.println (niza3.toString());
        System.out.println(niza4.toString());

    }

}
