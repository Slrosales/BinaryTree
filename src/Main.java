public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(10);

        tree.insert(20);
        tree.insert(30);
        tree.insert(12);
        tree.insert(40);
        tree.insert(37);

        tree.Delete(tree.root, 37);


        System.out.println("Preorder");
        tree.Preorder(tree.root);
        System.out.println("\nInorder");
        tree.Inorder(tree.root);
        System.out.println("\nPostorder");
        tree.Postorder(tree.root);
        System.out.println("\nLevels");
        tree.Levels(tree.root);
    }
}