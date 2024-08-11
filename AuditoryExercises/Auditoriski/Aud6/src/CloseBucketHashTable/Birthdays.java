package CloseBucketHashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Birthdays {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        //                                      2*n moze
        CBHT<String,Integer> months = new CBHT<>(23); //BR NA KOFICKI - N (golemina) .Moze i prost broj da se zeme sto e duplo
        //vrednosta ke ni bide integer bidejki sakame da izbroime koklu elementi koi sto se vneseni bile rodeni vo toj mesec

        for (int i = 0; i < n; i++) {
            String birthDate = scanner.nextLine();
            String[] parts = birthDate.split("\\.");
//            int day = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
//            int year = Integer.parseInt(parts[2]);

            //dali e vmetnata vrednost za taa mesec . PR. Za 7 gledame prvo dali ja ima vo hash tabelata

            //ke probame da go najdeme
            //spored toa sto vraka metodot search --> SLLNode<MapEntry<String,Integer>>
            SLLNode<MapEntry<String,Integer>> tmp = months.search(parts[1]); //prebaruvame spored key. Searches for the month in the hash table

            //SLLNode<MapEntry<String,Integer>> tmp = months.search(String.valueOf(m)); //prebaruvame spored key. Searches for the month in the hash table

            if(tmp == null){ //nemalo vrednosti. Prv rodenden na toj mesec.
                months.insert(parts[1], 1); //insert za mesecot - parts[1] , a value e 1 sto znaci imame 1 rodenden
                // If the month isn't present, inserts it with a count of 1
            }
            else {
                //da ja zgolemime vrednosta
//                tmp.element.value += 1; //vrednosta da ja zgolemime za 1
                months.insert(parts[1], tmp.element.value+1); //if the month is present, increments it's count
            }

        }

//        System.out.println(months);

        String month = scanner.nextLine();

        SLLNode<MapEntry<String,Integer>> result = months.search(month); //tabelata ni e months

        if(result == null){ //nema za toj element vneseno rodendeni
            System.out.println("EMPTY"); //ako mesecot ne e najden , isprintaj empty
        }
        else { //brojot na rodendeni za mesecot
            System.out.println(result.element.value); //ja pecatime vrednosta
        }

    }
}

/*
input

4
20.7.1976
16.7.1988
18.7.1966
5.6.1988
7

result
3 - bidejki ima 3ca koi sto se rodeni vo toj mesec
 */