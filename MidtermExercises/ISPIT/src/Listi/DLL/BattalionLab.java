package Listi.DLL;

import java.util.Scanner;

public class BattalionLab {

    public static void battalion(DLL<Integer> list, int a, int b) {

        DLLNode<Integer> first = list.find(a);
        DLLNode<Integer> last = list.find(b);

        while(first != last.succ){

            list.insertAfter(first.element, last);
            first = first.succ;
            list.delete(first.pred);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        DLL<Integer> list = new DLL<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        int a = input.nextInt();
        int b = input.nextInt();

        battalion(list, a, b);

        System.out.println(list);
        System.out.println(list.toStringR());
    }
}