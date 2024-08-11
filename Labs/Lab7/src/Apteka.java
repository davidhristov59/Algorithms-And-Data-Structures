import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

class Lek {

    String imeLek;
    int pozList;
    int cena;
    int kolicina;

    public Lek(String imeLek, int pozList, int cena, int kolicina) {
        this.imeLek = imeLek;
        this.pozList = pozList;
        this.cena = cena;
        this.kolicina = kolicina;
    }

    public String getImeLek() {
        return imeLek;
    }

    public int getPozList() {
        return pozList;
    }

    public int getCena() {
        return cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setImeLek(String imeLek) {
        this.imeLek = imeLek;
    }

    public void setPozList(int pozList) {
        this.pozList = pozList;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
//        if(pozList==1) return imeLek+"\n"+"POZ\n"+cena+"\n"+kolicina;
//        else return imeLek+"\n"+"NEG\n"+cena+"\n"+kolicina;

        if (pozList == 1) { //ako e 1 e pozitivno
            return String.format("%s\nPOZ\n%d\n%d", imeLek, cena, kolicina);
        }

        return String.format("%s\nNEG\n%d\n%d", imeLek, cena, kolicina);
    }
}

class LekKluch implements Comparable<LekKluch>{

    String name;

    public LekKluch(String name) {
        this.name = name.toUpperCase();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LekKluch lekKluch = (LekKluch) o;
        return Objects.equals(name, lekKluch.name);
    }

    @Override
    public int hashCode() {

        // return (29 * (29 * ((int) ime.charAt(0) + (int) ime.charAt(1) + (int) ime.charAt(2)))) % 102780;
        //h(w)=(29∗(29∗(29∗0+ASCII(c1))+ASCII(c2))+ASCII(c3))%102780
        //TODO
        return ( 29 * (29 * ((int) name.charAt(0) + (int) name.charAt(1) + (int) name.charAt(2)))) % 102780;
    }

    @Override
    public int compareTo(LekKluch o) {
        return 0;
    }
}

public class Apteka {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        CBHT<LekKluch, Lek> lekovi = new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();

            String[] parts = line.split("\\s+");

            String name = parts[0];
            int pozLista = Integer.parseInt(parts[1]);
            int cena = Integer.parseInt(parts[2]);
            int kolicina = Integer.parseInt(parts[3]);

            Lek lek = new Lek(name, pozLista, cena, kolicina);

            lekovi.insert(new LekKluch(name.toUpperCase()), lek);
        }

        while(true){
            String line = bufferedReader.readLine();

            if(line.equals("KRAJ")){
                continue;
            }

            int brojParcinja = Integer.parseInt(bufferedReader.readLine());

            LekKluch lekKluch = new LekKluch(line);

            SLLNode<MapEntry<LekKluch, Lek>> node = lekovi.search(lekKluch);

            if(node == null){
                System.out.println("Nema takov lek");
                continue; //prodolzi da baras za drugite lekovi
            }

            Lek lek = node.element.value; //zemi ja vrednosta, ne formiraj nov objekt
            System.out.println(lek);

            if(lek.getKolicina() >= brojParcinja){
                lek.setKolicina(lek.getKolicina() - brojParcinja); //ke se odzeme od taa kolicina i ke dobieme vkupno
                System.out.println("Nema dovolno lekovi");
            }
            else {
                System.out.println("Napravena naracka");
            }

        }


    }
}

//class Lek{
//    String ime;
//    int pozLista;
//    int cena;
//    int kolicina;
//
//    public String getIme() {                return ime;                 }
//    public void setIme(String ime) {        this.ime = ime;	            }
//    public int getCena() {      		    return cena;	            }
//    public void setCena(int cena) {		    this.cena = cena;           }
//    public int getKolicina() {  		    return kolicina;	        }
//    public void setKolicina(int kolicina) { this.kolicina = kolicina;	}
//    public int getPozLista() {      		return pozLista;        	}
//
//    public Lek(String ime, int pozLista, int cena, int kolicina) {
//        this.ime = ime.toUpperCase();
//        this.pozLista = pozLista;
//        this.cena = cena;
//        this.kolicina = kolicina;
//    }
//
//    @Override
//    public String toString() {
//        if(pozLista==1) return ime+"\n"+"POZ\n"+cena+"\n"+kolicina;
//        else return ime+"\n"+"NEG\n"+cena+"\n"+kolicina;
//    }
//}

