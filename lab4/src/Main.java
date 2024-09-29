public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>();
        tree.insert(3);
        tree.insert(5);
        tree.insert(2);
        tree.insert(17);
        tree.insert(8);
        tree.insert(7);
        tree.delete(5);
        tree.printLVR();
    }
}