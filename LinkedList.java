class LinkedList {
    Node head;

    private class Node {
        int val;
        Node next;

        // Constructor
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // insert method
    public void insert(int val) {
        if (head == null) {
            Node node = new Node(val);
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node node = new Node(val);
            temp.next = node;
        }
    }
   public Node delete(int val){
    Node temp=head;
    Node prev= new Node(0);
    prev.next=temp;
    while(temp.val!=val){
        temp=temp.next;
        prev=prev.next;       
    }
      prev.next=temp.next;
      return temp;
   }
    // display method
    public void display() {
        Node temp = head;
        while (temp != null) {
            if(temp.next==null){
                System.out.print(temp.val);
                temp = temp.next;
            }
            else{
            System.out.print(temp.val + "-->");
            temp = temp.next;
            }
        }
    }
    //Main Function
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(7);
        list.insert(8);
        list.insert(5);
        list.insert(9);
        list.insert(10);
        list.insert(11);

        list.delete(9);
        list.display();

    }
}