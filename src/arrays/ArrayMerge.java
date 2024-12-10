package arrays;

public class ArrayMerge {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {6, 7, 8, 9,10};
        merge(a, b);
    }

    static void merge(int[] arr1, int[] arr2) {
        int []output = new int[arr1.length + arr2.length];
        
        for(int i = 0; i < arr1.length; i++) {
            output[i] = arr1[i];
        }

        for(int i = 0; i < arr2.length; i++) {
            output[i + arr1.length] = arr2[i];
        }

        for (int i : output) {
            System.out.print(i + ", ");
        }
        System.out.print("\b\b.");
    }
}
