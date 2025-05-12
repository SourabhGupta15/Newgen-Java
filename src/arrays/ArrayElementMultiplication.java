package arrays;

public class ArrayElementMultiplication {
    public static void main(String[] args) {
        int[] array = {7, 3, 6, 2, 4};
        int value = multiplication(array);
        System.out.println("Final Product : " + value);
    }

    static int multiplication(int []arr) {
        int product = 1;

        for(int i = 0; i < arr.length; i++) {
            product = product * arr[i];
        }

        return product;
    }
}
