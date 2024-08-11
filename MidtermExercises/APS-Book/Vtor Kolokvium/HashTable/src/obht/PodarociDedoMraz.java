package obht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

class Child implements Comparable<Child>{
    String name;
    String address;

    public Child(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return name.equals(child.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(Child o) {
        return this.address.compareTo(o.address);
    }
}

public class PodarociDedoMraz {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        OBHT<Child, String> table = new OBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();

            String[] parts = line.split("\\s+");

            String name = parts[0];
            String address = parts[1] + " " + parts[2]; //go dodadava i vtoriod del na adresata

            Child child = new Child(name, address);

            table.insert(child, address);
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        OBHT<String, String> table2 = new OBHT<>(2 * m);

        for (int i = 0; i < m; i++) {
            String line = bufferedReader.readLine();

            String[] parts = line.split("\\s+");

            String oldAddress = parts[0];
            String newAddress = parts[1];

            table2.insert(oldAddress, newAddress);
        }

        String nameChild = bufferedReader.readLine();

        //TODO DA SE DORESI

    }
}
