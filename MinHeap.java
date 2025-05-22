import java.util.*;
public class MinHeap {
    private ArrayList<Integer> heap;
    public MinHeap(){
        heap=new ArrayList<>();
    }
    private int index=0;

    private int parent(int index){
         return (index-1)/2;
    }
    private int left(int index){
        return index*2+1;
   } 
   private int right(int index){
    return index*2+2;
} 
private void swap(int a,int b){ // this a and b should be the indexes
    int temp=heap.get(a);
    heap.set(a,heap.get(b));
    heap.set(b,temp);
}
 public void insert(int val){
     heap.add(val);
     upheap(index);
     index++;
    
    }  
    private void upheap(int index){
        if(index==0){
            return;
        }
        int p=parent(index);
        if(heap.get(index)<heap.get(p)){
            swap(index,p);
        }
        upheap(p);
    }
    //this will be returning min value
    public int remove(){
        if(heap.isEmpty()){
            return -1;
        }
      int min=heap.get(0);
      heap.set(0,heap.get(heap.size()-1));
      heap.remove(heap.size()-1);
      downheap(0);
      return min;
    }
    private void downheap(int index){
        int min=index;
        int left=left(index);
        int right=right(index);
        if(left<heap.size()&&heap.get(left)<heap.get(min)){
            min=left;
        }
        if(right<heap.size()&&heap.get(right)<heap.get(min)){
            min=right;
        }
           if(min!=index){//either of the children is the minimum
            swap(min,index);
            downheap(min);
           }
    }
    //heap sort
    public ArrayList<Integer> heapSort(){
        ArrayList<Integer> list=new ArrayList<>();
        while(!heap.isEmpty()){
            list.add(this.remove());
        }
        return list;
    }
    public static void main(String[] args) {
        MinHeap heap=new MinHeap();
        heap.insert(8);
        heap.insert(7);
        heap.insert(9);
        heap.insert(1);
        heap.insert(11);
        heap.insert(5);

       System.out.println( heap.heapSort());

    }
}
