import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int arr[] = { 5, 4, 7, 1 };
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j - 1]) {
                    // swap
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

}
