import java.util.Queue;
import java.util.LinkedList;

public class Tree{
    private Node root;
    private Node current;

    public Tree(int data) {
        root = new Node(data);
    }

    public Node getRoot() {
        return root;
    }

    public Tree() {
        root = null;
    }

    public void insert(Node current, int data){
        if (current == null){
            Node New = new Node(data);
        }
    }

    public void Preorder(Node root){
        if(root != null){
            System.out.println(root.getData());
            Preorder(root.getLeft());
            Preorder(root.getRight());
        }
    }

    public void Inorder(Node root){
        if(root != null){
            Inorder(root.getLeft());
            System.out.println(root.getData());
            Inorder(root.getRight());
        }
    }

    public void Postorder(Node root){
        if(root != null){
            Postorder(root.getLeft());
            Postorder(root.getRight());
            System.out.println(root.getData());
        }
    }

    public void Levels(Node root){
        if (root != null){
            Queue<Node> P = new LinkedList<Node>();
            P.add(root);

            while(P.size() > 0){
                Node current = P.poll();
                System.out.println(current.getData());

                if(current.getLeft() != null){
                    P.add(current.getLeft());
                }

                if(current.getRight() != null){
                    P.add(current.getRight());
                }
            }
        }
    }

}

