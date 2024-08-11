package Listi.SLL;

import java.util.Scanner;

public class RazdeliListaAPSBook {

    public static SLL<Integer> razdeliLista(SLL<Integer> list){

        SLL<Integer> parni = new SLL<>();
        SLL<Integer> neparni = new SLL<>();
        SLL<Integer> result = new SLL<>();

        SLLNode<Integer> tmp = list.getFirst();

        while(tmp != null){

            if(tmp.element % 2 == 0){
                parni.insertLast(tmp.element);
            }
            else {
                neparni.insertLast(tmp.element);
            }

            tmp = tmp.succ;
        }

        result.merge(parni);
        result.merge(neparni);

        return result;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        SLL<Integer> lista = new SLL();
        for (int i = 0; i < N; i++) {
            int broj = input.nextInt();
            lista.insertLast(broj);
        }

        lista = razdeliLista(lista);

        System.out.println(lista);
    }

}
