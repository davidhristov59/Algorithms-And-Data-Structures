package Listi.SLL;

import java.util.Scanner;

public class SmeniJazliVezbanje {

    //input 1 2 3 4
    //output 2 1 4 3

    public static void swapNodes(SLL<Integer> list){

        SLLNode<Integer> tmp = list.getFirst();

        if(list.size() % 2 == 0){
            SLLNode<Integer> parni = null;
            parni = tmp.succ;
            list.insertBefore(parni.element, tmp);
            list.delete(parni);
            tmp = tmp.succ;
        }
        else { //ako listata ima neparen broj element
            // 1 2 3
            //2 1 3

            SLLNode<Integer> neparni = list.getFirst().succ;
            list.insertBefore(neparni.element, tmp);
            tmp = tmp.succ.succ;
            list.delete(neparni);
            neparni = neparni.succ.succ;
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
        swapNodes(lista);
        System.out.println(lista);
    }
}
