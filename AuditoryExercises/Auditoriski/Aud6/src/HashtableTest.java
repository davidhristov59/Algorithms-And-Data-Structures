import java.util.Hashtable;

public class HashtableTest<K,V> {

    public static void main(String[] args) {
        Hashtable<Character,Integer> hashTable = new Hashtable<>(); //funkcija dadena
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < s.length(); i++) {
            hashTable.put(s.charAt(i),i); //ja polni hes tabelata
        }

        System.out.println(hashTable);
        //ја земаме вредноста за буквата Z
        System.out.println("The value of letter Z is " + hashTable.get('Z'));
    }
}
