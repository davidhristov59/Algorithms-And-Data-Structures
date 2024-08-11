package Listi.SLL;

public class ZameniSosediAPSBook {

    public static void swapPairs(SLL<Integer> list){

        SLLNode<Integer> tmp = list.getFirst();

        while(tmp != null){

            Integer pomosna  = tmp.element;

            tmp.element = tmp.succ.element;
            tmp.succ.element = pomosna;

            tmp = tmp.succ.succ;
        }

    }

    public static void main(String[] args) {



    }
}
