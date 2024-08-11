package Listi.DLL;

import java.util.Scanner;

public class PalindromiAPSBook {

    public static int palindrome(DLL<Integer> list) {

        DLLNode<Integer> tmp = list.getFirst();
        DLLNode<Integer> last = list.getLast();

        while (tmp != null) {
            if (!tmp.element.equals(last.element)) {
                return -1;
            }
            tmp = tmp.succ;
            last = last.pred;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(in.nextInt());
        }
        System.out.println(palindrome(list));
    }
}
