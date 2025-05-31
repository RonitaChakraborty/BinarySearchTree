// Binary Search Tree(Inorder,Preorder,Postorder traversal)
// insertion,deletion and searching
class Node 
{
    int data;
    Node left, right;
    public Node(int item) 
    {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree 
{
    Node root;
    public BinarySearchTree() 
    {
        root = null;
    }

    // Insertion operation
    void insert(int data) 
    {
        root = ins_rec(root, data);
    }

    Node ins_rec(Node root, int data) 
    {
        if (root == null) 
        {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = ins_rec(root.left, data);
        else if (data > root.data)
            root.right = ins_rec(root.right, data);

        return root;
    }

    // Deletion operation
    void delete(int data) 
    {
        root = del_rec(root, data);
    }

    Node del_rec(Node root, int data) 
    {
        if (root == null)
            return root;

        if (data < root.data)
            root.left = del_rec(root.left, data);
        else if (data > root.data)
            root.right = del_rec(root.right, data);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);

            root.right = del_rec(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root) 
    {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // Search operation
    boolean search(int data) 
    {
        return search_rec(root, data);
    }

    boolean search_rec(Node root, int data) 
    {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        if (root.data < data)
            return search_rec(root.right, data);
        return search_rec(root.left, data);
    }

    // Inorder traversal
    void inorder() 
    {
        inorderRec(root);
        System.out.println("\n");
    }

    void inorderRec(Node root) 
    {
        if (root != null) 
        {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal
    void preorder() 
    {
        preorderRec(root);
        System.out.println("\n");
        
    }

    void preorderRec(Node root) 
    {
        if (root != null) 
        {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal
    void postorder() 
    {
        postorderRec(root);
        System.out.println("\n");
    }

    void postorderRec(Node root) 
    {
        if (root != null) 
        {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

}


public class TreeNode
{
    public static void main(String args[]) 
    {
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println('\u000C');
        System.out.println("------------------------");
        System.out.println("|  BINARY SEARCH TREE  |");
        System.out.println("------------------------");
        // Inserting elements
        tree.insert(15);
        tree.insert(30);
        tree.insert(45);
        tree.insert(60);
        tree.insert(75);
        tree.insert(90);
        tree.insert(105);
        tree.insert(120);
        tree.insert(135);
        tree.insert(150);
        tree.insert(165);

        System.out.println("INORDER TRAVERSAL( Left + Root + Right ):");
        tree.inorder();

        // Deleting elements
        tree.delete(60);
        tree.delete(75);

        System.out.println("Inorder traversal after deletion(60 and 75 deleted):");
        tree.inorder();

        // Searching for an element
        int search_data = 105;
        System.out.println("Is " + search_data + " present in the tree? " );
        System.out.println(tree.search(search_data));
        System.out.println( );
        // Traversals
        System.out.println("PREORDER TRAVERSAL ( Root + Left + Right ):"); // preorder traversal
        tree.preorder();

        System.out.println("POSTORDER TRAVERSAL ( Left + Right + Root ):"); // postorder raversal
        tree.postorder();
    }
}