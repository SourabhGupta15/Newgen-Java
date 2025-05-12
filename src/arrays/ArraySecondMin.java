package arrays;

public class ArraySecondMin {
    public static void main(String[] args) {
        int arr[] = {-8, -5, -31, -7, -53};

        int val = secondMin(arr);
        System.out.println("Second Max element is : " + val);
    }

    static int secondMin(int a[]) {
        int min = Integer.MAX_VALUE;
        int secondmin = Integer.MAX_VALUE;

        for(int i = 0; i < a.length; i++) {
            if(min > a[i]) {
                secondmin = min;
                min = a[i];
            } else if(secondmin > a[i] && min < a[i]) {
                secondmin = a[i];
            }
        }
        return secondmin;
    }
}
