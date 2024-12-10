package arrays;

public class ArraySmallest {
    public static void main(String[] args) {
        int[] array = {7, 3, 64, 2, 49};
        int value = printSmallestElement(array);
        System.out.println("Smallest value : " + value);
    }

    static int printSmallestElement(int []arr) {
        int min = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }
}
