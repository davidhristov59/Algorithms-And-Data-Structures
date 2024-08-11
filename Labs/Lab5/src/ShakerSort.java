import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShakerSort {

    private static void swap(int[] a, int i, int j){

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    static void shakerSort(int[] a, int n)
    {

        boolean swapped = true;

        while(swapped){

            swapped = false;

            //pocnuva od pozadi
            for (int i = n-1; i > 0 ; i--){

                if(a[i] < a[i-1]){
                    swap(a,i,i-1);
                    swapped = true;
                }
            }

            for(int j:a){
                System.out.print(j + " ");
            }
            System.out.println();

            for(int i=1;i < n-1;i++){
                if(a[i] > a[i+1]){
                    swap(a,i,i+1);
                    swapped=true;
                }
            }

            for(int j:a){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        shakerSort(a,n);
    }
}