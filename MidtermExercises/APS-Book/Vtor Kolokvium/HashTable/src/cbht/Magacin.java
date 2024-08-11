package cbht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Magacin {

    public static class Lek implements Comparable<Lek>{

        String name;
        Integer price;
        String use;

        public Lek(String name, Integer price, String use) {
            this.name = name;
            this.price = price;
            this.use = use;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Lek lek = (Lek) o;
            return Objects.equals(name, lek.name) && Objects.equals(price, lek.price) && Objects.equals(use, lek.use);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price, use);
        }

        public String getName() {
            return name;
        }

        public Integer getPrice() {
            return price;
        }

        public String getUse() {
            return use;
        }

        @Override
        public int compareTo(Lek o) {
            return Integer.compare(this.price, o.price);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        CBHT<String, List<Lek>> table = new CBHT<String, List<Lek>>(2 * n);

        for (int i = 0; i < n; i++) {

            String line = bufferedReader.readLine();

            String[] parts = line.split("@");
            String nameLek = parts[0];
            String bolest = parts[1];
            Integer price = Integer.parseInt(parts[2]);

//            List<Lek> lekovi = new ArrayList<>();
            Lek lek = new Lek(nameLek, price, bolest);

            //за дадена намена (болест), да го испечатите лекот коj има наjниска цена на пазарот.
            if(table.search(bolest) == null){
//                table.insert(bolest, lekovi);
//                table.search(bolest).element.value.add(lek);
                List<Lek> lekovi = new ArrayList<>();
                lekovi.add(lek);
                table.insert(bolest,lekovi);
            }
            else {
                table.search(bolest).element.value.add(lek);
            }
        }

        String bolest = bufferedReader.readLine();

        if(table.search(bolest) == null){
            System.out.println("Nema lek za baranata bolest vo magacinot");
        }
        else {
           Optional <Lek> lek = table.search(bolest).element.value
                    .stream()
                    .min(Comparator.comparing(Lek::getPrice)); //minimalna cena - GO BARAME NAJEFTINIOT LEK

            System.out.println(lek.get().getName());
        }
    }
}
