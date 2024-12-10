package arrays;

public class ArrayPrint {
    public static void main(String[] args) {
        int[] array = {7, 3, 6, 2, 4};
        printArray(array);
    }

    static void printArray(int []arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
