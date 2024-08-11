package cbht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Anagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        CBHT<String,Integer> words = new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();

            //1 NACIN
//            char[] letters = line.toCharArray();
//            Arrays.sort(letters);
//            String sortedLetters = new String(letters); //sortiranite zborovi stavi gi vo string

            //2 NACIN
            String sortedLetters = line.chars()
                                    .sorted()
                                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                    .toString();


            if(words.search(sortedLetters) == null){
                //ni treba counter vo slucajot, ke izbroime i ke go insertneme vo tabelata
                words.insert(sortedLetters,1);
            }
            else {
                SLLNode<MapEntry<String, Integer>> node = words.search(sortedLetters);
                words.insert(sortedLetters, node.element.value+1); //counter-ot zgolemi go
                //prvo najdi vo tabelata od sortiranite bukvi potoa insert napravi na tie sortirani bukvi so toa zborce sortirano i zgolemi go counterot
            }
        }
        String input = bufferedReader.readLine();
        SLLNode<MapEntry<String, Integer>> result = words.search(input);

        if(result != null){
            System.out.println(result.element.value);
        }
        else {
            System.out.println("EMPTY");
        }
    }
}
