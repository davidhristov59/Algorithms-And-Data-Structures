package DeleteMthElement;

//Дадена е еднострано поврана листа чии што јазли содржат по еден природен бро. Дополнително, даден е и уште еден природен бро М (М> 1). Треба од дадената листа да се избрише секо м-ти елемент.
//Влез; Во првиот ред од влезот е даден бродот на елементи во листата, па во следниот ред се дадени самите елементи од листата. На кра, во последниот ред е даден бродот м.
//излез: на излез треба да се испечати променетата листа, со изоришан секо м-ти елемент.
//Внимавате:
//1. Даден е целосниот код на структурата козашто треба да се користи. Дадена е и тест класата SpecialSLLDelete. java, со целосно имплементиран input и output. Потребно е да се менува
//само во рамки на void specialDelete(DeleteMthElement.SLL «Integer> list, int m) функциата.

//public class DeleteSLLElement {
//
//    public void specialDelete(SLL<Integer> list, int m) {
//
//        if (list == null || m < 1) {
//            return;
//        }
//
//        SLLNode<Integer> current = list.getFirst(); //zemi go prviot element od listata
//        SLLNode<Integer> previous = null;
//
//        int count = 1; //ni treba za da vodi smetka(keep track) za pozicijata na current element vo listata i deka vo listata pocnuvame od 1 da broime,ne od 0 kako kaj nizite
//
//        while (current != null) {
//
//            if(count % m == 0){ //go barame m-tiot element vo listata za da go izbriseme
//
//                //ako m e 2 , sakame da go izbriseme sekoj 2 element vo listata
//
//                /*
//                m=2
//                    When count is 1, count % m is 1 % 2, which equals 1 (not equal to 0). This means the element at position 1 should not be deleted.
//                    When count is 2, count % m is 2 % 2, which equals 0 (equal to 0). This means the element at position 2 should be deleted.
//                    When count is 3, count % m is 3 % 2, which equals 1 (not equal to 0). This means the element at position 3 should not be deleted. itn...
//
//                    Suppose you have a linked list with the following elements: [A, B, C, D, E, F, G, H, I, J], and you set m to 3.
//                    When m is 3, it means you want to delete every 3rd element in the list. So, you want to delete elements at positions 3, 6, and 9.
//                    The result is a linked list with the elements [A, B, D, E, G, H, J], where every 3rd element has been deleted based on the value of m
//
//                 */
//
//                if(previous == null){  //ako e previous e null znaci deka current element e prviot element vo listata
//                    list.setFirst(current.succ); //togas succ na current ke bide prv. So ova go briseme prviot element vo listata
//                }
//                else { //ako previous ne e null togas current element ne e prviot element
//                    previous.succ = current.succ; //sme go nasle elementot za brisenj i current jazolot go brise od listata
//                }
//            }
//
//            else { //ako if-ot e false znaci deka current element ne e na dadenata pozicija za das e izbrise --> ne e na m mesto. Ovie elementi ke se preskoknat
//                previous = current; //pokazuvacot na previous ke pokazuva na current
//            }
//            current = current.succ; //dvizi niz listata
//            count++;
//        }
//    }
//
//}


import java.util.Scanner;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int size() {
        int listSize = 0;
        SLLNode<E> tmp = first;
        while(tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += " " + tmp;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, null);
        ins.succ = first;
        //SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }
    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before && tmp.succ!=null)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                tmp.succ = new SLLNode<E>(o, before);;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new SLLNode<E>(o, null);
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if(first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void merge (SLL<E> in){
        if (first != null) {
            SLLNode<E> tmp = first;
            while(tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        }
        else{
            first = in.getFirst();
        }
    }

    public void mirror() {
        if (first != null) {
            //m=nextsucc, p=tmp,q=next
            SLLNode<E> tmp = first;
            SLLNode<E> newsucc = null;
            SLLNode<E> next;

            while(tmp != null){
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }
    }
}

public class SpecialSLLDelete<E> {

    //TODO: implement method
    public void specialDelete(SLL<E> list, int m) {

        SLLNode<E> tmp = list.getFirst();
        SLLNode<E> previous = null;

        int counter = 1; //pocnuvame od 1 bidejki vo lista nemame indexi i ne pocnuvame od 0 tuku od 1
        while (tmp != null) {

            if (counter % m == 0) {

                previous.succ = tmp.succ; //succ na previous da pokazuva direktno kon succ na tmp jazolot. Ova go pominuva tmp jazolot bodejki tmp sakame da go izbriseme

                /*
                When you want to remove a node from the list, you need to adjust the succ reference of the previous
                node to bypass the node to be removed and point directly to the next node. This is what the line
                previous.succ = tmp.succ; accomplishes.
                 */
            } else { //ako elementot ne e na dadenata pozicija za brisenje odi na sledniot element
                previous = tmp;
            }

            tmp = tmp.succ; //dvizime niz listata, shiftame
            counter++; //gi broi pojavunjata na m-tiot element
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        SLL<Integer> list = new SLL<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        int m = input.nextInt();

        SpecialSLLDelete<Integer> tmp = new SpecialSLLDelete<>();

        tmp.specialDelete(list, m);

        System.out.println(list);
    }

}