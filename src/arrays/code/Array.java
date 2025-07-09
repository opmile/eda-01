package arrays.code;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {

        // 01 - array of ten integers
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 01 - a) print elements of array
        System.out.println(Arrays.toString(nums));
        Fundamentals.printAll(nums);

        // 01 - b) calculate average
        Fundamentals.calculateAverage(nums);

        // 01 - c) how many elements are even
        Fundamentals.evenNumbers(nums);


        // 02 - positive, negative, zero
        int[] avaluateNums = {-2, -1, 0, 1, 2, 3};
        Fundamentals.avaluateNums(avaluateNums);

        // 03 - max and min value of array
        int[] maxMin = {-7, -19, 0, 21, 14, 26, -3, 0};
        System.out.println(Fundamentals.maxValue(maxMin));
        System.out.println(Fundamentals.minValue(maxMin));
        Fundamentals.maxMin(maxMin);

        // 04 - reverse array
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // (two pointers approach)
        Fundamentals.reverseArray(arr);
        System.out.println(Arrays.toString(arr));

        // (temp variable approach)
        Fundamentals.reverseArray2(arr);
        System.out.println(Arrays.toString(arr));

        // 05 - sum of two arrays
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};

        int[] sum = Fundamentals.sumArrays(arr1, arr2);
        System.out.println(Arrays.toString(sum));

        // 06 - remove all occurrences
        int[] arrOccurrences = {1, 1, 2, 3, 4, 1, 5, 1, 2, 3, 4, 5};
        int[] newArray = Manipulation.removeOccurrences(1, arrOccurrences);
        System.out.println(Arrays.toString(newArray));

        // 07 - rotate array d times to right (clockwise)
        int[] rotateArray = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(rotateArray));
        Manipulation.rotateArray(rotateArray, 2);
        System.out.println(Arrays.toString(rotateArray));

        // 08 - interpolate two same size arrays
    }
}