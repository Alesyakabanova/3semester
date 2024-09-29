public class Tree<T extends Comparable<T>> {
    private Node root;
    public class Node {
        public T value;
        public Node left;
        public Node right;
        public Node(T value) {
            this.value=value;
            left=right=null;
        }
    }
    private void insert(Node node, T value) {
        if(value.compareTo(node.value) < 0) {
            if(node.left == null) {
                node.left = new Node(value);
            }
            else insert(node.left, value);
        }
        else if(value.compareTo(node.value) > 0) {
            if(node.right == null) {
                node.right = new Node(value);
            }
            else insert(node.right, value);
        }
    }
    public void insert(T value) {
        if(root==null) {
            root=new Node(value);
        }
        else {
            insert(root,value);
        }
    }
    private Node search(Node node, T value) {
        if(node == null) return null;
        if (node.value == value) return node;
        if (value.compareTo(node.value) < 0) {
            return search(node.left, value);
        }
        else if (value.compareTo(node.value) > 0) {
            return search(node.left, value);
        }
        throw new RuntimeException("undefined behavior");
    }
    public Node search(T value) {
        return search(root, value);
    }
    private Node delete(Node node, T value) {
        if(node==null) return null;
        else if(value.compareTo(node.value) < 0) {
            node.left=delete(node.left, value);
            return node;
        }
        else if(value.compareTo(node.value) > 0) {
            node.right=delete(node.right, value);
            return node;
        }
        if(node.right==null && node.left != null) {
            return node.left;
        }
        else if(node.right!=null && node.left == null) {
            return node.right;
        }
        else if (node.right==null && node.left==null) {
            return null;
        }
        else {
            Node f = getMin(node.right);
            f.right = node.right;
            f.left=node.left;
            return f;
        }
    }
    public void delete(T value) {
        delete(root, value);
    }
    private Node getMax(Node node){
        if(node.right==null) {
            return node;
        }
        return getMax(node.right);
    }
    private Node getMin(Node node){
        if(node.left==null) {
            return node;
        }
        return getMin(node.left);
    }
    private void printLVR(Node node){
        if(node==null) return;
        printLVR(node.left);
        System.out.println(node.value);
        printLVR(node.right);
    }
    public void printLVR() {
        printLVR(root);
    }
    private void printLRV(Node node){
        if(node==null) return;
        printLRV(node.left);
        printLRV(node.right);
        System.out.println(node.value);
    }
    public void printLRV() {
        printLRV(root);
    }
    private void printVLR(Node node){
        if(node==null) return;
        System.out.println(node.value);
        printVLR(node.left);
        printVLR(node.right);
    }
    public void printVLR() {
        printVLR(root);
    }
}
