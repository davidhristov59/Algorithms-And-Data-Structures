import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {

        int count = 1;
        int max = 0;

        for (int i = 0; i < a.length-1; i++) { //do -1 poradi a[i+1] uslovot
            if(a[i] == 0){
                count = 1;
            }
            else {
                if((a[i] > 0 && a[i+1] < 0) || (a[i] < 0 && a[i+1] > 0)){
                    count++;
                }
                else {
                    count=1;
                }
            }
            if(count > max){ //najdolgata podniza
                max = count;
            }
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}
