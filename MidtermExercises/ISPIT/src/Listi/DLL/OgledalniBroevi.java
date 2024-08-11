package Listi.DLL;

import Listi.SLL.SLL;

import java.util.Scanner;

public class OgledalniBroevi {

    //vlez: 1 2 3 4 5
    //izlez: 1 5 2 4 3;

    //vlez 1 2 3 4
    //izlez 1 4 2 3

    //vlez: 1 4 8 6 3 5 7;
    //izlez: 1 7 4 5 8 3 6;
    //se spojuvaat prv so posleden, vtor so predposleden itn.

    public static void mirrorList(DLL<Integer> list){

        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();

        if(list.length() % 2 == 0){
            for (int i = 0; i < list.length() / 2 ; i++) {
                first = first.succ;
                list.insertBefore(last.element, first); //first
                list.delete(last);
                last = last.pred;
            }
        }
        else { //ako e neparna goleminata

            while(first != last){ //vo while namesto vo for.
                // This choice is made to handle the situation where the first and last nodes are not at the exact middle of the list, and they need to meet and mirror each other.
                first = first.succ;
                list.insertBefore(last.element,first);
                list.delete(last);
                last = last.pred;
            }
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        DLL<Integer> lista = new DLL();
        for(int i = 0;i < N;i++){
            int broj = input.nextInt();
            lista.insertLast(broj);
        }

        mirrorList(lista);
        System.out.println(lista);
    }
}
