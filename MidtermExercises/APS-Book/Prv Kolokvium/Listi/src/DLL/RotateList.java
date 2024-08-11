package DLL;

public class RotateList {

    public static void rotateRight(DLL<Integer> list, int k){

        int size = list.length();
        k %= size;

        while(k != 0){

            DLLNode<Integer> dvizi = list.getLast(); //deka odi na desno go zimame posledniot

            list.insertFirst(dvizi.element);
            list.delete(dvizi);
            k--;

        }
    }

    public static void rotateLeft(DLL<Integer> list, int k){

        int size = list.length();

        k %= size;

        while(k!=0){

            DLLNode<Integer> integerDLLNode = list.getFirst();

            list.insertLast(integerDLLNode.element);
            list.delete(integerDLLNode);
            k--;

        }
    }

    public static void main(String[] args) {

        DLL<Integer> list = new DLL<Integer>();

        for (int i = 0; i <= 5 ; i++) {
            list.insertLast(i);
        }

        System.out.println("Original list:" + list);

        int k =2; //primer za k rotira

        RotateList.rotateRight(list,k);
        System.out.println("List rotated to the right by + " + k + "positions: " + list);

//        RotateList.rotateLeft(list,k);
//        System.out.println("List rotated to the left by + " + k + "positions: " + list);



    }
}
