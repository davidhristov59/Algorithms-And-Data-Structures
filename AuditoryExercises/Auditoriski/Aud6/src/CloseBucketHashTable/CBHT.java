package CloseBucketHashTable;

public class CBHT<K extends Comparable<K>, E>{ //Klucot e K i mora da bide Comparable i vrednosta e od tip E - element
    //CLOSE BUCKET HASH TABLE

    private SLLNode<MapEntry<K,E>>[] buckets; //niza od node-ovi od parovi kluc i vrednost
    //sekoja koficka e SLL

    public CBHT(int m){ //m e brojot na kofickite

        //KREIRA PRAZNA HASH TABELA SO M koficki
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m]; //se kastira vo genericka klasa za da moze da se raboti
    }

    private int hash(K key){ //za sekoj kluc vraka hash vrednost- NEKOJ INT - indeksot kaj so streba da se vmetne

        //Go preveduva klucot vo indeks na nizata bucket
        return Math.abs(key.hashCode()) % buckets.length;
    }


    //da prebarame element spored kluc
    public SLLNode<MapEntry<K,E>> search(K targetKey) {
        //Го наоѓа јазолот од CloseBucketHashTable.CBHT кој содржи елемент чиј клуч е еднаков на targetKey.
        // Враќа врска до тој јазол (или null ако нема таков јазол)
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key)){
                return curr;
            }
        }
        return null;
    }

    //da vmetneme element spored kluc
    public void insert(K key, E val) {

        //Вметнување на парот <key, val> во CloseBucketHashTable.CBHT.
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val); //se kreira parot od kluc i vrednost
        int b = hash(key); //se naoga hash funkcijata - gledame vo koja koficka treba da bide smesten ovoj element

        //Класата CloseBucketHashTable.SLLNode од еднострано поврзани листи.
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) { //ja izminuvame listata , se dodeka ne e null
            if (key.equals(((MapEntry<K, E>) curr.element).key)) { //newEntry го заменува постоечкиот елемент со клуч key.
                curr.element = newEntry;
                return;
            }
        }
        //Додавање на newEntry на почетокот на листата во домашната „кофичка” со индекс b.
        buckets[b] = new SLLNode<MapEntry<K, E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {

        int b = hash(key);

        for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {

        String temp = "";

        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }

}
