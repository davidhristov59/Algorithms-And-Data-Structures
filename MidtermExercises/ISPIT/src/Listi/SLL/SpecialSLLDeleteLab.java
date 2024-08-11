package Listi.SLL;

import java.util.Scanner;

public class SpecialSLLDeleteLab<E> {

    public void specialDelete(SLL<E> list, int m) {

        SLLNode<E> tmp = list.getFirst();
        SLLNode<E> prev = null;

        int counter = 1;
        while(tmp != null){

            if(counter % m == 0){

                prev.succ = tmp.succ;
            }
            else {
                prev = tmp;
            }

            counter++; //mora counterot da dvizi niz listata
            tmp = tmp.succ;
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        SLL<Integer> list = new SLL<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        int m = input.nextInt();

        SpecialSLLDeleteLab<Integer> tmp = new SpecialSLLDeleteLab<>();

        tmp.specialDelete(list, m);

        System.out.println(list);
    }
}
