package DLL;

//2 ZAD OD TIE ZA VEZBANJE
public class Z2ListaOdListi {

    public static long findMagicNumber(DLL<DLL<Integer>> list) {

        DLLNode<DLL<Integer>> curr = list.getFirst();
        long product = 1;
        long sum = 0;

        while(curr != null){

            DLL<Integer> sublist = curr.element;
            DLLNode<Integer> element = sublist.getFirst(); //na sublistata zemi go prviot element

            curr = curr.succ;

            while(element != null){

                sum += element.element;
                element = element.succ;
            }
            product *= sum;
            sum = 0;
        }
        return product;
    }


}
