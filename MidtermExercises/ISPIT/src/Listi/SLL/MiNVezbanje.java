package Listi.SLL;

import java.util.Scanner;

public class MiNVezbanje {

    public static void swap(SLL<Integer> lista, int m, int n){

        SLLNode<Integer> current = lista.getFirst();
        SLLNode<Integer> start = null;
        SLLNode<Integer> end = null;

        int counter = 1;

        while(current != null){
            if(counter == m){
                start = current;
            }
            if(counter == n){
                end = current;
                break;
            }
            counter++;
            current = current.succ;
        }

        current = lista.getFirst();

        while(current != null){
            if(current == start){
                while(start != end){
                    lista.insertAfter(start.element, end);
                    lista.delete(start);
                    start = start.succ;
                }
            }
            current = current.succ;
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
        int m = input.nextInt();
        int n = input.nextInt();
        swap(lista, m, n);
        System.out.println(lista);
    }
}
