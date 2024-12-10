package arrays;

public class ArraySecondMax {
    public static void main(String[] args) {
        int arr[] = {-8, -5, -31, -7, -53};

        int val =secondMax(arr);
        System.out.println("Second Max element is : " + val);
    }

    static int secondMax(int a[]) {
        int max = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;

        for(int i = 0; i < a.length; i++) {
            if(max < a[i]) {
                secondmax = max;
                max = a[i];
            } else if(secondmax < a[i] && max > a[i]) {
                secondmax = a[i];
            }
        }
        return secondmax;
    }
}
