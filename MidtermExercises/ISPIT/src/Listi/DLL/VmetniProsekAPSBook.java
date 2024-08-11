package Listi.DLL;

public class VmetniProsekAPSBook {

    public static void prosek(DLL<Integer> list){

        DLLNode<Integer> tmp = list.getFirst();
        DLLNode<Integer> next = tmp.succ;

        while(tmp != null){

            float a = tmp.element;
            float b = tmp.element;

            Integer result = Math.round((a+b)/2);

            list.insertAfter(result, tmp);
            tmp = next;

            next = tmp.succ;
        }

        tmp = list.getFirst();

        while(tmp != null){

            System.out.println(tmp.element + " ");

            tmp = tmp.succ;
        }

    }

    public static void main(String[] args) {

    }
}
