class BinarySearchTree {
    
    int size;
    Node root;

    public BinarySearchTree() {
        size = 0;
        root = null;
    }

    public BinarySearchTree(int size, Node root) {
        this.size = size;
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public Node getRoot() {
        return root;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}

   