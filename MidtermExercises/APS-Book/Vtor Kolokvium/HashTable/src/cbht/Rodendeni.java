package cbht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rodendeni {
    //vraka kolku se rodeni vo ist mesec
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        //integer kako value bidejki treba integer da vrati
        CBHT<String, Integer> birthdays = new CBHT<>(n * 2);

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            String [] parts = line.split("\\.");

            String month = parts[1];

            if(birthdays.search(month) == null){ //ako e null insertni go mesecot , ako e praza tabelata
                birthdays.insert(month, 1); //1 ke go koristime kako brojac(count)
                //bidejki ni treba count na meseci , potocno broj na lugje koi se rodeni na toj mesec,
                // togas ke treba da rabotime so nekakov brojac
            }
            else { //ako ne e null i POSTOI VO HES TABELATA
                SLLNode<MapEntry<String, Integer>> node = birthdays.search(month); //baraj spored mesec vo tabelata
                birthdays.insert(month, node.element.value+1); //+1 za da go broi , counter e
            }
        }

        String month_people = bufferedReader.readLine(); //brojot na lugje prikazani vo toj mesec

        SLLNode<MapEntry<String, Integer>> result = birthdays.search(month_people);

        if(result == null){
            System.out.println("Empty");
        }
        else {
            System.out.println(result.element.value); //mora kako vrednost da se vrati
        }

    }
}


