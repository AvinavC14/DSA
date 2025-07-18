import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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
    //this is using levelsize ,levelsize tells us how many nodes are at each level
    //but u can perform bfs without using levesize 
   public List<List<Integer>> BFS_Travesal(){
     return BFS_Travesal(root);
   }
    private List<List<Integer>>BFS_Travesal(Node root){
    List<List<Integer>>list=new ArrayList<>();//this will storing the final answer
     if(root==null){
        return list;
     }
     Queue <Node> queue=new LinkedList<>();
     queue.offer(root);
     while(!queue.isEmpty()){ 
        //using this level size i will be knowing the number of nodes in a single level
       int levelSize=queue.size();
       List<Integer> list2 =new ArrayList<>();
       //the for loop for n times where n is the number of nodes in a single level
       for(int i=0;i<levelSize;i++){
  
        Node current=queue.poll();
        list2.add(current.val);

        if(current.left!=null){
            queue.offer(current.left);
        }
        
        if(current.right!=null){
            queue.offer(current.right);
        }
       }
     list.add(list2);
     }
     return list;
     
    }
    //BFS without using levelSize
    private List<Integer> BFS2(){
       return  BFS2(root);
    }
    private List<Integer> BFS2(Node root){
        List<Integer> list=new ArrayList<>();

        if(root==null){
          return list;
        }
        Queue<Node> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node currentNode=queue.poll();
            list.add(currentNode.val);
            if(currentNode.left!=null){
                queue.offer(currentNode.left);
            }
            
            if(currentNode.right!=null){
                queue.offer(currentNode.right);
            }

        }
        return list;
    }
    public static void main(String[] args) {
        BFS ob = new BFS();
        ob.insert(2);
        ob.insert(9);
        ob.insert(1);
        ob.insert(12);
        ob.insert(3);
        ob.insert(17);
        ob.insert(13);

    //    System.out.print(ob.BFS_Travesal());
       System.out.print(ob.BFS2());

    }
}
