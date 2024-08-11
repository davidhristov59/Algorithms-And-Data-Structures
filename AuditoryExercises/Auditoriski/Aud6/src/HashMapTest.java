import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();

        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),i);
        }
        System.out.println(map);
        System.out.println("The value of letter Z is " + map.get('Z'));

    }
}
