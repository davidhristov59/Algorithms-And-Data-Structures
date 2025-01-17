public class BinarySearchTree<E extends Comparable<E>> {

    private BNode<E> root;
    public BinarySearchTree() {
        root = null;
    }

    private BNode<E> insert(E x, BNode<E> t) {
        if (t == null) {
            t = new BNode<E>(x, null, null);
        } else if (x.compareTo(t.info) < 0) {
            t.left = insert(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            t.right = insert(x, t.right);
        } else;  // Duplicate; do nothing
        return t;
    }
    public void insert(E x) {
        root = insert(x, root);
    }

    private BNode<E> findMin(BNode<E> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t; }
        return findMin(t.left);
    }
//    public E findMin() {
//        return elementAt(findMin(root));
//    }
    private BNode<E> findMax(BNode<E> t) {
        if (t == null) {
            return null;
        } else if (t.right == null) {
            return t; }
        return findMax(t.right);
    }
//    public E findMax() {
//        return elementAt(findMax(root));
//    }

    private BNode<E> find(E x, BNode<E> t) {
        if (t == null)
            return null;
        if (x.compareTo(t.info) < 0) {
            return find(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            return find(x, t.right);
        } else {
            return t;    // Match
        } }

    public BNode<E> find(E x) {
        return find(x, root);
    }
    private BNode<E> remove(Comparable x, BNode<E> t) {
        if (t == null)
            return t; // Item not found; do nothing
        if (x.compareTo(t.info) < 0) {
            t.left = remove(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) { // Two children
            t.info = findMin(t.right).info;
            t.right = remove(t.info, t.right);
        } else {
            if (t.left != null)
                return t.left;
            else
                return t.right;
        }
        return t; }
    public void remove(E x) {
        root = remove(x, root);
    }

}