package cbht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Epidemija {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        CBHT<String, Integer> positivepatients = new CBHT<>(2 * n);
        CBHT<String, Integer> negativepatients = new CBHT<>(2 * n);

        //Treba posebno so pozitivni pacienti, posebno so negativni pacienti da izbroime kolku ima
        //2 counters - 1 positive, 1 negative

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();

            String[] parts = line.split("\\s+");
            String opstina = parts[0];
            String prezime = parts[1];
            String rezultatiTest = parts[2];

            if(rezultatiTest.equals("positive")) {

                //barame spored opstina
                SLLNode<MapEntry<String, Integer>> positive = positivepatients.search(opstina);

                if(positive == null){
                    positivepatients.insert(opstina,1);
                }
                else {
                    Integer positiveCounter = positive.element.value;
                    positivepatients.insert(opstina,positiveCounter+1);
                }
            }
            else {
                SLLNode<MapEntry<String, Integer>> negative = negativepatients.search(opstina); //negative

                if(negative == null){
                    negativepatients.insert(opstina, 1);
                }
                else {
                    Integer negativeCounter = negative.element.value;
                    negativepatients.insert(opstina, negativeCounter+1);
                }
            }
        }

        String opstina = bufferedReader.readLine();

        //vo 2TE HASH TABELI BARAM I VO POZ I VO NEG
        SLLNode<MapEntry<String, Integer>> pos = positivepatients.search(opstina);
        SLLNode<MapEntry<String, Integer>> neg = negativepatients.search(opstina);

        if(pos != null && neg != null){
            Integer positiveCount =  pos.element.value;
            Integer negativeCount =  neg.element.value;

            double formula = (double) positiveCount / (double) (negativeCount + positiveCount);

            System.out.println(String.format("%.2f", formula));
        }



    }
}
