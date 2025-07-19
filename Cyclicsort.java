import java.util.Arrays;
 class cyclicsort {
public static void main(String[]args){
    int a[]={4,5,1,2,3,6};
    cyclic(a);
    System.out.println(Arrays.toString(a));
}    



static void cyclic(int a[]){
for(int i=0;i<a.length;){
    int correctIndex = a[i]-1;
    if(i!=correctIndex){
     swap(a,i,correctIndex);
    }
    else if(a[i]==a[correctIndex]){
        i++;
    }

}
}


static void swap(int a[],int i,int c){
    int temp = a[i];
    a[i]=a[c];
    a[c]=temp;
}
 }