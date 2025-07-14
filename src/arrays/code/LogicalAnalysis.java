package arrays.code;

import java.util.Arrays;

public class LogicalAnalysis {
    // 01 - verify if array is a palindrome
    public static boolean isPalindrome(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 02 - verify if sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }

    // 03 - generate n primes
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
                primes[i] = number;
                i++;
            }
        }
        return primes;
    }


    public static void main(String[] args) {
        // 01
        int[] nums = {1, 2, 3, 2, 1};
        System.out.println(isPalindrome(nums));

        // 02
        int[] sortedNums = {1, 2, 3, 4, 5, 6};
        System.out.println(isSorted(sortedNums));

        // 03
        int[] primes = generatePrimes(10);
        System.out.println(Arrays.toString(primes));

        // 04
    }
}
