package arrays;

public class ArrayPalindrome {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 1};

        palindrome(arr);
    }

    static void palindrome(int a[]) {
        boolean isPalindrome = true;
        int n = a.length;

        for(int i = 0; i < n / 2; i++) {
            if (a[i] != a[n - i - 1]) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Palindrome.");
        } else {
            System.out.println("Not a Palindrome.");
        }
    }
}
