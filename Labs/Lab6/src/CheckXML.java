import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;


public class CheckXML {

    public static int checkValidity(String[] redovi, int n){
        Stack<String> stack = new Stack<>();

       for(int i=0;i<n;i++){

           //[tag] [/tag]
           if(redovi[i].charAt(0) == '['){ // Proveruva dali e tag, ako pocnuva so [
               if(redovi[i].charAt(1) == '/'){ //Ako e [/tag] go sporeduva so tagot najgore sto e na stack-ot za proverka
                   if(!stack.peek().equals(redovi[i].substring(2, redovi[i].length() - 1))){ //
                       return 0;
                   }
                   else { //ako se sovpagaat tagovite , izvadi go od stack
                       stack.pop();
                   }
               }
               else { //ako E opening tag [TAG] ke go zeme toa sto pisuva vnatre vo tagot i ke go pushne vo stackot
                   stack.push(redovi[i].substring(1, redovi[i].length() - 1));
               }
           }
       }
        return 1;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String [] redovi = new String[n];

        for(int i=0;i<n;i++)
            redovi[i] = br.readLine();

        int valid = checkValidity(redovi,n);

        System.out.println(valid);

        br.close();
    }
}