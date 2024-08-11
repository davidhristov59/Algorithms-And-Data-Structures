package Listi.SLL;

import java.util.Scanner;

public class BrisenjeJazolOdDadenaPozicijaPozadiVezbanje {

        public static void deleteNode2(SLL<Integer> list, int broj){ //bolje opcija

            SLLNode<Integer> tmp = list.getFirst();

            for (int i = 0; i < broj ; i++) { //broj - 1
                tmp = tmp.succ;
            }

            if(tmp.succ != null){
                tmp.succ = tmp.succ.succ;
            }

        }

        public static void deleteNode(SLL<Integer> list, int broj){

        SLLNode<Integer> tmp = list.getFirst();
        SLLNode<Integer> next = list.getFirst();
        SLLNode<Integer> prev = null;

        for (int i = 0; i < broj; i++) { //do toj broj lista
            tmp = tmp.succ;
        }

        while(tmp != null){

            tmp = tmp.succ;
            prev = next;
            next = next.succ;
        }

        if(prev != null){
            prev.succ = next.succ;
        }
        else { //ako e prvata pozicija
            list.getFirst().succ = next.succ;
        }


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        SLL<Integer> lista = new SLL();
        for(int i = 0;i < N;i++){
            int broj = input.nextInt();
            lista.insertLast(broj);
        }
        int broj = input.nextInt();
        deleteNode2(lista, broj);
        System.out.println(lista);
    }
}
