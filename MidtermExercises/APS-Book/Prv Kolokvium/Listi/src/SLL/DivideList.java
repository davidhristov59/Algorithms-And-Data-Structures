package SLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideList {
    //Раздели Листа
    /*
    Дадена е еднострано поврзана листа со природни броеви. Да се креираат две резултантни еднострано поврзани листи т.ш. во првата листа к ́е се земаат само jазлите што содржат парни броj, при што доколку во првичната листа има повек ́е соседни jазли со парни броеви се зема само последниот jазел. Слична процедура се применува и за втората резултантна листа, при што овде се земаат само jазлите што содржат непарни броеви, при што ако има повек ́е соседни jазли со непарни броеви се зема само последниот jазел.
Влез: Во првата линиjа е даден броjот на елементи n. Во втората линиjа се даваат броевите во листата одделени со празно место.
Излез: Прво се печати резултантната листа со прости броеви, а потоа во нов ред таа со непрости. Доколку некоjа од листите е празна се печати: Prazna lista.
Пример. Влез:
8 13245768 Излез:
4->8
3->7
     */
    

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bufferedReader.readLine());

        String line = bufferedReader.readLine();

        SLL<Integer> list = new SLL<Integer>();
        SLL<Integer> parni = new SLL<Integer>();
        SLL<Integer> neparni = new SLL<Integer>();

        SLLNode<Integer> tmp = list.getFirst();

        while(tmp != null){
           
        }
    }

}
