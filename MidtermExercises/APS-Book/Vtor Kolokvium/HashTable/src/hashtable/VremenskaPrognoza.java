package hashtable;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Hashtable;
//import java.util.List;
//import java.util.Objects;
//
//public class VremenskaPrognoza {
//
//    public static class Par{

//        String start;
//        String end;
//        Double stepeni;
//
//        public Par(String start, String end, Double stepeni) {
//            this.start = start;
//            this.end = end;
//            this.stepeni = stepeni;
//        }
//
//        public String getStart() {
//            return start;
//        }
//
//        public void setStart(String start) {
//            this.start = start;
//        }
//
//        public Double getStepeni() {
//            return stepeni;
//        }
//
//        public String getEnd() {
//            return end;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Par par = (Par) o;
//            return Objects.equals(start, par.start) && Objects.equals(end, par.end) && Objects.equals(stepeni, par.stepeni);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(start, end, stepeni);
//        }
//
//        public void setEnd(String end) {
//            this.end = end;
//        }
//
//        public void setStepeni(Double stepeni) {
//            this.stepeni = stepeni;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(bufferedReader.readLine());
//
////        CBHT<String, List<String>> tabela = new CBHT(2*n);
//        //gradot key, value = lista od parovi od stepeni celziusovi i intervali
//
//        Hashtable<String, List<Par>> tabela = new Hashtable<>();
//
//        for (int i = 0; i < n; i++) {
//            String line =  bufferedReader.readLine();
//            String[] parts = line.split("\\s+");
//
//            String grad = parts[0];
//            String start = parts[1];
//            String end = parts[2];
//            Double stepeni = Double.parseDouble(parts[3]);
//
//            List<Par> pars = tabela.get(grad);
//
//            if(pars == null){
//                pars = new ArrayList<>();
//                tabela.put(grad, pars);
////                tabela.put(grad, new ArrayList<>());
//            }
//
//            Par par = new Par(start, end, stepeni);
//            int i1 = pars.indexOf(par);
//
//            if(i1 == -1){ //ako ne e vo tabelata
//                pars.add(par);
//            }
//            else {
//                Par par2 = pars.get(i1);
//                double average = (par2.stepeni + par.stepeni) / 2;
//                par2.setStepeni(average);
//            }
//        }
//
//        String grad = bufferedReader.readLine();
//
//        List<Par> pars  = tabela.get(grad); //isto kako search, pristapuvame do grad
//
//        if(pars == null){
//            System.out.println(grad + ": does not exist");
//        }
//        else  { //ako postoi
//            System.out.println(grad + ":");
//            for (int i = 0; i < pars.size(); i++) {
//                Par par = pars.get(i);
//                System.out.println(par.getStart() + " - " + par.getEnd() + " " + par.getStepeni());
//            }
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

public class VremenskaPrognoza {

    public static class Par {

        String start_interval;
        String end_interval;
        Double temperature;

        public Par(String start_interval, String end_interval, Double temperature) {
            this.start_interval = start_interval;
            this.end_interval = end_interval;
            this.temperature = temperature;
        }

        public String getStart_interval() {
            return start_interval;
        }

        public String getEnd_interval() {
            return end_interval;
        }

        public Double getTemperature() {
            return temperature;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Par par = (Par) o;
            return Objects.equals(start_interval, par.start_interval) && Objects.equals(end_interval, par.end_interval) && Objects.equals(temperature, par.temperature);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start_interval, end_interval, temperature);
        }

        public void setStart_interval(String start_interval) {
            this.start_interval = start_interval;
        }

        public void setEnd_interval(String end_interval) {
            this.end_interval = end_interval;
        }

        public void setTemperature(Double temperature) {
            this.temperature = temperature;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        Hashtable<String, List<Par>> table = new Hashtable<String, List<Par>>();

        for (int i = 0; i < n; i++) {

            String line = bufferedReader.readLine();
            String[] parts = line.split("\\s+");

            String city = parts[0];
            String startInterval = parts[1];
            String endInterval = parts[2];
            Double temperature = Double.parseDouble(parts[3]);

            Par par = new Par(startInterval, endInterval, temperature);

            List<Par> parovi = table.get(city);

            if (parovi == null) {
                parovi = new ArrayList<>();
                //za daden grad, da se prikaze LISTA od site temperaturni merenja
                table.put(city, parovi);
            }

            int i1 = parovi.indexOf(par);

            if (i1 == -1) { //ako ne e vo tabelata, dodadi go
                parovi.add(par);
            } else { //ako e vo tabelata
                Par par2 = parovi.get(i1);
                double average = (par2.temperature + par.temperature) / 2;
                par2.setTemperature(average);
            }
        }

        String city = bufferedReader.readLine();

        List<Par> parovi = table.get(city);

        if(parovi == null){
            System.out.println(city + ": does not exist");
        }
        else{
            System.out.println(city);
            for (int i = 0; i < parovi.size(); i++) {
               Par par = parovi.get(i); //za da imam pristap do elementite vo klasata

//                System.out.println(par.getStart_interval() + " - " + par.getEnd_interval() + " " + par.getTemperature());
                System.out.println(String.format("%s - %s %.2f", par.getStart_interval(), par.getEnd_interval(), par.getTemperature()));
            }
        }
    }
}