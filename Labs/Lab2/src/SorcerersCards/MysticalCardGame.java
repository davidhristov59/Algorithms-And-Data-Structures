package SorcerersCards;

import java.util.*;

class Card {

    private int type;
    private int health;
    private int magicPower;

    public Card(int type, int health, int magicPower) {
        this.type = type;
        this.health = health;
        this.magicPower = magicPower;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public int significance() {

        return health * magicPower;
    }

    @Override
    public String toString() {
        return String.valueOf(type);
    }
}


public class MysticalCardGame {


    //RABOTI - MOJ NACIN
    public static void startDuel(SLL<Card> firstSorcererCards, SLL<Card> secondSorcererCards) {

        SLLNode<Card> best = firstSorcererCards.getFirst();
        SLLNode<Card> tmp = firstSorcererCards.getFirst().succ;

        while(tmp != null){
            if(tmp.element.significance() > best.element.significance()){ //ja barame najdobrata karta
                best = tmp;
            }
            tmp = tmp.succ;
        }
        firstSorcererCards.delete(best); //se brise najdobrata karta od prviot volsebnik

        SLLNode<Card> middle = secondSorcererCards.getFirst();
        for (int i = 0; i < 4; i++) { //odi do sredina na listata
            middle = middle.succ;
        }

        secondSorcererCards.insertBefore(best.element,middle); //taa karta e dodava na sredina
        //insertAfter ako bese ke trebase do 3 vo ciklusot da ideme
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SLL<Card> firstSorcererCards = new SLL<Card>();
        SLL<Card> secondSorcererCards = new SLL<Card>();

        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            firstSorcererCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            secondSorcererCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        startDuel(firstSorcererCards, secondSorcererCards);
        System.out.println(firstSorcererCards);
        System.out.println(secondSorcererCards);
    }

}


    //--------------------------------------------------------------------------------------
    class SLLNode<E>{

        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E element, SLLNode<E> succ) {
            this.element = element;
            this.succ = succ;
        }

        public void setSucc(SLLNode<E> succ) {
            this.succ = succ;
        }

        public E getElement() {
            return element;
        }

        public SLLNode<E> getSucc() {
            return succ;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }


    class SLL<E> {

        private SLLNode<E> first;

        public SLL() {
            //kreiranje prazna lista
            this.first = null; //prviot element od lista pokazuva kon null (prazna e listata)
        }

        public SLLNode<E> getFirst() {
            return first;
        }

        public void insertFirst(E o){ //vmetni element na pocetok

            //                                 elem  succ(KON STO POKAZUVA) --> na elementot o succ ke mu bide prviot element
            SLLNode<E> pomosna = new SLLNode<E>(o,first); //elementot o ke ima successor kon first element, fakticki sega pomosnata

//        pomosna.succ = first;

            first = pomosna; //node-ot sto go napravivme(pomosna) sega ke go insertirame (ke bide first), ja dodeluvame vrednosta na pomosnata na prviot element i sega first ke bide vtor element

        /*
        In this case, the new SLLNode is created with o as its element value, and its successor is set to the existing first node.
        This means that the new node is inserted at the beginning of the linked list, and it becomes the new  head of the list.
        The old first node, which was previously the head, becomes the second node in the list.
         */

        }

        public void insertAfter(E o, SLLNode<E> node){

            if(node != null){
                SLLNode<E> pomosna = new SLLNode<E>(o,node.succ);
                node.succ = pomosna;
            }
            else {
                System.out.println("Dadeniot jazol e null");
            }

        /*
            If node is not null, it proceeds to create a new node called pomosna:
            The new node pomosna is created with the element o as its value.
            The successor of the new node pomosna is set to the current successor of the given node "node".
            This effectively links the new node to the rest of the list by having it point to the same successor as node.
            Finally, it updates the successor of the given node (node.succ) to point to the newly created node pomosna. This is how you insert the new node after the given node
         */
        }

