package obht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class UpisFakultet {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        OBHT<String, Double> tabela = new OBHT<String, Double>(2 * n);

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split("\\s+");

            String maticenBroj = parts[0];
            Double prosek = Double.parseDouble(parts[1]);

            tabela.insert(maticenBroj, prosek);
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        OBHT<String, Double> ednevnik = new OBHT<>(2 * m);

        for (int i = 0; i < m; i++) {
            String line = bufferedReader.readLine();
            String[] parts= line.split("\\s+");

            String maticenBroj = parts[0];
            Double vistinskiProsek = Double.parseDouble(parts[1]);

            ednevnik.insert(maticenBroj, vistinskiProsek);
        }

        String maticenBroj = bufferedReader.readLine();

        if(tabela.search(maticenBroj) != -1){
            if (ednevnik.search(maticenBroj) != -1){
                //дали кандидатот со дадениот матичен броj го внел точниот просек од средно образование
                if(tabela.getBucket(tabela.search(maticenBroj)).value.equals(ednevnik.getBucket(ednevnik.search(maticenBroj)).value)){
                    System.out.println("OK");
                }
                else {
                    System.out.println("Error");
                }
            }
            else {
                System.out.println("Empty");
            }
        }
        else {
            System.out.println("Empty");
        }

    }
}
