import java.util.Arrays;
import java.util.Scanner;

public class MiceHoles {

    public static int minTime(int[] mice, int[] holes){
        //sortirame bidejki treba da go spoime sekoj glusec so najbliskata dupka
        Arrays.sort(mice);
        Arrays.sort(holes);

        int minTime = 100000;

        for(int i=0;i<mice.length;i++){
            int time = Math.abs(mice[i] - holes[i]);
            minTime = Math.max(minTime,time);
        }
        return minTime;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        String parts[] = line.split(" ");
        int mice[] = new int[parts.length];
        for(int i=0;i<parts.length;i++) {
            mice[i] = Integer.parseInt(parts[i]);
        }

        line = input.nextLine();
        parts = line.split(" ");
        int holes[] = new int[parts.length];
        for(int i=0;i<parts.length;i++) {
            holes[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(minTime(mice, holes));
    }
}
