package arrays;

public class ArrayLargest {
    public static void main(String[] args) {
        int[] array = {7, 3, 64, 2, 49};
        int value = printLargestElement(array);
        System.out.println("Largest value : " + value);
    }

    static int printLargestElement(int []arr) {
        int max = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}
