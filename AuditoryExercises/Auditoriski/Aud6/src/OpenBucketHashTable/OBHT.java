package OpenBucketHashTable;

public class OBHT<K extends Comparable<K>,E> {
    //sekoja koficka sodrzi samo 1 element
    //ako ima kolizija , noviot element se premestuva vo druga koficka
    //niza od MapEntry
    //3 sostojbi  - nikogas-zafatena, zafatena, prethodno - zafatena


    //Табелата се состои од MapEntry објекти.
    public MapEntry<K,E>[] buckets;

    //buckets[b] е null ако „кофичката” b не била никогаш зафатена.
    //buckets[b] е претходно зафатена ако во „кофичката” b имало претходно елемент кој е избришан и моментално нема елемент во оваа „кофичка”.

    static final int NONE = -1; //различно од било кој индекс на „кофичка”. private static final MapEntry former = new MapEntry(null, null);
    //Ова гарантира дека за било кој елемент e e.key.equals(former.key) е false.

    private static final MapEntry former = new MapEntry(null, null);
    //Ова гарантира дека за било кој елемент e e.key.equals(former.key) е false.

    private int occupancy = 0;
    //број на зафатени или претходно зафатени „кофички”.

    @SuppressWarnings("unchecked")
    public OBHT (int m) {
        //Се креира празна OBHT со m „кофички”.
        buckets = (MapEntry<K,E>[]) new MapEntry[m];
    }

    private int hash(K key) {
//Го преведува клучот во индекс на низата buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public int search (K targetKey) {
        int b = hash(targetKey);
        int n_search=0;
        for (;;) {
            MapEntry<K,E> oldEntry = buckets[b];
            if (oldEntry == null)
                return NONE;
            else if (targetKey.equals(oldEntry.key))
                return b; else
            {
                b = (b + 1) % buckets.length;
                n_search++;
                if(n_search==buckets.length)
                    return NONE;
            }
        }
    }

    public MapEntry<K,E> getBucket(int i){
        return buckets[i];
    }

    public void insert (K key, E val) {
        MapEntry<K,E> newEntry = new MapEntry<K,E>(key, val); int b = hash(key);
        int n_search=0;
        for (;;) {
            MapEntry<K,E> oldEntry = buckets[b]; if (oldEntry == null) {
                if (++occupancy == buckets.length) { System.out.println("Hash table is full!!!");
                }
                buckets[b] = newEntry; return;
            }
            else if (oldEntry == former || key.equals (oldEntry.key)) {
                buckets[b] = newEntry;
                return;
            }
            else {
                b = (b + 1) % buckets.length;
                n_search++;
                if (n_search == buckets.length)
                    return;
            }
        }
    }

}
