package ListiDLL;

import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeDLL {

    public static int isPalindrome(DLL<Integer> integerDLL){ //static deka vrakame 1 ili 0 i ke imame pristap vo mainot preku metodot

        //gi zima prviot i posledniot jazol
        DLLNode<Integer> poceten = integerDLL.getFirst();
        DLLNode<Integer> posleden = integerDLL.getLast();

        while((poceten != posleden) && (poceten.pred != posleden)){

            if(!poceten.element.equals(posleden.element)){ //ako prviot element NE E IST SO Posledniot - ODMA NEGACIJA
                return -1;
            }
            poceten = poceten.succ; //se povrzuvaat jazlite - od prv do posleden preku successori - sledbenici
            posleden = posleden.pred;  //se povrzuvaat i so prethodnicite preku predecessor
        }
        return 1;
    }

    public static int isPalindromeLinkedList(LinkedList<Integer> list){

        for (int i = 0; i < list.size() / 2; i++) { //do pola odi

                                    //        n-i-1
            if(!list.get(i).equals(list.get(list.size()-i-1))){ //dali i pozadi elementite se isti proveruva
                return -1; //odi prvo so negacija
            }
        }
        return 1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        DLL<Integer> integerDLL = new DLL<Integer>();

        for (int i = 0; i < n; i++) {
            integerDLL.insertLast(scanner.nextInt());
        }
        scanner.close();
        System.out.println(isPalindrome(integerDLL));


        //so LinkedList resenie
      /*
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(scanner.nextInt());
        }
        scanner.close();
        System.out.println(isPalindromeLinkedList(linkedList));

       */
    }
}

