package Listi.SLL;

import java.util.Scanner;

public class IzbrisiPosledenAPSBook {

    public static void izbrisiPoslednoPojavuvanje(SLL<Integer> list, int k){

        SLLNode<Integer> tmp = list.getFirst();
        SLLNode<Integer> prev = null;

        while(tmp != null){

            if(tmp.element == k){
                prev = tmp;
            }

            tmp = tmp.succ;
        }

        if(prev != null){
            list.delete(prev);
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        SLL<Integer> list = new SLL<>();

        for (int i = 0; i < n; i++)
        {
            list.insertLast(scanner.nextInt());
        }

        int k = scanner.nextInt();

        izbrisiPoslednoPojavuvanje(list, k);

        System.out.println(list);
    }
}
