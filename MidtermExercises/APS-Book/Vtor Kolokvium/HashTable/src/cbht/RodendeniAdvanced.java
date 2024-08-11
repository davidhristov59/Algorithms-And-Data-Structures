package cbht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class RodendeniAdvanced {
    //ispitna
    //gi vraka iminjata
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        CBHT<String, String> birthdays = new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split("\\s+"); //gi delam spored . radi datumot bidejki ni treba mesecot

            String name = parts[0];
            String date = parts[1];

            String[] datum = date.split("\\.");
            String mesec = datum[1];

            if(birthdays.search(mesec) == null){
                birthdays.insert(mesec, name);
            }

            else {
                SLLNode<MapEntry<String, String>> node = birthdays.search(mesec);
                String storedNames = node.element.value; //mora vo String da zacuvame

                if (!storedNames.contains(name)) {
                    storedNames += " " + name;
                    birthdays.insert(mesec, storedNames);

//                    birthdays.insert(mesec, storedNames + " " + name); // Concatenating names for the same month
                }
            }
        }

        String month = bufferedReader.readLine();

        SLLNode<MapEntry<String, String>> node = birthdays.search(month);

        if(node != null){
            System.out.println(node.element.value); //Print all names for the given month
        }
        else {
            System.out.println("Empty");
        }
    }
}
