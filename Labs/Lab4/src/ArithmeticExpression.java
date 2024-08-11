import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExpression {

    // funkcija za presmetuvanje na izrazot pocnuvajki
    // od indeks l, zavrsuvajki vo indeks r
    static int presmetaj(char c[], int l, int r) {

        if(l == r){
            return Character.getNumericValue(c[l]);
        }

        int numA = 0;
        int numB = 0;
        int operator = -1;

        if(c[l] == '(' && c[r] == ')'){
            return presmetaj(c,l+1,r-1);
        }

        for (int i = l + 1; i < r; i++) {
            if(c[i] == '+' || c[i] == '-'){
                numA = presmetaj(c,l,i-1);
                numB = presmetaj(c,i+1,r);
                operator = i;
                break;
            }
        }

        if(operator == -1){
            if(c[operator] == '+') {
                return numA+numB;
            }
            else if(c[operator] == '-'){
                return numA - numB;
            }
        }

        return Character.getNumericValue(c[l]);
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length-1);
        System.out.println(rez);

        br.close();

    }

}
