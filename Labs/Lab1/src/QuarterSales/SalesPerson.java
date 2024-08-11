package QuarterSales;

public class SalesPerson{

    private String name;
    private QuarterlySales [] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }

    @Override
    public String toString() {
        return String.format("%s %d", name, sumTotalRevenue());
    }

    public int sumTotalRevenue(){
        int sum = 0;
        for(QuarterlySales quarterlySales:quarters){ //од сите квартали, листа низ сите квартали
            sum += quarterlySales.sumRevenue(); //ќе го врати работникот со најголем остварен приход (од сите квартали).
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public QuarterlySales[] getQuarters() {
        return quarters;
    }
}