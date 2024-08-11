package CloseBucketHashTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Offer implements Comparable<Offer>{

    String date;
    String time;
    String city;
    int revenue;

    public Offer(String date, String time, String city, int revenue) {
        this.date = date;
        this.time = time;
        this.city = city;
        this.revenue = revenue;
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

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    @Override
    public int compareTo(Offer o) { //go sporeduvame honorarot

        if(this.revenue > o.revenue){
            return 1;
        }
        else if(this.revenue < o.revenue){
            return -1;
        }
        return 0; //ako se isti
    }
}

public class BestOffer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

//        List<CloseBucketHashTable.Offer> offers = new ArrayList<>();

        CBHT<String, List<Offer>> offers = new CBHT<>(2*n);
        //za sekoj datum ke iamme lista od ponudi

        for (int i = 0; i < n; i++) {

            String offerLine = scanner.nextLine();

            String[] parts = offerLine.split("\\s+");
            String date = parts[0];
            String time = parts[1];
            String city = parts[2];
            int revenue = Integer.parseInt(parts[3]);

            Offer offer = new Offer(date, time, city, revenue);

            // Search for existing offers with the same date in the hash table
            SLLNode<MapEntry<String,List<Offer>>> tmp = offers.search(date); //PREBARUVAME SPORED DATUMOT

            if(tmp == null){ //ako nema element
                List<Offer> offerList = new ArrayList<>();
                offerList.add(offer); //ke ja vmetneme ponudata vo listata, potocno ke dodademe element
                offers.insert(date,offerList); // Insert new date with a list of offers
            }
            else { //dokolku imalo veke element
                tmp.element.value.add(offer);
                //da ja zememe listata so value i bidejki e referencen tip ke ja dodademe so add
            }
        }

        //citame datum na kraj
        String date = scanner.nextLine();

        SLLNode<MapEntry<String,List<Offer>>> result = offers.search(date); //baraj go datumot vo tabelata - spored datumot

        if(result == null){ //ako nema ponudi za dadeniot datum
            System.out.println("No offers");
        }
        else { //Ako ima ponudi
            List<Offer> offerList = result.element.value;
            Offer maxOffer = offerList.get(0); //time

            for(Offer offer : offerList){
                if(offer.compareTo(maxOffer) > 0){ //dokolku se najde nekoja pogolema ponuda
                    maxOffer = offer;
                }
            }
            System.out.println(maxOffer.time + " " + maxOffer.city + " " + maxOffer.revenue);  //09:00 Beijing 8000
        }


    }
}
