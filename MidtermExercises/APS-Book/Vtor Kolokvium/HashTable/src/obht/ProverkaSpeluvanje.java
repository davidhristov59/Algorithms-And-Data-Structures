package obht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Zbor implements Comparable<Zbor>{
    String zbor;

    public Zbor(String zbor) {
        this.zbor = zbor;
    }

    @Override
    public boolean equals(Object obj) {
        Zbor pom = (Zbor) obj;
        return this.zbor.equals(pom.zbor);
    }

    @Override
    public int hashCode() {
        /*
         *
         * Vie ja kreirate hesh funkcijata
         *
         */

        return zbor.hashCode();

    }
    @Override
    public String toString() {
        return zbor;
    }
    @Override
    public int compareTo(Zbor arg0) {
        return zbor.compareTo(arg0.zbor);
    }
}

public class ProverkaSpeluvanje {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        OBHT<Zbor, String> tabela = new OBHT<Zbor, String>(2 * n);

        for (int i = 0; i < n; i++) {

            String word = bufferedReader.readLine().toLowerCase();

            Zbor zbor = new Zbor(word);

            tabela.insert(zbor, word);
        }

        String sentence = bufferedReader.readLine();
        String[] words = sentence.split("\\s+");

        boolean flag = true;

        for(String word : words){

           if(!Character.isLetter(word.charAt(word.length() - 1))){ //so znaci e interpunkciski i ne e bukva
               word = word.substring(0, word.length() - 1);
           }

           if(word.isEmpty())
               continue;

           if(Character.isUpperCase(word.charAt(0))){ //ako prvata bukva e golema
               word = word.toLowerCase(); //napravi gi drugite mali
           }

           Zbor zbor = new Zbor(word);

           if(tabela.search(zbor) == -1){
               System.out.println(word);
               flag = false;
           }
        }

        if(flag){
            System.out.println("Bravo");
        }
    }
}
