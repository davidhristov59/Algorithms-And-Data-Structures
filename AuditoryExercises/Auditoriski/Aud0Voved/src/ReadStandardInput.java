import java.util.Scanner;

public class ReadStandardInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        scanner.nextLine(); //go dodavame ako sakame da citame broj pa linija

        String line = scanner.nextLine();
        System.out.println(n);
        System.out.println(line);
    }

}
