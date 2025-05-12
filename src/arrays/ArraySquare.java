package arrays;

public class ArraySquare {
    public static void main(String[] args) {
        int[] array = {7, 3, 6, 2, 4};
        squareOfElement(array);
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    static void squareOfElement(int []arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
    }
}
