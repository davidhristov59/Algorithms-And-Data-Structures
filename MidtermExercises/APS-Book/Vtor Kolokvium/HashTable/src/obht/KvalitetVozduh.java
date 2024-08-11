package obht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KvalitetVozduh {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        OBHT<String, List<Double>> table = new OBHT<>(2 * n);

        for (int i = 0; i < n; i++) {

            String line = bufferedReader.readLine();
            String[] parts = line.split("\\s+");
            String naselba = parts[0];
            Double cesticki = Double.parseDouble(parts[1]);

            List<Double> list = new ArrayList<>();

            if(table.search(naselba) == -1){
                list.add(cesticki);
                table.insert(naselba, list);
            }
            else {
                Integer count = table.search(naselba);
                list = table.getBucket(count).value;
                list.add(cesticki);
                table.insert(naselba, list);
            }
        }

        String naselba = bufferedReader.readLine();


        List<Double> result = table.getBucket(table.search(naselba)).value;

        if(result.size() > 0) {
            float sum = 0;
            for (int i = 0; i < result.size(); i++) {
                sum += result.get(i);
            }

            float average = sum / result.size();

            System.out.printf("%.2f", average);
        }
        else {
            System.out.println("No info");
        }

    }
}

