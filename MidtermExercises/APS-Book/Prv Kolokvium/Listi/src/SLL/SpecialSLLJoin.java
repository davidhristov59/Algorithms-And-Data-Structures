package SLL;

import java.util.*;

public class SpecialSLLJoin<E extends Comparable<E>> {

    //join 2 sorted lists into one sorted
    public SLL<E> joinSortedList(SLL<E> list1, SLL<E> list2){

        SLLNode<E> tmpFirst = list1.getFirst();
        SLLNode<E> tmpSecond = list2.getFirst();
        SLL<E> resultList = new SLL<E>();

        while(tmpFirst.succ != null && tmpSecond.succ != null){

            resultList.insertLast(tmpFirst.element);
            resultList.insertLast(tmpFirst.succ.element);

            resultList.insertLast(tmpSecond.getElement());
            resultList.insertLast(tmpSecond.succ.element);

            tmpFirst = tmpFirst.succ;
            tmpSecond = tmpSecond.succ;

            if(tmpFirst == null || tmpSecond == null){
                break;
            }

            if(tmpFirst != null){
                while(tmpFirst.succ != null){
                    resultList.insertLast(tmpFirst.element);
                    tmpFirst = tmpFirst.succ;
                }
            }
            if(tmpSecond != null){
                resultList.insertLast(tmpSecond.element);
                tmpSecond = tmpSecond.succ;
            }
        }

        return resultList;
    }


    //Sort the 2 lists and merge it into a third sorted merged list
    public SLL<E> mergeAndSort(SLL<E> list1, SLL<E> list2){

        SLLNode<E> firstList = list1.getFirst();
        SLLNode<E> secondList = list2.getFirst();
//        SLL<E> mergedList = new SLL<E>();
        List<E> mergedList = new ArrayList<>();  //poradi Collections.sort

        while(firstList.succ != null && secondList.succ != null){

            //cim imame List, koristime compareTo
            if(firstList.element.compareTo(secondList.element) <= 0){
                mergedList.add(firstList.element);
                firstList = firstList.succ;
            }

            else {
                mergedList.add(secondList.element);
                secondList = secondList.succ;
            }
        }

        while(firstList != null){ //posebno gi izminuvame, samo prvata lista
            mergedList.add(firstList.element);
            firstList = firstList.succ;
        }

        while(secondList != null){
            mergedList.add(secondList.element);
            secondList = secondList.succ;
        }

        Collections.sort(mergedList); //tuka List prima zatoa cuvame vo List, NE VO SLL

        //otkako ke gi sortirame elementite gi vrakame pak vo SLL
        SLL<E> result  = new SLL<E>();

        for(E element : mergedList){
            result.insertLast(element);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        SLL<Integer> integerSLL = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            integerSLL.insertLast(scanner.nextInt()); //vnesuvaj vnatre vo listata
        }

        n = scanner.nextInt(); //vnes za 2rata lista
        SLL<Integer> integerSLL2 = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            integerSLL2.insertLast(scanner.nextInt());
        }

        SpecialSLLJoin<Integer> specialSLLJoin = new SpecialSLLJoin<Integer>();

//        System.out.println(specialSLLJoin.joinSortedList(integerSLL,integerSLL2));

        System.out.println(specialSLLJoin.mergeAndSort(integerSLL,integerSLL2));

    }
}
