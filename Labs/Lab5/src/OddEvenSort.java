import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {

    public static void ascendingOrder(int [] a, int n){

        int temp = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(a[i] > a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void descendingOrder(int[] a, int n){

        int temp = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(a[i] < a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    static void oddEvenSort(int a[], int n) {
        int [] neparni = new int[n];
        int [] parni = new int[n];
        int parni_counter = 0, neparni_counter = 0;
        for (int i = 0; i < n; i++) {
            if (a[i]%2==0){
                parni[parni_counter++] = a[i];
            }
            else{
                neparni[neparni_counter++] = a[i];
            }
        }

        ascendingOrder(neparni, neparni_counter);
        descendingOrder(parni, parni_counter);

        for (int i = 0; i < neparni_counter; i++) {
            a[i] = neparni[i];
//            System.out.println(neparni[i]);
        }

        int index=0;
        for(int i=neparni_counter;i<n;i++){
            a[i] = parni[index++];
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
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}