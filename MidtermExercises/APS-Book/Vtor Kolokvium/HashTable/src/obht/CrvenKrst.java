package obht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

//ne izleguva kaj printot nesto
public class CrvenKrst {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        OBHT<String, Integer> table = new OBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split("\\s+");

            String donator = parts[0];
            String blood_type = parts[1];

            Integer count = table.search(blood_type);
            //tuka search vraka int
            if(count == -1){
                table.insert(blood_type, 1);
            }
            else {
//                table.insert(blood_type, count+1); //inkrementiraj go brojacot
                table.insert(blood_type, table.getBucket(count).value+1);
            }
        }

        //print the results
//        System.out.println(table);
        for (int i = 0; i < table.buckets.length; i++) {
            if(table.buckets[i] != null){
                MapEntry<String, Integer> entry = table.buckets[i];
                System.out.println(entry.key + "=" + entry.value);
            }
        }

    }
}
