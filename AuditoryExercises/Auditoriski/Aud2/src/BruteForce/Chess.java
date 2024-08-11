package BruteForce;

import java.util.Scanner;

public class Chess {
    //sahovska tabla e 8x8
    //Queen1 [i1,j1],  Queen2[i2,j2]


    public static boolean can_attack(int r1, int r2, int k1, int k2){
        //                                      vo ista dijagonala se
        //                                 kalkulira absolutnata razlika da se vo ista redica i vo ista kolona
        return (r1 == r2) || (k1 == k2) || (Math.abs(r1-r2) == Math.abs(k1-k2));

    }

    public static int chessAttack(int n ){ //vkupniot broj na nacini koga 2 kralici se napagaat

        int count=0;
        for (int redica = 0; redica < n; redica++) {
            for (int kolona = 0; kolona < n; kolona++) {
                for (int redica2 = 0; redica2 < n; redica2++) {
                    for (int kolona2 = 0; kolona2 < n; kolona2++) {
                        if(!can_attack(redica,redica2,kolona,kolona2)){ //BEZ DA SE NAPAGAAT EDNA SO DRUGA KRALICA
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vnesi ja goleminata na sahovskata tabla");
        int n = scanner.nextInt();

        int res = chessAttack(n);
        System.out.println("Brojot na nacini za postavuvanje e: " + res);
    }
}
