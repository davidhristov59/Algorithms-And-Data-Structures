package ListiDLL;

public class DLLNode<E> {

    protected E element;
    protected DLLNode<E> pred, succ;
    protected int num_appearances;

    public DLLNode(E element, DLLNode<E> pred, DLLNode<E> succ){
        this.element=element;
        this.pred = pred;
        this.succ = succ;
        this.num_appearances = 1;
    }

    @Override
    public String toString() {
        return "<-" + element.toString() + "->";
    }


}
