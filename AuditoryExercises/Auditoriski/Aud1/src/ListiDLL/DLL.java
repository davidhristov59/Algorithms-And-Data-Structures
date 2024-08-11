package ListiDLL;

public class DLL<E>{

    private DLLNode<E> first, last;

    public DLL() {
        //Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void deleteList(){

        first = null;
        last = null;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public void setFirst(DLLNode<E> first) {
        this.first = first;
    }

    public DLLNode<E> getLast() {
        return last;
    }

    //----------------------------------Reverse Double Linked List---------------------------------

    public void mirror(){

        DLLNode<E> tmp = null;
        DLLNode<E> current = first;

        while(current != null){
            tmp = current.pred; //na tmp e naznacena referencata(predecessor) na prethodniot node od current
            current.pred = current.succ; //The pred reference of the current node is updated to point to the succ node. This essentially reverses the direction of the pointers for the current node
            current.succ = tmp; //the succ reference of the current node is updated to point to the previous node, which was stored in the temp variable. This step completes the reversal of the pointers for the current node

            current = current.pred; //This ensures that the loop progresses to the next node in the original order.
        }

        if(tmp != null && tmp.pred != null){
            first = tmp.pred;
        }

//        list.setFirst(temp.pred); //After the loop, the first node of the doubly linked list (list) is updated to point to the last node (which was stored in the temp variable). This step is necessary to reflect the reversal in the list's starting point.

    }

    //----------------------------------Reverse Double Linked List---------------------------------

    public int length(){
        int ret;
        if(first != null){
            DLLNode<E> tmp = first;
            ret = 1;
            while(tmp.succ != null){
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        }
        else {
            return 0;
        }
    }

    public void insertFirst(E o){
        DLLNode<E> pomosna = new DLLNode<E>(o,null, first);

        if(first == null){ //ako prviot node e null, sto znaci celata lista e null
            last = pomosna; //posledniot node sega ke pokazuva kon noviot node - pomosna .

            //Vo prazna lista noviot node stanuva i prv i posleden node
        }
        else{ //ako ima elem vo listata
            first.pred = pomosna; //noviot node pomosna ke bide pred first elementot so znaci KE GO INSERTIRAME da bide prv

//            This step ensures that the previous first node is properly linked to the new first node in the doubly linked list.
        }

        first = pomosna;  //bez razlika dali e prazna ili ne listata , noviot node sega ke bide first
    }

    public void insertLast(E o){
        if(first == null){
            insertFirst(o);
        }
        else {
            DLLNode<E> pomosna = new DLLNode<>(o,last,null); //pred - last element, succ - null

            last.succ = pomosna;  //succ na last ke bide sega noviot node - pomosna
            //This step ensures that the existing last node is properly linked to the new last node in the doubly linked list.

            last = pomosna; //this line updates the last reference to point to the new node ins. This effectively makes the new node the last node in the doubly linked list.
        }
    }

    public void insertAfter(E o, DLLNode<E> after){ //insert a node after the 'after' node

       if(after == last){
           insertLast(o);
           return;
       }

       DLLNode<E> pomosna = new DLLNode<E>(o,after,after.succ);

       after.succ.pred = pomosna;

       after.succ = pomosna;

    }

    public void insertBefore(E o, DLLNode<E> before){

        if(before == first){ //ako before node-ot e prv
            insertFirst(o);
            return;
        }

        DLLNode<E> pomosna = new DLLNode<>(o,before.pred,before);

        before.pred.succ = pomosna;

        before.pred = pomosna;
    }


    public E deleteFirst(){

        if(first != null){

            DLLNode<E> tmp = first;
            first = first.succ;  //it removes the current first node from the list by changing the first reference to point to the next node.

            if(first != null)
                first.pred = null; //prviot element nema prethodnik, prethodnikot pokaxuva kon null
// If it's not null, it sets the predecessor (.pred) of the new firstnode tonull`. This is done to ensure that the new first node doesn't have a predecessor since it is now the first node in the list.

            if(first == null)
                last = null; // If the first node is null, it means that the list is empty, so it also sets the last node to `null

            return tmp.element; //This is the element that was originally at the beginning of the list.

        }
        else
            return null;
    }

    public E deleteLast(){

        if(first != null){
            if(first.succ == null){
                return deleteFirst();
            }
            else {
                DLLNode<E> tmp = first;
                last = last.pred; //The last reference is updated to point to the predecessor (.pred) of the current last node. This effectively removes the last node from the list by changing the last reference
                last.succ = null;  //nema sledbenik posledniot element, na null pokazuva

                return tmp.element;
            }
        }
        return null;
    }

    public E delete(DLLNode<E> node){

        if(first == node){ //ako e prviot node sto sakame da go izbriseme
            return deleteFirst();
        }

        if(last == node){ //ako e posledniot node sto sakame da go izbriseme
            return deleteLast();
        }

        //If the node is not the first or last node in the list, it means you are trying to delete an intermediate node.
        node.pred.succ = node.succ; //node.pred.succ is the successor (next node) of the node before node
        node.succ.pred = node.pred; //is the predecessor (previous node) of the node after node

        return node.element; //go vraka izbrisaniot element
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> tmp = first;
            ret += tmp + "<->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "<->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public int getSize(){ //goleminata na listata
        int listSize = 0;

        DLLNode<E> tmp = first;

        while(tmp != null){
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    public static void main(String[] args) {

        DLL<Integer> list = new DLL<>();

        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);

        System.out.println("Double Linked List: ");
        System.out.println(list.toString());

        DLLNode<Integer> afterNode = list.getFirst().succ;
        list.insertAfter(7,afterNode);

        DLLNode<Integer> beforeNode = list.getLast().pred;
        list.insertBefore(8,beforeNode);

        System.out.println("Modified Double Linked List");
        System.out.println(list.toString());

        list.deleteFirst();
        System.out.println("After deleting the first element: ");
        System.out.println(list.toString());

        list.deleteLast();
        System.out.println("After deleting the last element: ");
        System.out.println(list.toString());

        DLLNode<Integer> elementToFind = list.getFirst().succ;
        list.delete(elementToFind);
        System.out.println("After deleting a specific element ");
        System.out.println(list.toString());

        System.out.println("Size of the list: " + list.getSize());


        //----------------------------------Reverse Double Linked List---------------------------------
        DLL<String> stringDLL = new DLL<>();

        stringDLL.insertLast("ovaa");
        stringDLL.insertLast("lista");
        stringDLL.insertLast("kje");
        stringDLL.insertLast("bide");
        stringDLL.insertLast("prevrtena");

        System.out.println("Listata pred prevrtuvanje");
        System.out.println(stringDLL.toString());

        stringDLL.mirror();

        System.out.println("Listata posle prevrtuvanje");
        System.out.println(stringDLL.toString());

    }

}
