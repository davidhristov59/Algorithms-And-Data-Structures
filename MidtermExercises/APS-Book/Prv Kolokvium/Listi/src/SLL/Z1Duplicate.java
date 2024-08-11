package SLL;

import java.util.Scanner;

//od tie za vezbanje
public class Z1Duplicate {

    public static void change(SLL<Integer> list, int br) {

        SLLNode<Integer> tmp = list.getFirst();

        while(tmp != null){

            if(tmp.element.equals(br)){ //ako se povtoruva brojot sto sakame da go vneseme
                break;
            }

            tmp = tmp.succ;
        }

        int counter = 0;

        SLLNode<Integer> curr = list.getFirst();
        while(curr != null){

            if(curr.element.equals(br)){ //proveruvame dali elementite se isti, ako se isti izbroj
                counter++;
            }

            curr = curr.succ;
        }

        if(counter % 2 == 1){ //ako e neparen se insertnuva toj broj sto sme go nasle
            list.insertBefore(br,curr);
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
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
