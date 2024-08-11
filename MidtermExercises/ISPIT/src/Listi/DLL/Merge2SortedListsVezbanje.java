package Listi.DLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Merge2SortedListsVezbanje {
//    public static DLL<Integer> opagackaLista(DLL<Integer> resultList) {
//
//        DLLNode<Integer> tmp = resultList.getFirst();
//        DLL<Integer> finalna = new DLL<>();
//
//        while(tmp != null){
//
//            finalna.insertLast(tmp.element);
//            tmp = tmp.succ;
//        }
//
//        return finalna;
//    }


        public static DLL<Integer> merge2ListsInSortedList(DLL<Integer> firstList, DLL<Integer> secondList){

        DLLNode<Integer> first = firstList.getFirst();
        DLLNode<Integer> last = secondList.getLast();
        DLL<Integer> resultList = new DLL<>();

        while(first != null && last != null){

            if(first.element < last.element){
                resultList.insertLast(first.element);
                first = first.succ;
            }
            else if(first.element > last.element){ //ili isto kako prviot if samo >0
                resultList.insertLast(last.element);
                last = last.pred;
            }
            else { //ako se ednakvi
                resultList.insertLast(first.element);
                resultList.insertLast(last.element);

                first = first.succ;
                last = last.pred;
            }
        }

        while(first != null){
            resultList.insertLast(first.element);
            first = first.succ;
        }

        while (last != null) {
            resultList.insertLast(last.element);
            last = last.pred;
        }

        return resultList;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] parts = new String[0];
        try {
            parts = br.readLine().split("\\s+");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int M = Integer.parseInt(parts[0]);
        int N = Integer.parseInt(parts[1]);

        DLL<Integer> firstList = new DLL<>();
        try {
            parts = br.readLine().split("\\s+");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < M; i++) {
            firstList.insertLast(Integer.parseInt(parts[i]));
        }

        DLL<Integer> secondList = new DLL<>();
        try {
            parts = br.readLine().split("\\s+");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < N; i++) {
            secondList.insertLast(Integer.parseInt(parts[i]));
        }

        DLL<Integer> resultList = merge2ListsInSortedList(firstList, secondList);
        System.out.println(resultList);

//        resultList = opagackaLista(resultList);
        System.out.println(resultList);
    }
}
