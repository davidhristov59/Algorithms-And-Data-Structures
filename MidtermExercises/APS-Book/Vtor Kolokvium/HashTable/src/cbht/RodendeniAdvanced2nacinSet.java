package cbht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public class RodendeniAdvanced2nacinSet {
    //ispitna
    //gi vraka iminjata
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        CBHT<String, Set<String>> birthdays = new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split("\\s+"); //gi delam spored . radi datumot bidejki ni treba mesecot

            String name = parts[0];
            String date = parts[1];

            String[] datum = date.split("\\.");
            String mesec = datum[1];

            if(birthdays.search(mesec) == null){
                Set<String> storedNames = new LinkedHashSet<>();
                storedNames.add(name);
                birthdays.insert(mesec, storedNames);
            }

            else {
                SLLNode<MapEntry<String, Set<String>>> node = birthdays.search(mesec);

                Set<String> storedNames = node.element.value;
                storedNames.add(name);

                birthdays.insert(mesec, storedNames);
            }
        }

        String month = bufferedReader.readLine();

        SLLNode<MapEntry<String, Set<String>>> node = birthdays.search(month);

        if(node != null){
            Set<String> nameSet = node.element.value;

            String[] sortedNames = nameSet.toArray(new String[0]);
            Arrays.sort(sortedNames);

            for(String name : nameSet){
                System.out.print(name + " ");
            }
        }
        else {
            System.out.println("Empty");
        }
    }
}
