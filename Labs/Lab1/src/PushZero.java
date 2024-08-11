//За дадена низа од случајни броеви кои се внесуваат од стандарден влез, да се направи преместување на сите нули на почеток на низата. На стандарден излез да се испечати трансформираната низа.

import java.util.Scanner;

public class PushZero {

    static void pushZerosToBeginning(int arr[], int n)
    {

        int counter = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0){ //gi broi nulite prvo
                counter++;
            }
        }

        int nonZeroIndex = n-1; //inicijalizira posleden index vo nizata
        for (int i = n-1; i >= 0; i--) { //naopaku e nizata, pocnuva od kraj pa odi do prviot element
            if(arr[i] != 0){ //ako segasniot element ne e 0
                arr[nonZeroIndex] = arr[i]; //pomesti go toj element sto ne e 0 na indeksot nonZeroIndex (potocno na kraj od nizata)
                nonZeroIndex--; //shiftaj gi elementite koi ne se 0 na kraj od nizata
            }
        }

        for (int i = 0; i < counter; i++) { //odi do brojacot na nuli koi se pojavile i site gi pravi 0
             arr[i] = 0;  //so ova pravime site 0 da se na pocetokot na nizata
        }


    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] array = new int[n]; //array inicijalizirana so golemina n

        for (int i = 0; i < n; i++) { //ovoj ciklus za da gi cita broevite vo nizata
            array[i] = scanner.nextInt();
        }

        pushZerosToBeginning(array,n);

        System.out.println("Transformiranata niza e:");
        for (int num : array) { //gi printa elementite vo nizata kade sto site nuli se napred
            System.out.print(num + " "); //print koristi za vo eden red da gi isprinta
        }
    }
}
