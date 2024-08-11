package obht;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Objects;
//
//class KlucBroj implements Comparable<KlucBroj>{
//
//    String number;
//
//    public KlucBroj(String number) {
//        this.number = number;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        KlucBroj klucBroj = (KlucBroj) o;
//        return this.compareTo(klucBroj) == 0; //ova go dodavame
//        //compareTo ke ni vrati vrednost 0 koga 2ta broja ke se ednakvi
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(removePrefix(number)); //dodavame vo hash
//    }
//
//    //bez razlika na toa dali brojot e +389 ili pocnuva so 7, sakame ostanatite brojki da gi vidime za da znaeme dali pripagaat na odreden sopstvenik
//    String removePrefix(String str){
//       if(str.startsWith("0")) { //ako zapocnuva so 0
//           return str.substring(1); //ke ja skokne prvata cifra 0 i ke go dade ostanatiot broj
//       }
//       else {
//           return str.substring(4) ; //+389 ke otstranime i ke go dade ostanatiot broj
//       }
//    }
//
//    @Override
//    public String toString() {
//        return "BrKluc" + number;
//    }
//
//    @Override
//    public int compareTo(KlucBroj o) {
//        String str1 = removePrefix(this.number);
//        String str2 = removePrefix(o.number);
//
//        return str1.compareTo(str2); //gi sproeduva 2ta broja
//    }
//
//}
//
//public class TelefonskiImenik {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(bufferedReader.readLine());
//
//        //prebaruvame za daden broj
//             //brojot, imeto
//        OBHT<KlucBroj, String> tabela = new OBHT<KlucBroj, String>(2 * n);
//        //pomosna klasa podobro za vnatre vo klasata da mozeme da gi definirame metodite hashcode i equals
//
//        for (int i = 0; i < n; i++) {
//            String line = bufferedReader.readLine();
//
//            String[] parts = line.split("\\s+");
//
//            String number = parts[0];
//            String name = parts[1];
//
//            KlucBroj klucBroj = new KlucBroj(number);
//
//            tabela.insert(klucBroj, name);
//        }
//
//        String broj = bufferedReader.readLine();
//
//        KlucBroj klucBroj = new KlucBroj(broj);
//
//        int index = tabela.search(klucBroj); //vo OBHT search metodot vraka int
//
//        if(index == -1){
//            System.out.println("Unknown number");
//        }
//
//        else {
//            //1 NACIN
////            MapEntry<KlucBroj, String> entry = tabela.buckets[index];
//
//            //buckets e niza i ni treba index za da pristapime do odreden element
//            //buckets e niza koj sto cuva key-value parovi.
//            //Sekoj element vo nizata se vika koficka -- bucket
//
//            //2 opcija
//
//            String foundName = tabela.buckets[index].value;
//
////            String foundName = entry.value; //zemi ja vrednosta kako String, vrati Ime
//
//            System.out.println(foundName);
//        }
//    }
//}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

class KlucBroj implements Comparable<KlucBroj>{

    String number;

    public KlucBroj(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KlucBroj klucBroj = (KlucBroj) o;
        return Objects.equals(number, klucBroj.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(removePrefix(number));
    }

    public String removePrefix(String str){
        if(str.startsWith("0")){
            return str.substring(1);
        }
        else {
            return str.substring(4);
        }
    }

    @Override
    public int compareTo(KlucBroj o) {

        String str1 = removePrefix(this.number);
        String str2 = removePrefix(o.number);

        return this.number.compareTo(o.number);
    }
}

public class TelefonskiImenik {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        OBHT<KlucBroj, String> table = new OBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split("\\s+");
            String number = parts[0];
            String name = parts[1];

            KlucBroj klucBroj = new KlucBroj(number);

            table.insert(klucBroj, name);
        }

        String number = bufferedReader.readLine();

        KlucBroj klucBroj = new KlucBroj(number);

        //namesto SLLNode  vo CBHT
        int index = table.search(klucBroj);

        if(index == -1){
            System.out.println("Unknown number");
        }

        //vmetnuvame nov clen vo igrata - buckets - OBHT
        //buckets e niza i ni treba index vo taa niza za da pristapime do odreden element
        //buckets e niza koj sto cuva key-value vrednosti, i VRAKA MapEntry
        //OBHT e pozaebana, ima kolizii i toa ni pravi

        else{ //ako ne e prazna

            //go cuvame string

            //1 NACIN
            String foundName = table.buckets[index].value;
            System.out.println(foundName);

            //2 NACIN
//            MapEntry<KlucBroj, String> entry = table.buckets[index];
//            String foundName = entry.value;
//            System.out.println(foundName);

        }



    }
}