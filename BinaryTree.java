//This is Binary Search Tree
import java.lang.Math;
public class BinaryTree {

    private class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
    private Node root;

    public void insert(int val) {
        root = insert(val, root);
    }
    
    public Node insert(int val, Node node) {
        if (node == null) {
            return new Node(val); 
        }
        
        if (val < node.val) {
            node.left = insert(val, node.left); 
        } else if (val > node.val) {
            node.right = insert(val, node.right); 
        }
        
        return node; 
    }
    
    public void display(){
        display(root,"RootNode :");
    }
    private void display(Node node,String message){
        if(node==null){
            return;
        }
        System.out.println(message+node.val);
        display(node.left,"the left of "+node.val+":");
        display(node.right,"the right of "+node.val+":");
    }
    //here i am just calculating the height of the root node 
    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node==null){
            return -1;
        }
       if(node.right ==null && node.left ==null){
        return 0;
       }
       return Math.max(height(node.left) +1,height(node.right)+1);
     }
    public static void main(String[]args){
        BinaryTree tree= new BinaryTree();
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);

        tree.display();
        int h=tree.height();
        System.out.println("The height of root node ="+h);

    }
}
