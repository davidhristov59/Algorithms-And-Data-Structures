package ListiSLL;

public class ReverseLinkedList<E> {

    //1 -> 2 -> 3 -> 4 -> 5 -> null
    //5 -> 4 -> 3 -> 2 -> 1

    private SLLNode<E> first;

    public ReverseLinkedList(){}

    public ReverseLinkedList(SLLNode<E> first) {
        this.first = first;
    }

    public void mirror(){

        if(first != null) {

            SLLNode<E> tmp = first;
            SLLNode<E> prev = null;
            SLLNode<E> next;
//            SLLNode<E> next = tmp.succ;

            while (tmp != null) {

                next = tmp.succ; //store the next node
                tmp.succ = prev; //reverse the successor pointer
                prev = tmp; //move prev to the current node
                tmp = next; //move current to the next node

            }
            first = prev;  // Update the first node to be the last node (the previous one)
        }
    }

    public static void main(String[] args) {

        SLL<Integer> integerSLL = new SLL<Integer>();
        ReverseLinkedList<Integer> reverseLinkedList = new ReverseLinkedList<Integer>();

        integerSLL.insertLast(1);
        integerSLL.insertLast(2);
        integerSLL.insertLast(3);
        integerSLL.insertLast(4);
        integerSLL.insertLast(5);
        System.out.println("Listata pred da bide prevrtenea" + integerSLL.toString());

        reverseLinkedList.mirror();

        System.out.println("Listata otkako e prevrtena" + integerSLL.toString());


    }

}

//NE FUNKCIONIRA MAIN-OT INAKU METODOT E TOCEN