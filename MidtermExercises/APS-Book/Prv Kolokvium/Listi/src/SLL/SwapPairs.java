package SLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Замени соседи
/*
Дадена е еднострано поврзана листа чии што jазли содржат по еден природен броj. Да се трансформира листата така што секоj соседен пар jазли к ́е си ги заменат местата (првиот со вториот, па третиот со четвртиот итн...).
Влез: Во првата линиjа е даден броjот на елементи n. Во следните n линии се дадени елементите на листата.
Излез: На излез треба да се испечатат jазлите на резултантната листа.
Пример. Влез:
4
1
2
3
4
Излез: 2->1->4->3

 */
public class SwapPairs {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(Integer.parseInt(bufferedReader.readLine()));
        }

        //Resenie
        SLLNode<Integer> tmp = list.getFirst();

        while(tmp != null && tmp.succ != null) {

            Integer pom = tmp.element; //mora da zemam Integer bidejki cuvam Integeri vo SLLNode, ne int
            tmp.element = tmp.succ.element; //segasniot element ke go zameni so sledniot element . pr --> prviot element ke go zameni sos vtoriot element i taka natamu
            tmp.succ.element = pom;

            tmp = tmp.succ.succ; //dvizi succ za 2 pozicii napred vo listata , pominuvajki go sledniot node bidejki e vise swapnat
        }

    }
}
