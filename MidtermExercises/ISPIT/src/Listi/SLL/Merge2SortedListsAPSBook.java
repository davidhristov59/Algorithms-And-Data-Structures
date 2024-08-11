package Listi.SLL;

public class Merge2SortedListsAPSBook<E extends Comparable<E>> {

    public SLL<E> join2Lists(SLL<E> list1, SLL<E> list2){

        SLLNode<E> tmpFirst = list1.getFirst();
        SLLNode<E> tmpSecond = list2.getFirst();
        SLL<E> resultList = new SLL<>();

        while(tmpFirst != null && tmpSecond != null){

            if(tmpFirst.element.compareTo(tmpSecond.element) < 0){ //jazol1 < jazol2 - znaci e vo rastecka

                resultList.insertLast(tmpFirst.element);
                tmpFirst = tmpFirst.succ;
            }
            else { //ako ne se sortirani, ne e vo rastecka

                resultList.insertLast(tmpSecond.element);
                tmpSecond = tmpSecond.succ;
            }
        }

        while(tmpFirst != null){

            resultList.insertLast(tmpFirst.element);
            tmpFirst = tmpFirst.succ;
        }

        while(tmpSecond != null){

            resultList.insertLast(tmpSecond.element);
            tmpSecond = tmpSecond.succ;
        }

        return  resultList;
    }

    public static void main(String[] args) {
        SLL<String> lista1 = new SLL<String>();
        lista1.insertLast("Ana");
        lista1.insertLast("Bojana");
        lista1.insertLast("Dejan");

        SLL<String> lista2 = new SLL<String>();
        lista2.insertLast("Andrijana");
        lista2.insertLast("Biljana");
        lista2.insertLast("Darko");

        Merge2SortedListsAPSBook<String> js = new Merge2SortedListsAPSBook<>();
        System.out.println(js.join2Lists(lista1,lista2));
    }
}
