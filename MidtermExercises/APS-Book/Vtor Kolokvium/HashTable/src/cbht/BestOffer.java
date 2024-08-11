package cbht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Lecture implements Comparable<Lecture>{

    String date;
    String time;
    String city;
    Integer fee;

    public Lecture(String date, String time, String city, Integer fee) {
        this.date = date;
        this.time = time;
        this.city = city;
        this.fee = fee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }


    @Override
    public int compareTo(Lecture o) {
        if(this.fee > o.fee){
            return 1;
        }
        else if(this.fee < o.fee){
            return -1;
        }
        return 0; //ako se isti
    }
}

public class BestOffer {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        CBHT<String, ArrayList<Lecture>> offers = new CBHT<>(2 * n);
        //String ke ni bide key bidejki BARAME SPORED datumot
        //value ke ni bide arrayList zoso treba da vratime poveke detali

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            String [] parts = line.split("\\s+");

            String date = parts[0];
            String time = parts[1];
            String city = parts[2];
            Integer fee = Integer.parseInt(parts[3]);

            Lecture lecture = new Lecture(date,time,city,fee);

            //Postojat 2 opcii za dodavanje na elementi vo hash tabelata
            //1. koga elementot so daden kluc ne postoi vo tabelata
            //2. koga elementot postoi
            if (offers.search(date) == null){  //ako elementot ne postoi
                ArrayList<Lecture> lectures = new ArrayList<>();
                lectures.add(lecture); //dodavi vo listata
                offers.insert(date, lectures); //dodadi vo tabelata - element so kluc datum i vrednost niza so objektot od istiot kluc
            }
            else { //ako ne e prazna tabelata
                SLLNode<MapEntry<String, ArrayList<Lecture>>> node = offers.search(date); //se prebaruva objektot so istiot kluc i negovata vrednost

                ArrayList<Lecture> lectures = node.element.value; //CRUCIAL STEP
                /*
                That step is crucial because it retrieves the existing list of lectures associated with a particular date from the hash table. When adding new lectures with the same date, it's essential to update the existing list by appending the new lecture(s) to it.
                This process ensures that lectures with the same date are grouped together in the hash table, allowing you to maintain all lectures for a specific date in a single list. Then, you can sort or manipulate this list as needed, without losing previously added lectures for that date.
                 */

                lectures.add(lecture);
                Collections.sort(lectures, Comparator.reverseOrder()); // секогаш предавањето со наjголем хонорар к ́е биде на прва позициjа (0)
                //morame da sortirame za da ja najdeme najvisokata cena zatoa REVERSEorder POCNUVA OD NAJGOLEMATA I GO ZIMA NAJGOLEMOTO

                offers.insert(date,lectures);
            }
        }

        String input = bufferedReader.readLine();

        SLLNode<MapEntry<String, ArrayList<Lecture>>> node = offers.search(input); //se prebaruva vo tabelata spored dadeniot datum

        if(node != null){
            //09:00 Beijing 8000
            System.out.println(node.element.value.get(0).getTime() + " "  + node.element.value.get(0).getCity() + " " + node.element.value.get(0).getFee());
            //rezultatot se dobiva preku pristapuvanje na prviot objekt od nizata so predavanja
        }
        else { //node == null
            System.out.println("No offers");
        }

    }
}
