package arrays.code;

import java.util.Arrays;

public class Review101 {
    // 01 - second higher element
    public static int secondHigher(int[] arr) {
        int higher = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (higher < arr[i]) {
                higher = arr[i];
            }
        }

        int secondHigher = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (secondHigher < arr[i] && arr[i] != higher) {
                secondHigher = arr[i];
            }
        }
        return secondHigher;
    }

    // 02 - reverse array
    public static void reverseArr(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    // 03 - remove all occurrences
    public static int[] removeOccurrences(int[] arr, int n) {
        int occurrences = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                occurrences++;
            }
        }

        int[] newArr = new int[arr.length - occurrences];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != n) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }

    public static int[] removeOccurrences2(int[] arr, int n) {
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != n) {
                arr[counter] = arr[i];
                counter++;
            }
        }

        int[] newArray = new int[counter];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }

    // 04 - rotate array
    public static void reverseFrom(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void rotateArr(int[] arr, int k) {
        int n = arr.length - 1;

        k %= n;

        // reverse all array
        reverseFrom(arr, 0, n);

        // reverse first part - 0 to k
        reverseFrom(arr, 0, k - 1);

        // reverse second part = from k to n
        reverseFrom(arr, k, n);
    }

    // 05 - interpolate two arrays in one

    // same size
    public static int[] interpolateSameSize(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length * 2];

        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr[j++] = arr1[i];
            arr[j++] = arr2[i];
        }
        return arr;
    }

    // different size
    public static int[] interpolateDiffSize(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] arr = new int[len1 + len2];

        int min = Math.min(len1, len2);

        int j = 0;
        for (int i = 0; i < min; i++) {
            arr[j++] = arr1[i];
            arr[j++] = arr2[i];
        }

        // for arr1
        for (int i = min; i < arr1.length; i++) {
            arr[j++] = arr1[i];
        }

        // for arr2
        for (int i = min; i < arr2.length; i++) {
            arr[j++] = arr2[i];
        }

        return arr;
    }

    // 06 - is palindrome?
    public static boolean isPalindrome(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) return false;

            left++;
            right--;
        }
        return true;
    }

    public static int matrixPalindromes(int[][] matrix) {
        int count = matrix.length;

        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[i].length - 1;

            while (left < right) {
                if (matrix[i][left] != matrix[i][right]) count--;

                left++;
                right--;
            }
        }
        return count;
    }

    // 07 - interval sum
    public static int sum(int k) {
        if (k == 0) {
            return 0;
        } else {
            return k + sum(k - 1);
        }
    }

    // 08 - fatorial
    public static int fatorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fatorial(n - 1);
        }
    }

    // 09 - generate primes
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int[] generatePrimes(int quantity) {
        int[] primes = new int[quantity];
        int number = 2;

        for (int i = 0; i < quantity; number++) {
            if (isPrime(number)) {
                primes[i++] = number;
            }
        }
        return primes;
    }

    // 10 - shift all zeros to end
    public static void shiftZeros(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }

        while (count < arr.length) {
            arr[count++] = 0;
        }
    }

    // 11 - remove duplicates
    public static int[] removeDuplicates(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = 0; j < count; j++) {
                if (arr[i] == arr[j]) break;
            }

            if (j == count) {
                arr[count++] = arr[i];
            }
        }

        int[] noDuplicates = new int[count];
        for (int i = 0; i < count; i++) {
            noDuplicates[i] = arr[i];
        }
        return noDuplicates;
    }

    public static void shiftZerosBySwap(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;

                count++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(secondHigher(arr));

        reverseArr(arr);
        System.out.println(Arrays.toString(arr));

        int[] occurrences = {1, 1, 2, 3, 4, 1, 5, 6, 1, 7};
        System.out.println(Arrays.toString(removeOccurrences(occurrences, 1)));
        System.out.println(Arrays.toString(removeOccurrences2(occurrences, 1)));

        int[] rotate = {1, 2, 3, 4, 5, 6};
        rotateArr(rotate, 2);
        System.out.println(Arrays.toString(rotate));

        int[] palindrome = {1, 2, 3, 2, 1};
        System.out.println(isPalindrome(palindrome));

        int[][] matrix = {
                {1, 2, 1},
                {3, 2, 1},
                {7, 1, 7}
        };
        System.out.println(matrixPalindromes(matrix));

        System.out.println(sum(10));
        System.out.println(fatorial(5));

        int[] primes = generatePrimes(5);
        System.out.println(Arrays.toString(primes));
    }
}
