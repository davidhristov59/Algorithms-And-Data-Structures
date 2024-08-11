package ListiSLL;

/*
Нека се дадени две еднострано поврзани листи чии јазли се сортирани во растечки редослед.
Да се напише функција која ќе ги спои двете листи во една така што резултантната листа да е
сортирана. Сортирањето е подредување со слевање.
 */
public class JoinSortedLists<E extends Comparable<E>> {

    public SLL<E> joinSortedLists(SLL<E> list1, SLL<E> list2){

        SLL<E> resultList = new SLL<>();

        SLLNode<E> tmpFirst = resultList.getFirst(); //zemi go prviot node vo prvata lista
        SLLNode<E> tmpSecond = resultList.getFirst(); //zemi go vtoriot node vo vtorata lista

        while(tmpFirst != null && tmpFirst != null){ //iteriram niz 2te listi. Se dur ima elementi vo listata pravi ja sporedbata

            if(tmpFirst.element.compareTo(tmpSecond.element) <= 0){
                //tmpFirst<tmpSecond. tmpFirst e pomal zosto e vo levo do compare.to

                resultList.insertLast(tmpFirst.element); //dodavame jazol
                tmpFirst = tmpFirst.succ; //povrzuvame jazlite - DVIZIME
            }
            else {
                resultList.insertLast(tmpSecond.element);
                tmpSecond = tmpSecond.succ;
            }
        }

        while(tmpFirst != null){ //Posebno za prvata lista
            resultList.insertLast(tmpFirst.element);
            tmpFirst = tmpFirst.succ;
        }

        while(tmpSecond != null){ //Posebno za vtorata lista
            resultList.insertLast(tmpSecond.element);
            tmpSecond = tmpSecond.succ;
        }

        return resultList;
    }

    public static void main(String[] args) {

        SLL<Integer> lista1 = new SLL<Integer>();
        lista1.insertLast(1);
        lista1.insertLast(3);
        lista1.insertLast(5);

        SLL<Integer> lista2 = new SLL<Integer>();
        lista2.insertLast(2);
        lista2.insertLast(4);
        lista2.insertLast(6);

        JoinSortedLists<Integer> js = new JoinSortedLists<Integer>();

        System.out.println("First List");
        lista1.display();

        System.out.println("Second List");
        lista2.display();

        SLL<Integer> sortedList = js.joinSortedLists(lista1,lista2);

        System.out.println("Sorted List: ");
        sortedList.display();

    }

}
