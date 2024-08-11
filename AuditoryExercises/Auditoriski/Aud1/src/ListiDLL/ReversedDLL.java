package ListiDLL;

//Да се напише функција (метод) кој ќе превртува зададена двојно поврзана листа.

public class ReversedDLL<E> {

    protected E element;

    public void mirror(DLL<E> list){

        DLLNode<E> last = list.getLast(); //go zima posledniot element od listata
        DLLNode<E> tmp = null; //pokazuva kon null vrednost. . It will be used to temporarily store references during the reversal process.
        DLLNode<E> current = list.getFirst(); //current pokazuva kon prviot element

        last = list.getFirst(); //prviot element da bide posleden sega

        while(current != null){

            tmp = current.pred;
            current.pred = current.succ;
            current.succ = tmp;

            current = current.pred;
        }

        list.setFirst(tmp.pred);
    }

    //----------------------------------Reverse Double Linked List---------------------------------

//    public void mirror(){
//
//        DLLNode<E> tmp = null;
//        DLLNode<E> current = first;
//
//        while(current != null){
//            tmp = current.pred; //na tmp e naznacena referencata(predecessor) na prethodniot node od current
//            current.pred = current.succ; //The pred reference of the current node is updated to point to the succ node. This essentially reverses the direction of the pointers for the current node
//            current.succ = tmp; //the succ reference of the current node is updated to point to the previous node, which was stored in the temp variable. This step completes the reversal of the pointers for the current node
//
//            current = current.pred; //This ensures that the loop progresses to the next node in the original order.
//        }
//
//        if(tmp != null && tmp.pred != null){
//            first = tmp.pred;
//        }

//        list.setFirst(temp.pred); //After the loop, the first node of the doubly linked list (list) is updated to point to the last node (which was stored in the temp variable). This step is necessary to reflect the reversal in the list's starting point.

//    }


    //----------------------------------Reverse Double Linked List---------------------------------

    @Override
    public String toString() {
        return "<-" + element.toString() + "->" ;
    }

    public static void main(String[] args) {

        DLL<String> stringDLL = new DLL<>();
        ReversedDLL<String> reversedDLL = new ReversedDLL<>();

        stringDLL.insertLast("ovaa");
        stringDLL.insertLast("lista");
        stringDLL.insertLast("kje");
        stringDLL.insertLast("bide");
        stringDLL.insertLast("prevrtena");

        System.out.println("Listata pred prevrtuvanje");
        System.out.println(stringDLL.toString());

        reversedDLL.mirror(stringDLL);

        System.out.println("Listata posle prevrtuvanje");
        System.out.println(reversedDLL.toString());


    }
}
