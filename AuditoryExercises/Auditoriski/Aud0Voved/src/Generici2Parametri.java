public class Generici2Parametri {

    interface Pair<K,V>{
        public K getKey();
        public V getValue();
    }

    static class OrderedPair<K,V> implements Pair<K,V>{

        private K key;
        private V value;

        public OrderedPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "OrderedPair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        OrderedPair<String, Integer> orderedPair = new OrderedPair<String,Integer>("Luka Kavajin", 212);
        System.out.println(orderedPair.toString());
        OrderedPair<String, String > stringOrderedPair = new OrderedPair<String,String>("Pale Kozareva", "David Hristov");
        System.out.println(stringOrderedPair.toString());

    }

}
