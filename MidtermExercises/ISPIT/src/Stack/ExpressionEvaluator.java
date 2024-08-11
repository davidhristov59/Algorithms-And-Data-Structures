package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression){
        // Vasiot kod tuka

        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;

        String[] add = expression.split("\\+");

        for(String s : add){
            String[] multiplication = expression.split("\\*");
            int mult = 1;

            for(String str : multiplication){
                mult *= Integer.parseInt(str);
            }

            stack.add(mult);
        }

        while(!stack.isEmpty()){
            result += stack.pop();
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}