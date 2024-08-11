package cbht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

class Name implements Comparable<Name>{

    String name;

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() { //ova nie treba da go napiseme. Mapira od iminja vo brojki
        return (100 * name.charAt(0) + name.charAt(1));
    }

    @Override
    public int compareTo(Name o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Iminja {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        CBHT<Name, Integer> males = new CBHT<>(9091);
        CBHT<Name, Integer> females = new CBHT<>(9091);

        for (int i = 0; i < n; i++) {

            String line = bufferedReader.readLine();
            String[] parts = line.split("\\s+");

            String ime = parts[0];
            String gender = parts[1];

            Name name = new Name(ime.toUpperCase());

            if (gender.equals("M")) {

                SLLNode<MapEntry<Name, Integer>> male = males.search(name);

                if (male == null) {
                    males.insert(name, 1);
                } else {
//                    Integer masko = male.element.value+1;
                    males.insert(name, male.element.value + 1);
                }
            } else {
                SLLNode<MapEntry<Name, Integer>> female = females.search(name);

                if (female == null) {
                    females.insert(name, 1);
                } else {
                    females.insert(name, female.element.value + 1);
                }
            }
        }

        String gender = bufferedReader.readLine().toUpperCase();

        while (true) {

            String input = bufferedReader.readLine().toUpperCase();

            if (input.equals("END")) {
                break;
            }

            if (gender.equals("M")) {
                SLLNode<MapEntry<Name, Integer>> male = males.search(new Name(input));//moram vo objekt Name, ne moze samo String

                if (male != null) {
                    System.out.println("M " + input + " " + male.element.value);
                } else {
                    System.out.println("No such name");
                }

            } else if (gender.equals("F")) {
                SLLNode<MapEntry<Name, Integer>> female = females.search(new Name(input));//moram vo objekt Name, ne moze samo String

                if (female != null) {
                    System.out.println("F " + input + " " + female.element.value);
                } else {
                    System.out.println("No such name");
                }
            }
        }
    }
}
