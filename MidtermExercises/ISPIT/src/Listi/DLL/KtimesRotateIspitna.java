package Listi.DLL;

import java.util.Scanner;

public class KtimesRotateIspitna {

    public static void rotateKtimes(DLL<Integer> list, int k){ //treba da se izrotira k pati na desno

            DLLNode<Integer> first = list.getFirst();
            DLLNode<Integer> last = list.getLast();

        while (k != 0){

            //The lines first = list.getFirst(); and last = list.getLast();
            // inside the loop ensure that the first and last pointers are updated in each iteration,
            // allowing the correct rotation of the doubly linked list


            first = list.getFirst();
            last = list.getLast();
            list.insertBefore(last.element, first);
            list.delete(last);

            last = last.succ;
            k--;

//  Original List: 1 <-> 2 <-> 3<-> 4 <-> 5
//• first is initially pointing to the first node (1).
//• 'last is initially pointing to the last node (5).
//  2. First Iteration (k = 2):
//• 'list. insertBefore(last.element, first);*: Inserts the element of the last node (5) before the first node (1).
//• List after insertion: 5 <-> 1<-> 2<-> 3<-> 4
//• 'list.delete (last);*: Deletes the last node (5).
//• List after deletion: 1<-> 2<-> 3 <-> 4
//• 'last = last. succ;*: Advances the last pointer to the successor of the previous last node (4).
//• *k--;*: Decrements 'k' to 1.
//            3. Second Iteration (k = 1):
//• list.insertBefore(last.element, first);*: Inserts the element of the last node (4) before the first node (1).

            }
    }

    public static void main(String[] args) {
        DLL<Integer> lista = new DLL();
        Scanner input  = new Scanner(System.in);
        int N = input.nextInt();
        for(int i=0;i<N;i++)
        {
            lista.insertLast(input.nextInt());
        }
        int k = input.nextInt();

        rotateKtimes(lista,k);

        System.out.println(lista);
    }
}
