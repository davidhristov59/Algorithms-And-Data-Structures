class BNode<E> {

    public E info;
    public BNode<E> left;
    public BNode<E> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode() {
        this.info = null;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

}

class BTree<E extends Comparable<E>> {

    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode<E>(elem);
    }

    public void makeRootNode(BNode<E> node) {
        root = node;
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {

        BNode<E> tmp = new BNode<E>(elem);

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    //---------------------------------------------------------------------------
    public int sumLeftSubTree(BNode<E> node, E value){ //jazol i vrednost

        if(node == null){
            return 0;
        }

        int sum = sumLeftSubTree(node.left,value);

        if(node.info.compareTo(value) < 0 ){ //збирот на елементите во неговото лево поддрво кои се помали од него
            sum += (Integer) node.info;
        }

        //ako ne togas desnoto poddrvo
        sum += sumLeftSubTree(node.right, value);

        return sum;
    }

    public int sumRightSubTree(BNode<E> node, E value){

        if(node == null){
            return 0;
        }

        int sum = sumRightSubTree(node.left, value);

        if(node.info.compareTo(value) > 0){ //збирот на елементите во неговото десно поддрво кои се поголеми од него.
            sum += (Integer) node.info;
        }

        sum += sumRightSubTree(node.right, value);

        return sum;
    }

    public void printSubTrees(BNode<E> node, E value){

        int leftSum = sumLeftSubTree(node.left, value);
        int rightSum = sumRightSubTree(node.right, value);

        System.out.print(leftSum + " " + rightSum);
    }

    //---------------------------------------------------------------------------

    public void PreorderNonRecursive() {

        if(root == null){
            return;
        }

        Stack<BNode<E>> stack = new ArrayStack<>(100);
        stack.push(root);

        while (!stack.isEmpty()){

            BNode<E> node = stack.pop();
            System.out.print(node.info + " "); //za sekoj posebno ke pecati

            if(node.right != null){ //korenot vise ni e vo stack-ot nie sega treba desnoto dete pa levoto dete da gi insertame
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    public void PostOrderNonRecursive() {

        if(root == null){
            return;
        }

        Stack<BNode<E>> stack = new ArrayStack<>(100);
        Stack<BNode<E>> stack2 = new ArrayStack<>(100);

        stack.push(root);

        while(!stack.isEmpty()){
            BNode<E> node = stack.pop();
            stack2.push(node);

            if(node.left != null){
                stack.push(node.left);
            }

            if(node.right != null){
                stack.push(node.right);
            }
        }

        while(!stack2.isEmpty()){
            BNode<E> node = stack2.pop();
            System.out.print(node.info + " ");
        }
    }

    public void InOrderNonRecursive(){

        if(root == null){
            return;
        }

        Stack<BNode<E>> stack = new ArrayStack<>(100);
        BNode<E> current = root;

        while(current != null || !stack.isEmpty()){
            while(current != null){

                stack.push(current); //root-ot push go
                current = current.left; //site levi deca stavi gi vo stack-ot dodeka pravi update na current
                //levoto poddrvo
            }

            current = stack.pop(); //vadi gi od stack-ot
            System.out.println(current.info + " ");

            current = current.right; //dvizi go desnoto poddrvo so update na current na desnoto dete
        }

    }

    //---------------------------------------------------------------------------


}