        public void insertBefore(E o, SLLNode<E> before){ //The method insertBefore takes two parameters: 'o', which is the element to be inserted, and 'before', which is the node BEFORE which 'o' should be inserted.

            if(first!=null){ //proveruva dali listata e prazna - potocno dali first pokazuva kon null
                SLLNode<E> tmp = first; //It creates a temporary reference 'tmp' and sets it to the 'first' node. 'tmp' will be used to traverse the linked list while looking for the node before which 'o' should be inserted.
                //pravime tmp promenliva i ja pokazuva kon prviot element za DA DVIZIME NIZ LISTATA

                if(first == before){  //It checks if the 'first' node is the same as the 'node' we want to insert before. If they are the same, it means we want to insert 'o' at the beginning of the list, and for that case, there is a separate method called 'insertFirst' that should be used.
                    this.insertFirst(o);
                    return;
                }

                while(tmp.succ != before && tmp.succ != null){ //it enters a loop that iterates through the linked list. The loop continues until 'tmp.successor' is equal to 'node'. This means 'tmp' is moving through the list node by node.
                    tmp = tmp.succ; //SHIFTAME NIZ LISTATA, DVIZIME

                    //koga ke go najdeme node-ot pred da go insertneme 'o'
                    if(tmp.succ == before){ //When 'tmp.successor' is equal to 'node', it means we have found the node before which we want to insert 'o'.
                        SLLNode<E> pomosna = new SLLNode<E>(o, before); //it creates a new node 'pomosna' with the element 'o' and sets its successor to be 'before'. This essentially links 'pom' to the node that 'before' was pointing to, effectively inserting 'o' before 'before'
                        tmp.succ = pomosna; //Finally, it updates the 'tmp.successor' to point to the newly created 'pom'. This step is crucial as it updates the previous node's successor to the newly inserted node, effectively linking the previous node to 'pom' and maintaining the integrity of the linked list.
                        //najbiten cekor - tmp.succ go pravi da pokazuva kon pomosna
                    }
                }
            }
        /*
        In summary, this code allows you to insert a new node with an element 'o' before a specified node in a singly
        linked list, assuming the list is not empty. It uses a temporary reference 'tmp' to traverse the list and
        properly links the new node into the list.
         */
        }

        public void insertLast(E o){

            SLLNode<E> pomosna = new SLLNode<E>(o,null);

            if(first != null){
                SLLNode<E> tmp = first;

                while(tmp.succ != null)
                    tmp = tmp.succ;

                tmp.succ = pomosna; // Connect the last node's successor to the new node (pomosna), effectively making it the new last node.
            }
            else { //ako listata e prazna
                insertFirst(o);  // If the list is empty, insert the new node as the first node.
//        first = pomosna;
            }
        }

        public E deleteFirst(){
            if(first!=null){ //ako ne e prazna listata
                SLLNode<E> tmp = first;
                first = first.succ; //It then updates the first reference to point to the next node in the list (first = first.succ). This effectively removes the current head node from the list.

                return tmp.element; //go vrakam elementot

                // the method returns the element value (tmp.element) of the removed node, allowing you to access and work with the element that was removed.
            }
            else {
                System.out.println("Listata e prazna");

                return null;
            }
        }


        public E delete(SLLNode<E> node){
            if(first!=null){
                SLLNode<E> tmp = first;

                if(first == node){ //ako prviot node treba da se izbrise
                    this.deleteFirst(); //togas implementiraj go ovoj metod za brisenje na prviot element
                }

                while(tmp.succ != null && tmp.succ.succ != node){
                    tmp = tmp.succ;

                    if(tmp.succ == node){ //koga ke go najdeme node-ot koj sto sakame da go izbriseme
                        tmp.succ = tmp.succ.succ; //When the node to delete is found (i.e., tmp.succ == node), it updates the predecessor's reference (tmp.succ) to SKIP OVER the node to be deleted(tmp.succ.succ). This effectively removes the node from the list.

                        return node.element; //vrati go izbrisaniot node
                    }
                }
            }
            return null;
        }

        public int size(){ //goleminata na listata
            int listSize = 0;

            SLLNode<E> tmp = first;

            while(tmp != null){
                listSize++; //Inside the loop, for each node visited, listSize is incremented by 1, effectively counting the number of nodes in the list.
                tmp = tmp.succ; //the temporary reference tmp is then updated to point to the next node in the list (tmp = tmp.succ), allowing it to move through the list until it reaches the end (when tmp becomes null).
            }
            return listSize; // Return the final size of the linked list.
        }

        public void merge(SLLNode<E> node){ //merge 2 link lists together
            if(first != null){
                SLLNode<E> tmp = first;

                while(tmp.succ != null){
                    tmp = tmp.succ;
                    tmp.succ = this.getFirst(); // Connect the current list to the second list preku getter (ke go zeme prviot element i ke go spoi)
                }
            }
            else {
                first = this.getFirst();  // If the first list is empty, set its head to the head of the second list. Znaci ako prvata lista e prazna, stavi go prviot element od vtorata lista kako prv elem.
            }
        }

