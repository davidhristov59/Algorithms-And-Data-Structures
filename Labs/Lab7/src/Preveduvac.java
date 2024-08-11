import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class OBHT<K extends Comparable<K>,E> {
    private MapEntry<K,E>[] buckets;
    // buckets[b] is null if bucket b has never been occupied.
// buckets[b] is former if bucket b is formerly-occupied
// by an entry that has since been deleted (and not yet replaced).
    @SuppressWarnings("unchecked")
    private static final MapEntry former = new MapEntry(null, null);
    private int occupancy = 0;
    @SuppressWarnings("unchecked")
    public OBHT (int m) {
// Construct an empty OBHT with m buckets.
        buckets = (MapEntry<K,E>[]) new MapEntry[m];
    }
    private int hash (K key) {
// Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }
    static final int NONE = -1; // ... distinct from any bucket index.
    public E search (K targetKey) {
// Find which if any bucket of this OBHT is occupied by an entry whose key
// is equal to targetKey. Return the index of that bucket.
        int b = hash(targetKey); int n_search=0;
        for (;;) {
            MapEntry<K,E> oldEntry = buckets[b];
            if (oldEntry == null)
                return null;
            else if (targetKey.equals(oldEntry.key))
                return oldEntry.value;
            else{ b = (b + 1) % buckets.length;
                n_search++;
                if(n_search==buckets.length) return null;
            }
        }
    }
    public void insert (K key, E val) {
// Insert the entry <key, val> into this OBHT.
        MapEntry<K,E> newEntry = new MapEntry<K,E>(key, val);
        int b = hash(key); int n_search=0;
        for (;;) {
            MapEntry<K,E> oldEntry = buckets[b];
            if (oldEntry == null) {
                if (++occupancy == buckets.length) {
                    System.out.println("Hash tabelata e polna!!!");
                }
                buckets[b] = newEntry;
                return;
            } else if (oldEntry == former
                    || key.equals(oldEntry.key)) {
                buckets[b] = newEntry;
                return;
            }
            else{ b = (b + 1) % buckets.length;
                n_search++;
                if(n_search==buckets.length) return;
            }
        }
    }
    @SuppressWarnings("unchecked")
    public void delete (K key) {
// Delete the entry (if any) whose key is equal to key from this OBHT.
        int b = hash(key); int n_search=0;
        for (;;) {
            MapEntry<K,E> oldEntry = buckets[b];
            if (oldEntry == null)
                return;
            else if (key.equals(oldEntry.key)) {
                buckets[b] = former;//(MapEntry<K,E>)former;
                return;
            }
            else {
                b = (b + 1) % buckets.length;
                n_search++;
                if(n_search==buckets.length) return;
            }
        }
    }
    @SuppressWarnings("unchecked")
    public OBHT<K,E> clone (){ //creates copy of the OBHT and returns the copy
        OBHT<K,E> copy = new OBHT<K,E>(buckets.length);
        for (int i = 0; i < buckets.length; i++) {
            MapEntry<K,E> e = buckets[i];
            if (e != null && e != former)
                copy.buckets[i] = new MapEntry<K,E>(e.key, e.value);
            else
                copy.buckets[i] = e;
        }
        return copy;
    }
}

public class Preveduvac{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        OBHT<String, String> hashtable = new OBHT<>(2*n);

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split("\\s+");

            String mkdWord = parts[0];
            String angWord = parts[1];

            hashtable.insert(angWord, mkdWord);
        }


        while(true){

            String line = bufferedReader.readLine();

            if(line.equals("KRAJ")){
                break;
            }

            String value = hashtable.search(line);

            if(value == null){
                System.out.println("/");
            }
            else {
                System.out.println(value);
            }
        }
    }
}

