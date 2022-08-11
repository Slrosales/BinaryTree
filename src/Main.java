public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(10);

        Node n20 = new Node(20);
        Node n30 = new Node(30);
        Node n40 = new Node(40);
        Node n50 = new Node(50);

        tree.getRoot().setLeft(n20);
        tree.getRoot().setRight(n30);

        n20.setLeft(n40);
        n20.setRight(n50);

        System.out.println("Preorder");
        tree.Preorder(tree.getRoot());
        System.out.println("\nInorder");
        tree.Inorder(tree.getRoot());
        System.out.println("\nPostorder");
        tree.Postorder(tree.getRoot());
        System.out.println("\nLevels");
        tree.Levels(tree.getRoot());
    }
}