//class LekKluch implements Comparable<LekKluch> {
//    String ime;
//    public LekKluch(String ime) {
//        this.ime = ime.toUpperCase();
//    }
//
//    @Override
//    public int hashCode() {
//
////        Начинот на кој тој треба да пребарува е следен: доволно е да ги внесе
////        ПРВИТЕ 3 БУКВИ  од името на лекот за да може да му се излиста листа од лекови
////        кои ги има во системот
//
//        // TODO implement
//        //Функцијата со која се врши мапирање на имињата на лековите во број е следна:
//        // h(w)=(29∗(29∗(29∗0+ASCII(c1))+ASCII(c2))+ASCII(c3))%102780
//        // каде зборот w=c1c2c3c4c5…. е составен од сите големи букви.
//        return (29 * (29 * ((int) ime.charAt(0) + (int) ime.charAt(1) + (int) ime.charAt(2)))) % 102780;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        LekKluch lekKluch = (LekKluch) o;
//        return Objects.equals(ime, lekKluch.ime);
//    }
//
//    @Override
//    public int compareTo(LekKluch o) {
//        return 0;
//    }
//}

//public class Apteka {
//    public static void main(String[] args) throws  IOException {
//        // TODO implement
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(bufferedReader.readLine()); //broj na lekovi
//
//        //1 NACIN
////        CBHT<String,Lek> lekovi = new CBHT<>(2 * n ); //obavezno drugata klasa da bide value
//
//        //2 NACIN  - koristenje na 2te klasi
//        CBHT<LekKluch, Lek> lekovi = new CBHT<LekKluch, Lek>(n * 2);
//
//        for (int i = 0; i < n; i++) {
//            String line = bufferedReader.readLine();
//            String[] parts = line.split("\\s+");
//
//            String ime_lek = parts[0];
//            int pozitivna_lista = Integer.parseInt(parts[1]); //1 ili 0
//            int cena = Integer.parseInt(parts[2]);
//            int kolicina = Integer.parseInt(parts[3]);
//
//            Lek lek = new Lek(ime_lek, pozitivna_lista, cena,kolicina);
//
//            //1 NACIN
////            lekovi.insert(ime_lek.toUpperCase(), lek); //ovie site od klasata Lek ke bidat vrednosti
//
//            //2 NACIN
//            lekovi.insert(new LekKluch(ime_lek), lek); // Insert medicine into the hash table using LekKluch as key
//
//        }
//
//        while(true){
//            String line = bufferedReader.readLine();
//
//            if(line.equals("KRAJ")){
//                continue;
//            }
//
//            int amount = Integer.parseInt(bufferedReader.readLine());
//
//            //1 nacin
////            SLLNode<MapEntry<String, Lek>> node = lekovi.search(line);
//
//            //2nacin
//            SLLNode<MapEntry<LekKluch, Lek>> drug= lekovi.search(new LekKluch(line));
//
//            if(drug == null){
//                System.out.println("Nema takov lek");
//                continue; //NAJBITNO
//            }
//
//            Lek lek = drug.element.value;
//            System.out.println(drug.element.value);
////            System.out.println(lek);
//
//            if(lek.getKolicina() >= amount ){ //ako narackata na klientot e pogolema od zalihata
//                lek.setKolicina(lek.getKolicina() - amount);
//                System.out.println("Nema dovolno lekovi");
//            }
//            else {
//                System.out.println("Napravena naracka");
//            }
//        }
//    }
//}
