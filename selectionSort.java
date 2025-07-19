import java.util.Arrays;
class dsa22 {
    public static void main(String[] args){
     int arr[]={4,3,6,2,1};
     selection(arr);
     System.out.println(Arrays.toString(arr));

    }

    static void selection(int arr []){
        for(int i = 0 ; i<arr.length; i++){
            int last = arr.length - i -1;
            int maxindex = getmax(arr,0,last);
            swap(arr,maxindex,last);
        }
    }

    static void swap(int [] arr,int num1 , int num2){
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    static int getmax(int [] arr,int start, int end){
        int max = start;
        for (int i =0; i<=end;i ++){
         if (arr[max]<arr[i]){
            max =i;
         }
         
        }
        return max;
    }
}
