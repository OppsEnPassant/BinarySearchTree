class Node {

    int id;
    String name;
    Node left, right;

    public Node() {

        id = 0;
        name = "";
        left = null;
        right = null;
    }


    public Node(int id, String name, Node left, Node right) {
        this.id = id;
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}









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


    // Copied from "Java program for Searching in Binary Search Tree" example on FavTutor
    public boolean search(int id) {
        return searchRecursive(root, id);
    }

    private boolean searchRecursive(Node root, int id) {
        if (root == null) {
            return false;
        } else if (root.id == id) {
            return true;
        } else if (id < root.id) {
            return searchRecursive(root.left, id);
        } else {
            return searchRecursive(root.right, id);
        }
    }


    public void insert(int id, String name) {
        this.root = insertRecursive(root, id, name);
    }

    private Node insertRecursive(Node root, int id, String name) {
        if (root == null) {
            return new Node(id, name, null, null);
        }

        if (id <= root.id) {
            root.left = insertRecursive(root.left, id, name);
        } else {
            root.right = insertRecursive(root.right, id, name);
        }

        return root;
    }


    // Prompt from ChatGPT, the whole 'delete' method code
    public void delete(int id) {
        root = deleteRecursive(root, id);
    }

    private Node deleteRecursive(Node root, int id) {
        if (root == null)
            return root;

        if (id < root.id)
            root.left = deleteRecursive(root.left, id);
        else if (id > root.id)
            root.right = deleteRecursive(root.right, id);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.id = minValue(root.right);
            root.name = findNode(root.right, root.id).name;

            root.right = deleteRecursive(root.right, root.id);
        }
        return root;
    }

    private int minValue(Node root) {
        int minv = root.id;
        while (root.left != null) {
            minv = root.left.id;
            root = root.left;
        }
        return minv;
    }

    private Node findNode(Node root, int id) {
        if (root == null || root.id == id)
            return root;

        if (id < root.id)
            return findNode(root.left, id);
        else
            return findNode(root.right, id);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();


        bst.insert(41, "notes");
        bst.insert(11, "personal");
        bst.insert(61, "work");
        bst.insert(30, "shopping");
        bst.insert(5, "recipes");
        bst.insert(55, "proposal");
        bst.insert(70, "thesis");


        System.out.println("Is ID 70 present in the BST? " + bst.search(70));


        bst.delete(40);
        System.out.println("Is ID 70 present in the BST after deletion? " + bst.search(40));
    }
}
