package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class LDSVezbanje { //longest descending substring

    private static int najgolgaRasteckaSekvenca(int [] arr){

        int[] lds = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
                lds[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && lds[i] < lds[j] + 1){
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for(int element : lds){
            result = Math.max(result, element);
        }
        return result;

    }
    private static int najdolgaOpagackaSekvenca(int[] arr) {

        // Vasiot kod tuka

        int[] lds = new int[arr.length]; //This array will be used to store the length of the longest decreasing subsequence ending at each index.

        //1 nacin
        for (int i = 0; i < arr.length; i++) {
            lds[i] = 1; //na pocetok gi popolnuvam so 1
        }

        //2 nacin
//        Arrays.fill(lds, 1); //napuni so 1
        
        //prebaruvanje na najdolgata opagacka sekvenca
        //{10, 5, 4, 3, 2, 8, 7} е {10, 8, 7}
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] < arr[j] && lds[i] < lds[j] + 1){
                    lds[i] = lds[j] + 1;
                }
            }
        }

        //baranje na max opagacka sekvenca

//        int maxLengthIndex = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if(lds[i] > lds[maxLengthIndex]){
//                maxLengthIndex = i;
//            }
//        }

        int result = Integer.MIN_VALUE;
        for(int element : lds){
            result = Math.max(result, element);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}
