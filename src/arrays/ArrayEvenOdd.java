package arrays;

public class ArrayEvenOdd {
    public static void main(String[] args) {
        int arr[] = {8, 5, 1, 2, 4, 71, 86, 53, 1003};

        sumOfEven(arr);
        sumOfOdd(arr);
    }

    static void sumOfEven(int a[]) {
        int sum = 0;
        int count = 0;

        for (int i : a) {
            if (i % 2 == 0) {
                sum += i;
                count++;
            }
        }
        System.out.println("Sum of Even Elements : " + sum);
        System.out.println("Number of Even Elements : " + count);
    }

    static void sumOfOdd(int a[]) {
        int sum = 0;
        int count = 0;

        for (int i : a) {
            if (i % 2 == 1) {
                sum += i;
                count++;
            }
        }
        System.out.println("Sum of Odd Elements : " + sum);
        System.out.println("Number of Odd Elements : " + count);
    }
}
