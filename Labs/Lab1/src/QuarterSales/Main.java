package QuarterSales;


import java.util.Scanner;

public class Main{

    public static int sumSales(SalesPerson sp){
        return sp.sumTotalRevenue(); //ќе врати сума од сите приходи остварени од дадениот вработен во одделот за продажба во сите квартали.
    }

    public static SalesPerson salesChampion(SalesPerson [] arr)
    {

        SalesPerson person = arr[0]; //inicijaliziraj go person so prviot salesperson

        for(SalesPerson salesPerson : arr){ //za sekoj salesPerson vo nizata

//            For each salesperson in the array, it checks if the total revenue of that salesperson (obtained by calling getTotalRevenue()) is greater than the total revenue of the current person (which was initially set to the first salesperson).
            if(salesPerson.sumTotalRevenue() > person.sumTotalRevenue()){
                person = salesPerson; //the total revenue of the current salesperson is greater than the total revenue of the current person, it updates the person to be the current salesperson.
            }
        }
        return person; //vrati go person - so highest total revenue
    }

    public static void table(SalesPerson [] arr) {

            System.out.println("SP   1   2   3   4   Total");
            for(SalesPerson salesPerson:arr){
                System.out.print(salesPerson.getName() + "   "); //imeto prvo na vraboteniot
                for(QuarterlySales quarterlySales:salesPerson.getQuarters()){
                    System.out.print(quarterlySales.sumRevenue() + "   "); //sumata na eden quarter posebno (4 vkupno)
                }
                System.out.println(salesPerson.sumTotalRevenue()); //sumata na site 4 quarters
            }
        }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson [] arr = new SalesPerson[n];

        for(int i=0;i<n;i++)
        {
            input.nextLine();
            String name = input.nextLine();
            QuarterlySales[] quarterlySales = new QuarterlySales[4]; //tocno 4 - niza od kvartali
            for (int j = 0; j < quarterlySales.length; j++) { //ili do 4
                int numSales = input.nextInt();
                int[] revenues = new int[numSales];
                for (int k = 0; k < numSales; k++) {
                    revenues[k] = input.nextInt();
                }
                quarterlySales[j] = new QuarterlySales(numSales,revenues,j+1);
            }
            arr[i] = new SalesPerson(name,quarterlySales);
        }

        table(arr);
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());

    }
}