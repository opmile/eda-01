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

        // 08 - interpolate two arrays

        // 08.1 - same size
        int[] arrA = {1, 3, 5};
        int[] arrB = {2, 4, 6};
        int[] interpolatedArraySS = Manipulation.interpolateSameSizeArray(arrA, arrB);
        System.out.println(Arrays.toString(interpolatedArraySS));

        // 08.2 - different size
        int[] arrC = {1, 3, 5, 7, 9, 10};
        int[] arrD = {2, 4, 6, 8};
        int[] interpolatedArrayDS = Manipulation.interpolateDifferentSizeArray(arrC, arrD);
        System.out.println(Arrays.toString(interpolatedArrayDS));

        // 09 - finding second-largest element
        int[] secondLargest = {10, 20, 30, 100};
        System.out.println(Manipulation.secondLargestElement(secondLargest));

        // 10 - are them equal?
        int[] equal1 = {1, 2, 3};
        int[] equal2 = {1, 2, 3};
        System.out.println(Manipulation.areEqual(equal1, equal2));

        // 11 - remove duplicates
    }
}