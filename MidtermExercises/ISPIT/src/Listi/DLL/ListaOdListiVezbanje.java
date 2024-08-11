package Listi.DLL;

import java.util.Scanner;

public class ListaOdListiVezbanje {

    public static long findMagicNumber(DLL<DLL<Integer>> list) {

        DLLNode<DLL<Integer>> tmpList = list.getFirst();
        int proizvod = 1;
        int suma = 0;

        while(tmpList != null){

            DLLNode<Integer> curr = tmpList.element.getFirst(); //na taa vnatresna lista zemi go prviot element

            while(curr != null){

                suma += curr.element;
                curr = curr.succ;
            }

            proizvod *= suma;
            tmpList = tmpList.succ;
        }

        return proizvod;
    }

    public static long findMagicNumber2(DLL<DLL<Integer>> list) { //2 NACIN

        DLLNode<DLL<Integer>> tmp = list.getFirst();
        long suma = 0;
        long proizvod = 1;

        while(tmp != null){

            DLLNode<Integer> curr = tmp.element.getFirst();

            while(curr != null){

                suma += curr.element;
                curr = curr.succ;
            }

            proizvod *= suma;
            suma = 0;

            tmp = tmp.succ;
        }

        return proizvod;
    }

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));

    }
}
