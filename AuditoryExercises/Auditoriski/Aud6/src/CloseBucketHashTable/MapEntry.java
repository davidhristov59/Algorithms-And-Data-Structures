package CloseBucketHashTable;

public class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {

    //sekoj CloseBucketHashTable.MapEntry objekt e sostaven od key(Comparable object) and a value

    //rabotime so generici bidejki sakame od bilo koj tip da ni e klucot
    public K key;
    public E value;

    public MapEntry(K key, E value) {
        this.key = key;
        this.value = value;
    }

    //samiot CloseBucketHashTable.MapEntry mora da se sporedi so drug kluc bidejki sekogas prebaruvanjeto nie po
    // klucevi i da proverime dali klucot e ednakov na toa sto proveruvame
    @Override
    public int compareTo(K that) { //PREBARUVAME SPORED KLUCOT ZATOA E KEY

//        @SuppressWarnings("unchecked");
        MapEntry<K,E> other = (MapEntry<K, E>) that; //se kastira klucot vo taa mapa
        return this.key.compareTo(other.key); //se sporeduva this key so that key
    }

    public String toString(){
        return "<" + key + "," + value + ">";
    }

}

//CloseBucketHashTable.CBHT - CLOSED BUCKET HASH TABLE - VO SEKOJA KOSNICKA MOZAT DA SE SMESTAT POVEKE ELEMENTI
//OBHT - OPEN BUCKET HASH TABLE  - VO SEKOJA KOSNICKA MOZE MAKS EEDEN ELEMENT DA SE SMESTI