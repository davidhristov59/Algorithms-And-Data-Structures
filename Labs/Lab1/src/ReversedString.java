import java.util.Scanner;

//За даден збор ко се внесува од стандарден влез, да се испечати истиот превртен. На влез во првиот ред се дава броj на зборови кои ке се внесуваат. Во наредните линии се внесуваат самите зборови
public class ReversedString {

    public static void printReversed(String word){ //static za da imame pristap vo main-ot
        StringBuilder stringBuilder = new StringBuilder(word);

        String reversed =  stringBuilder.reverse().toString();

        System.out.println(reversed);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        int numStrings = Integer.parseInt(scanner.nextLine()); //moze i vaka za da ne pisuvame scanner.nextLine();
        int numStrings = scanner.nextInt();
        scanner.nextLine();

        int counter = 0;
        while(numStrings > counter){
            String line = scanner.nextLine();
            printReversed(line);
            counter++;
        }
    }


}
