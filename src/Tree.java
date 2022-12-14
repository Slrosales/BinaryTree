import java.util.Queue;
import java.util.LinkedList;

public class Tree{
    public Node root;

    public Tree(int data) {
        root = new Node(data);
    }

    public Tree() {
        root = null;
    }

    public void insert(int data){

        Node current = root;
        Node P = new Node(data);
        while (true){

            if (data < current.getData()){
                if (current.getLeft() != null){
                    current = current.getLeft();
                } else {
                    current.setLeft(P);
                    return;
                }
            } else if (data > current.getData()){
                if (current.getRight() != null){
                    current = current.getRight();
                } else {
                    current.setRight(P);
                    return;
                }
            }
        }

    }

    public Node Delete(Node root, int data){
            if (root == null) return null;

            //Recursive movement through the tree branches
            if (data < root.getData()){
                root.setLeft(Delete(root.getLeft(), data));
            } else if (data > root.getData()) {
                root.setRight(Delete(root.getRight(), data));
            } else{
                //Deleting the target
                if (root.getLeft() == null & root.getRight() == null){
                    root = null;
                }else if(root.getRight() != null){
                    root.setData(successor(root));
                    root.setRight(Delete(root.getRight(), root.getData()));
                } else{
                    root.setData(predecessor(root));
                    root.setLeft(Delete(root.getLeft(), root.getData()));
                }
            }
            return root;
    }

    private int successor(Node root){
        root = root.getRight();
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root.getData();
    }

    private int predecessor(Node root){
        root = root.getLeft();
        while (root.getRight() != null){
            root = root.getRight();
        }
        return root.getData();
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
    
    public void levelNode(Node root, int nivel){
        if (root != null){
            if (nivel == 0){
                System.out.println(root.getData());
            }else{
                levelNode(root.getLeft(), nivel -1);
                levelNode(root.getRight(), nivel -1);
            }
        }
        
    }
    
    public int Sum(Node root){
        if(root != null){
            int izq = Sum(root.getLeft());
            int der = Sum(root.getRight());
            return root.getData() + izq + der;
        }  
        return 0;
    }
    
    public int height(Node root){
        if (root != null) {
            return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
        }
        return 0;
    }
    
    public boolean Balance(Node root){
        if (root != null){
            int izq = height(root.getLeft());
            int der = height(root.getRight());
            
            if (-1 > (der - izq) || (der - izq) > 1){
                
                return false;
            } else{
                return true;
            }
        }
        return true;
    }
    
    public boolean ABB(Node root){
        if (root != null){
            
            if (root.getLeft()!= null && root.getData() < root.getLeft().getData()){
                return false;
            }
            
            if (root.getRight()!= null && root.getData() > root.getRight().getData()){
                System.out.println(root.getRight().getData());

                return false;
            }
            
            ABB(root.getLeft());
            ABB(root.getRight());
            
        }
        
        return true;
    }

}

