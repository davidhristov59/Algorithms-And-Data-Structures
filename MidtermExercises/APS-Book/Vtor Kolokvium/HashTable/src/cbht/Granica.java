package cbht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Granica {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        CBHT<String, Integer> persons = new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {

            String line = bufferedReader.readLine();
            String [] parts = line.split("\\s+");

            String passportID = parts[0];
            String person = parts[1];

            if(persons.search(passportID) == null){
                persons.insert(person, 1);
            }
            else {
                SLLNode<MapEntry<String, Integer>> node = persons.search(passportID);
                persons.insert(person, node.element.value+1);
            }
        }
        
        int m = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split("\\s+");

            String oldname = parts[0];
            String newname = parts[1];

            if(persons.search(oldname) == null){
                persons.insert(newname, 1);
            }
            else {
                SLLNode<MapEntry<String, Integer>> node = persons.search(oldname);
                persons.insert(newname, node.element.value+1);
                persons.delete(oldname);
            }
        }

        String passportID = bufferedReader.readLine();
        SLLNode<MapEntry<String , Integer>> node = persons.search(passportID);

        if(node != null ){
            System.out.println(" Allowed");
        }
        else {
            System.out.println("Not Allowed");
        }

    }
}
