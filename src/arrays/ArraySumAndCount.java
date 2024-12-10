package arrays;

public class ArraySumAndCount {
    public static void main(String[] args) {
        int arr[] = {8, 5, 1, 2, 4, 8};

        sumAtEven(arr);
        sumAtOdd(arr);
    }

    static void sumAtEven(int a[]) {
        int sum = 0;
        int count = 0;
        for(int i = 0; i < a.length; i += 2) {
            sum += a[i];
            count++;
        }
        System.out.println("Sum of Elements at Even Position : " + sum);
        System.out.println("Elements present at Even Position : " + count);
    }

    static void sumAtOdd(int a[]) {
        int sum = 0;
        int count = 0;
        for(int i = 1; i < a.length; i += 2) {
            sum += a[i];
            count++;
        }
        System.out.println("Sum of Elements at Odd Position : " + sum);
        System.out.println("Elements present at Odd Position : " + count);
    }
}
