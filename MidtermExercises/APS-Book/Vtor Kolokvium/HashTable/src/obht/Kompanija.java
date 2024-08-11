package obht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

class Menadzer{
    String name;

    public Menadzer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vraboten vraboten = (Vraboten) o;
        return name.equals(vraboten.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

class Vraboten implements Comparable<Vraboten> {
    String name;

    public Vraboten(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vraboten vraboten = (Vraboten) o;
        return name.equals(vraboten.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(Vraboten o) {
        return this.name.compareTo(o.name);
    }
}

public class Kompanija {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        OBHT<Vraboten, Menadzer> tabela = new OBHT<>(2 * n);
        OBHT<String, Integer> result = new OBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();

            String[] parts = line.split(",");
            String name_vraboten = parts[0];
            String name_menadzer = parts[1];

            Vraboten vraboten = new Vraboten(name_vraboten);
            Menadzer menadzer = new Menadzer(name_menadzer);

            Integer count = tabela.search(vraboten);




        }



    }
}
