package ListiSLL;

import java.util.Scanner;

/*
Да се напише функција којашто за дадена еднострано поврзана листа од цели броеви ќе го врати бројот на парни елементи во истата.
 */
public class Zad2SLL {

    public static int evenNumbers(SLL<Integer> list){

        SLLNode<Integer> tmp = list.getFirst();
        int res = 0;

        while(tmp != null){

            if(tmp.element % 2 == 0){ //MORA ELEMENTOT DA SE PROVERI DALI E PAREN
                res++;
            }
            tmp = tmp.succ; //dvizi niz listata
        }
        return res;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        System. out.println("Vnesete go brojot na elementi vo listata:");
        int n = sc.nextInt(); //vnesi cel broj

        SLL<Integer> list = new SLL<> ();
        System.out.println("Vnesete gi elementite na listata (celi broevi):");
        for(int i=0;i<n;i++) {
            list.insertLast(sc.nextInt());
        }

        System.out.println ("Brojot na parni element vo vnesenata lista e: " + evenNumbers (list));
    }
}
