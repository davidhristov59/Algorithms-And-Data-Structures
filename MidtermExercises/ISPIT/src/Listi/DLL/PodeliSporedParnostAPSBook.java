package Listi.DLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PodeliSporedParnostAPSBook {

    public static void podeliParnost(DLL<Integer> lista, DLL<Integer> parni, DLL<Integer> neparni) {

        DLLNode<Integer> tmp = lista.getFirst();
        DLLNode<Integer> last = lista.getLast();

        while (tmp != null) {

            if (tmp.element % 2 == 0) {
                parni.insertLast(tmp.element);
            } else {
                neparni.insertLast(tmp.element);
            }

            if (last.element % 2 == 0) {
                parni.insertLast(last.element);
            } else {
                neparni.insertLast(last.element);
            }

            tmp = tmp.succ;
            last = last.pred;
        }

        if (tmp == last) {
            if (tmp.element % 2 == 0) {
                parni.insertLast(tmp.element);
            }
            else
                neparni.insertLast(tmp.element);
        }
    }


    public static void main(String[] args) {
        DLL<Integer> lista = new DLL<Integer>(), parni = new DLL<Integer>(),
                neparni = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = null;
        try {
            s = stdin.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int N = Integer.parseInt(s);
        try {
            s = stdin.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] pomniza = s.split(" ");
        for(int i=0;i<N;i++){
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }

        podeliParnost(lista, parni, neparni);
        // Pecatenje parni
        DLLNode<Integer> tmp = parni.getFirst();
        while (tmp != null) {
            System.out.print(tmp.element);
            if (tmp.succ != null)
                System.out.print(" ");
            tmp = tmp.succ;
        }
        System.out.println();
        // Pecatenje neparni
        tmp = neparni.getFirst();
        while (tmp != null) {
            System.out.print(tmp.element);
            if (tmp.succ != null)
                System.out.print(" ");
            tmp = tmp.succ;
        }
        System.out.println();
    }
}
