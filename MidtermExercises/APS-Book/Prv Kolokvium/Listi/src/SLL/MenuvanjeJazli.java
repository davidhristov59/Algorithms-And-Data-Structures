package SLL;

public class MenuvanjeJazli {

    public boolean changeDirections(SLL<Integer> list){

        SLLNode<Integer> tmp = list.getFirst();

        while(tmp != null && tmp.succ != null) {

            Integer pom = tmp.element; //mora da zemam Integer bidejki cuvam Integeri vo SLLNode, ne int
            tmp.element = tmp.succ.element; //segasniot element ke go zameni so sledniot element . pr --> prviot element ke go zameni sos vtoriot element i taka natamu
            tmp.succ.element = pom;

            tmp = tmp.succ.succ; //dvizi succ za 2 pozicii napred vo listata , pominuvajki go sledniot node bidejki e vise swapnat
        }

        return false;
    }

    public static void main(String[] args) {


        MenuvanjeJazli menuvanjeJazli = new MenuvanjeJazli();
        SLL<Integer> sll = new SLL<Integer>();

        sll.insertLast(4);
        sll.insertLast(3);
        sll.insertLast(2);
        sll.insertLast(1);

        System.out.println(menuvanjeJazli.changeDirections(sll));

    }
}
