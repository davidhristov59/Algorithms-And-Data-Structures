package ListiSLL;

public class CircularLinkedList<E>{

    private CLLNode<E> last;

    public CircularLinkedList(){
        this.last = null;
    }

    public void insertFirst(E o){
        CLLNode<E> newNode = new CLLNode<>(o);

        if(last == null){ //ako listata e prazna, noviot node ke stane i prv i posleden node vo listata
            last = newNode;
            newNode.successor = newNode; //Make it circular by pointing it to itself
        }
        else { //ako listata ne e prazna , go stava noviot node na pocetok
            newNode.successor = last.successor;
            last.successor = newNode;
        }
    }

}