        public SLLNode<E> find(E o){
            if(first != null){
                SLLNode<E> tmp = first;

                while(tmp.succ != null && tmp.element.equals(o))
                    tmp = tmp.succ;
                if(tmp.element.equals(o)){ //ako elementot e ist so node-ot koj sto sakame da go najdeme(o)
                    return tmp; // Go vraka prvoto pojavuvanje na elementot vo listata
                }
                else {
                    System.out.println("Elementot ne postoi vo listata");
                }
            }
            else {
                System.out.println("Listata e prazna ");
            }
            return null;
        }

        public void display(){ //printanje na listite
            SLLNode<E> tmp = first;
            while(tmp != null){
                System.out.println(tmp.element + " " );
                tmp = tmp.succ; //dvizi niz lista
            }
            System.out.println();
        }

        @Override
        public String toString() {
            String str = new String();

            if(first != null){
                SLLNode<E> tmp = first;

                str += tmp + "->";
                while(tmp.succ != null){
                    tmp = tmp.succ;
                    str += tmp + "->";
                }
            }
            else {
                str = "Prazna lista!!!";
            }
            return str;
        }


//        public static void main(String[] args) {
//
//            SLL<Integer> lista = new SLL<Integer>();
//            lista.insertLast(5);
//            System.out.print("Listata po vmetnuvanje na 5 kako posleden element: ");
//            System.out.println(lista.toString());
//
//            lista.insertFirst(3);
//            System.out.print("Listata po vmetnuvanje na 3 kako prv element: ");
//            System.out.println(lista.toString());
//
//            lista.insertLast(1);
//            System.out.print("Listata po vmetnuvanje na 1 kako posleden element: ");
//            System.out.println(lista.toString());
//
//            lista.insertLast(1);
//            System.out.print("Listata po vmetnuvanje na 1 kako posleden element: ");
//            System.out.println(lista.toString());
//
//            lista.deleteFirst();
//            System.out.print ("Listata po brishenje na prviot element: ");
//            System.out.println(lista.toString());
//
//            SLLNode<Integer> pom = lista.find(5);
//            lista.insertBefore( 2, pom);
//            System.out.print ("Listata po vmetnuvanje na elementot 2 pred elementot 5: ");
//            System.out.println(lista.toString());
//
//            pom = lista.find(1);
//            lista.insertAfter (3, pom);
//            System.out.print ("Listata po vmetnuvanje na elementot 3 posle elementot 1: ");
//            System.out.println(lista.toString());
//        }

    /*
    //insertAfter
    SLLNodee<E> pom = new SLLNodee<>(o,node.successorr); //2 argumenti - (E o, aud1NiziListi.SLLNode<E> node). Elementot o koj sto sakame da go store-neme(skladirame) vo noviot node  i successorot .Ova znaci deka noviot node pom ke ima element o i ke pokazuva kon node.successor zosto se VMETNUVA PRED NODE, A PRED SEKOJ NODE IMA SUCCESSOR

    //insertBefore
    SLLNodee<E> pom = new SLLNodee<>(o,node); //2 argumenti - (E o, aud1NiziListi.SLLNode<E> node). Elementot o koj sto sakame da go store-neme(skladirame) vo noviot node. this time you're setting the successor reference directly to the 'node' itself. This means that the new node 'pom' will have the element 'o' and will be connected immediately after the 'node' you provided. POKAZUVA KON NODE ZOSTO E INSERTBEFORE, A mora da ima node pred

    //insertLast
    SLLNodee<E> pom = new SLLNodee<>(o, null); //2 argumenti - (E o, aud1NiziListi.SLLNode<E> node). Elementot o koj sto sakame da go store-neme(skladirame) vo noviot node. Ja setirame referencata na null potocno pokazuva kon null zosto e posleden element(node)

    //insertFirst
    SLLNodee<E> pom = new SLLNodee<>(o,first); //2 argumenti - (E o, aud1NiziListi.SLLNode<E> node). Elementot o koj sto sakame da go store-neme(skladirame) vo noviot node. The second argument is 'first', which is a reference to the first node in the linked list. Poakzuvak on first zoso mora da stavi node pred prviot

*/

    }



