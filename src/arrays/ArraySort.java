package arrays;

public class ArraySort {
    public static void main(String[] args) {
        int a[] = {8, 5, 1, 2, 4};
        
        sortByAscending(a);
        System.out.print("Ascending order : ");
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println("\b\b.");
        
        sortByDescending(a);
        System.out.print("Descending order : ");
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println("\b\b.");
    }

    static void sortByAscending(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 1 + i; j < arr.length; j++) {
                int temp = arr[i];
                if(temp > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void sortByDescending(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 1 + i; j < arr.length; j++) {
                int temp = arr[i];
                if(temp < arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
