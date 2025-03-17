// Saw this similar type of Java Node Example on Java Code Geeks but it had different method and argument names


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
