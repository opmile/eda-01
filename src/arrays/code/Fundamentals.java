package arrays.code;

public class Fundamentals {

    // 01
    public static void printAll(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void calculateAverage(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.println(sum / nums.length);
    }

    public static void evenNumbers(int[] nums) {
        int even = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                even++;
            }
        }
        System.out.println(even);
    }

    // 02
    public static void avaluateNums(int[] nums) {
        int positive = 0;
        int negative = 0;
        int zero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positive++;
            } else if (nums[i] < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        System.out.printf("""
                positive - %d; 
                negative - %d; 
                zero - %d
                """, positive, negative, zero);
    }

    // 03
    public static int maxValue(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max ) {
                max = nums[i];
            }
        }
        return max;
    }

    public static int minValue(int[] nums) {
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    public static void maxMin(int[] nums) {
        int max = 0;
        int min = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }

        System.out.printf("max value: %d; min value: %d \n", max, min);
    }

    // 04

    // 04.1 (two pointers approach)
    public static void reverseArray(int[] arr) {
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

    // 04.2 (temporary variable approach)
    public static void reverseArray2(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    // 05 - sum of two arrays
    public static int[] sumArrays(int[] arr1, int[] arr2) {
        int[] sum = new int[arr1.length];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = arr1[i] + arr2[i];
        }
        return sum;
    }
}
