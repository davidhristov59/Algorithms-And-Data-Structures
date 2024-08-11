package Listi.SLL;

import java.util.Scanner;

public class DeleteSLLVezbanje {

    public static void change(SLL<Integer> list, int br){

        SLLNode<Integer> curr = list.getFirst();

        while(curr != null){

            if(curr.element.equals(br)){
                break;
            }

            curr = curr.succ;
        }

        SLLNode<Integer> tmp = list.getFirst();

        int counter = 0;
        while(tmp != null){

            if(tmp.element.equals(br)){
                counter++;
            }

            tmp = tmp.succ;
        }

        if(counter % 2 == 1 ){
            list.insertBefore(br, tmp);
        }


    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n, broj;
        SLL<Integer> list1 = new SLL<Integer>();
        n = scan.nextInt();
        for(int i = 0; i<n; i++) {
            list1.insertLast(scan.nextInt());
        }
        int br = scan.nextInt();
        change(list1,br);
        System.out.println(list1);
    }
}
