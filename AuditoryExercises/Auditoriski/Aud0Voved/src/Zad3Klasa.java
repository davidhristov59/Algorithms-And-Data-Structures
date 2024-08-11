public class Zad3Klasa {

    static class Zadaca{

        private String description;
        private int num_hours;
        private boolean status;

        public Zadaca(String description, int num_hours, boolean status) {
            this.description = description;
            this.num_hours = num_hours;
            this.status = status;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getNum_hours() {
            return num_hours;
        }

        public void setNum_hours(int num_hours) {
            this.num_hours = num_hours;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return ("Opis: " + description + "\nBroj casovi: " + num_hours + "\nStatus: " + (status ? "aktivna" : "zavrsena"));
        }
    }

    static class Vraboten{
        private String ime;
        private String prezime;
        private static double BOD = 50;
        private double plata;
        private int staz;
        private int broj_bodovi;
        private int broj_zadaci;
        private Zadaca[] zadaci;

        public Vraboten(){
            zadaci = new Zadaca[10];
            broj_zadaci = 0;
        }

        public Vraboten(String ime, String prezime, double plata, int staz, int broj_bodovi, int broj_zadaci, Zadaca[] zadaci) {
            this.ime = ime;
            this.prezime = prezime;
            this.plata = broj_bodovi * BOD;
            this.staz = staz;
            this.broj_bodovi = broj_bodovi;
            this.broj_zadaci = broj_zadaci;
            this.zadaci = zadaci;
        }

        public String getIme() {
            return ime;
        }

        public void setIme(String ime) {
            this.ime = ime;
        }

        public String getPrezime() {
            return prezime;
        }

        public void setPrezime(String prezime) {
            this.prezime = prezime;
        }

        public static double getBOD() {
            return BOD;
        }

        public static void setBOD(double BOD) {
            Vraboten.BOD = BOD;
        }

        public double getPlata() {
            return plata;
        }

        public void setPlata(double plata) {
            this.plata = plata;
        }

        public int getStaz() {
            return staz;
        }

        public void setStaz(int staz) {
            this.staz = staz;
        }

        public int getBroj_bodovi() {
            return broj_bodovi;
        }

        public void setBroj_bodovi(int broj_bodovi) {
            this.broj_bodovi = broj_bodovi;
        }

        public int getBroj_zadaci() {
            return broj_zadaci;
        }

        public void setBroj_zadaci(int broj_zadaci) {
            this.broj_zadaci = broj_zadaci;
        }

        public Zadaca[] getZadaci() {
            return zadaci;
        }

        public void setZadaci(Zadaca[] zadaci) {
            this.zadaci = zadaci;
        }

        public void dodadiZadaca(Zadaca zadaca){
            if(broj_zadaci == 10){
                System.out.println("Ne moze da se dodade zadaca");
            }
            else{
                zadaci[broj_zadaci+1] = zadaca; // se dodava zadaca + 1
            }
        }

        public double procentZavrseni(){
            int brojCasovi = 0;
            for (int i = 0; i < broj_zadaci; i++) {
                if(zadaci[i].isStatus()){
                    brojCasovi++;
                }
            }
            return (float) brojCasovi/broj_zadaci;
        }

        public int vkupenBrojCasovi(){
            int zbir = 0;
            for (int i = 0; i < broj_zadaci; i++) {
                zbir+=zadaci[i].getNum_hours();
            }
            return zbir;
        }

        @Override
        public String toString() {
            return (super.toString() + "\nIme: " + ime + "\nPrezime" + prezime);
        }
    }

    public static void main(String[] args) {

    }
}
