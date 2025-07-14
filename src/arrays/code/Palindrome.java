package arrays.code;

public class Palindrome {
    public static int matrixPalindrome(int[][] arr) {
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            int left = 0;
            int right = arr[i].length - 1;
            boolean isPalindrome = true;

            while (left < right) {
                if (arr[i][left] != arr[i][right]) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 1},
                {3, 2, 1},
                {7, 8, 7}
        };
        System.out.println(matrixPalindrome(matrix));
    }
}
