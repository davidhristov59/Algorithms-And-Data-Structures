package ListiSLL;

public class CLLNode<E> {
    protected E data;
    protected CLLNode<E> successor;

    public CLLNode(E data) {
        this.data = data;
        this.successor = null;
    }
}
