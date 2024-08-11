package SLL;

import java.util.Scanner;

public class DeleteLast {
//    Избриши последно поjавување на броj

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SLL<Integer> list = new SLL<Integer>();

        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        int m = scanner.nextInt(); //brojot sto ke go briseme


        //RESENIE
        SLLNode<Integer> tmp = list.getFirst();
        SLLNode<Integer> last = null;

        while(tmp != null){

            if(tmp.element == m){
                last = tmp;
            }

            tmp = tmp.succ;
        }

        if(last != null){
            list.delete(last);
        }

        System.out.println(list.toString());
    }

}
