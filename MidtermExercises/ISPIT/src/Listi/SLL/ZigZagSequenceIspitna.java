package Listi.SLL;

import java.util.Scanner;

public class ZigZagSequenceIspitna {

    public static void makeZigZag(SLL<Integer> list){

        SLLNode<Integer> tmp = list.getFirst();

        while(tmp != null && tmp.succ != null){

            int firstValue = tmp.element;
            int secondValue = tmp.succ.element; //zemi go sledniot element

            if(firstValue > 0 && secondValue > 0){

                list.delete(tmp.succ); //se brise prviot
            }

            else if(firstValue < 0 && secondValue < 0){

                int newValue = Math.abs(firstValue);

                list.insertBefore(newValue,tmp.succ);
            }

            tmp = tmp.succ;
        }

        tmp = list.getFirst();

        while(tmp != null && tmp.succ != null) {

            if (tmp.succ.element == 0) {

                list.delete(tmp.succ);
            } else {
                tmp = tmp.succ;
            }
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

        System.out.println(list);

        makeZigZag(list);

        System.out.println(list);
    }
}
