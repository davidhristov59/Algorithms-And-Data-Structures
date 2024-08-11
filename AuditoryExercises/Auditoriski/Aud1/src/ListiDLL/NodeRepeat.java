package ListiDLL;

/*
Да се напише програма за произволна двојно поврзана листа во која ќе се исфрлат сите јазли што се повторуваат.
Дополнително секој јазол на оваа листа покрај објектот, содржи и дополнителна информација: бројот на повторувања на
 дадениот јазел.
 */

public class NodeRepeat<E> {
    protected E element;
    protected DLLNode<E> pred, succ;
    protected int num_appearances;

    public NodeRepeat(){}

    public NodeRepeat(E element, DLLNode<E> pred, DLLNode<E> succ){
        this.element=element;
        this.pred = pred;
        this.succ = succ;
        this.num_appearances = 1;
    }

    @Override
    public String toString() {
        return "<-" + element.toString() + "->";
    }

    public void removeDuplicates(DLL<E> list){
        DLLNode<E> tmp = list.getFirst();

        while(tmp != null){
            DLLNode<E> tmp2 = tmp.succ;
            while(tmp2 != null){
                if(tmp.element.equals(tmp2.element)){ //ako jazlite se isti, ptoocno se povtoruvaat
//                    System.out.println("Before deletion, num appearences: " + tmp.num_appearances);
                    list.delete(tmp2); //izbrisi gi ako ima isti elementi
//                    System.out.println("After deletion, num_appearances: " + tmp.num_appearances);
                    tmp.num_appearances++;//izbroj go brojot na povtoruvanja na jazolot
                }
                tmp2 = tmp2.succ; // The inner loop continues by moving tmp2 to the next node in the linked list to check for more duplicates.
            }
         tmp = tmp.succ;  //After the inner loop completes, the outer loop continues by moving tmp to the next node in the linked list using tmp = tmp.succ;.
        }
    }


    public static void main(String[] args) {
        DLL<Integer> lista = new DLL<>();

        NodeRepeat<Integer> nodeRepeat = new NodeRepeat<>();

        lista.insertLast(4);
        lista.insertLast(9);
        lista.insertLast(4);
        lista.insertLast(4);
        lista.insertLast(5);
        lista.insertLast(8);
        lista.insertLast(9);

        System.out.println("Listata pred otstranuvanje i prebrojuvanje na duplite elementi: ");
        System.out.println(lista.toString());

        nodeRepeat.removeDuplicates(lista);

        System.out.println("Listata posle otstranuvanje i prebrojuvanje na duplite elementite ");
        System.out.println(lista.toString());
    }

}




