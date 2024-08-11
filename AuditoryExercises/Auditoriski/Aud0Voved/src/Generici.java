import java.util.ArrayList;
import java.util.List;

public class Generici {

//        List<String> list = new ArrayList<String>();

    static class GenericsTest<T>{

        private T data;

        public GenericsTest(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    public static void main(String[] args) {

        GenericsTest<Integer> integerGenericsTest = new GenericsTest<Integer>(5);
        System.out.println("Generic Class returns: " + integerGenericsTest.getData());

        GenericsTest<String> stringGenericsTest = new GenericsTest<String>("David Hristov");
        System.out.println("Generic Class returns: " + stringGenericsTest.getData());


    }

}
