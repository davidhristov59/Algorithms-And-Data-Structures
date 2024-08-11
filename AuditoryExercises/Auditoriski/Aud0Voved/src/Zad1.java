import java.util.Scanner;

public class Zad1 {

    public static void main(String[] args) {

        int suma = 0, parni = 0, neparni = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vnesi opseg na broevi");
        System.out.println("Start =");
        int start = scanner.nextInt();
        System.out.println("End =");
        int end = scanner.nextInt();
        System.out.println("Izbor: 1-Parni 2-Neparni");
        int choice = scanner.nextInt();

        if(choice==1){ //parni
            for (int i = start; i < end; i++) {
                if(i % 2 == 0){
                    System.out.println(i + " "); //isprintaj gi site parni broevi
                }
            }
        }
        else if(choice == 2){ //neparni
            for (int i = start; i < end; i++) {
                if(i % 2 != 0){
                    System.out.println(i + " ");
                }
            }
        }
        else {
            System.out.println("Nevaliden izbor");
        }

    }
}
