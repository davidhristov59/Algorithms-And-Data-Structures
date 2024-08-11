package GreedyAlgorithm;

import java.util.Scanner;

public class FractionalKnapsack {

    //greedy algorithm
    public static double maxProfit(int[] profit, int[] weight, int capacity){

        for (int i = 0; i < profit.length; i++) {
            for (int j = i+1; j < weight.length; j++) {

                //presmetuvam soodnos profit/tezina
                double p1 = (double) profit[i] / weight[i];
                double p2 = (double)  profit[j] / weight[j];

                if(p1 < p2){
                    int tmpProfit = profit[i];
                    int tmpWeight = weight[i];
                    
                    profit[i] = profit[j];
                    weight[i] = weight[j];
                    
                    profit[j] = tmpProfit;
                    weight[j] = tmpWeight;
                }
            }
        }

        double p = 0;
        for (int i = 0; i < profit.length ; i++) { //dali ima dovolno preostanato kapacitet od toj to ni e daden na pocetok za da go smestime noviot predmet
            if(capacity - weight[i] >= 0){ //ako ima dovolno mesto vo ranecot
                p += profit[i]; //dodadi profitot
                capacity -= weight[i]; // od kapacitetot odzemi ja tezinata
            }
            else {
                p += ((double) capacity / weight[i]) * profit[i]; //delime bidejki zimame tolkav del od predmetot
                break;
            }
        }
            return p;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        int n = scanner.nextInt();

        int[] profit = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) { //za sekoj predmet citame profit pa tezina
            profit[i] = scanner.nextInt();
            weight[i] = scanner.nextInt();
        }

        System.out.println(maxProfit(profit,weight,capacity));
    }
}
