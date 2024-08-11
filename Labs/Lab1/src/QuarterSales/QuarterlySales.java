package QuarterSales;

public class QuarterlySales {

    private int numOfSales;
    private int [] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }

    public int sumRevenue(){ //suma od site prihodi ostvareni od dadeniot vraboten vo oddelot na prodazba vo kvartali
        int sum = 0;
        for (int revenue : revenues){
            sum += revenue;
        }
        return sum;
    }


    @Override
    public String toString() {
        return String.format("%d %d", quarterNo, sumRevenue());
    }

    public int getNumOfSales() {
        return numOfSales;
    }

    public int[] getRevenues() {
        return revenues;
    }

    public int getQuarterNo() {
        return quarterNo;
    }
}