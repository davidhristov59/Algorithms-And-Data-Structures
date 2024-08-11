package Listi.SLL;

import java.util.Scanner;

public class PutWordsTogetherIspitna {

    public static void putWordsTogether(SLL<String> list){

        SLLNode<String> tmp = list.getFirst();
        SLL<String> result = new SLL<>();
        StringBuilder stringBuilder = new StringBuilder();

        while(tmp != null){

            if(tmp.element.equals(",")){
                stringBuilder.append(tmp.element);
            }
            else {
                list.insertLast(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }

            tmp = tmp.succ;
        }

        list.insertLast(stringBuilder.toString());
    }

    public static void putWordsTogether2(SLL<String> list) {

        SLLNode<String> tmp = list.getFirst();
        StringBuilder stringBuilder = new StringBuilder();

        while(tmp != null){

            if(tmp.element.equals(",")){

                list.delete(tmp);
                tmp = tmp.succ;
            }
            else {
                tmp.element = tmp.element + tmp.succ.element;
                list.delete(tmp);
            }
        }

    }

    public static void putWordsTogether3(SLL<String> list){ //finalno

        SLLNode<String> tmp = list.getFirst();
        SLLNode<String> next = tmp.succ; //sledniot element zemi go/

        while(next != null){

            if(next.element.equals(",")){

                tmp = next.succ;
                list.delete(next);
                next = tmp.succ;
            }
            else{
                tmp.element += next.element;
                list.delete(next);
                tmp = tmp.succ;
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        SLL<String> list1 = new SLL<>();
        String inputLine = scan.nextLine();
        String[] elements = inputLine.split("\s+");

        for (String element : elements) {
            list1.insertLast(element);
        }

        System.out.println("Original list:");
        System.out.println(list1);

        System.out.println("Transformed list:");
        putWordsTogether(list1);
    }
}
