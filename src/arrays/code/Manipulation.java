package arrays.code;

public class Manipulation {

    // 06
    public static int[] removeOccurrences(int removeElement, int[] arr) {
        int occurrences = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == removeElement) {
                occurrences++;
            }
        }
        if (occurrences == 0) {
            System.out.println("nothing to remove");
            return arr;
        }

        int[] newArray = new int[arr.length - occurrences];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != removeElement) {
                newArray[j] = arr[i];
                j++;
            }
        }
        return newArray;
    }

    // 07
    public static void rotateArray(int[] arr, int d) {
        d %= arr.length;

        // reverse the entire array
        reverse(arr, 0, arr.length - 1);

        // reverse the first d elements
        reverse(arr, 0, d - 1);

        // reverse the remaining arr.length - d elements
        reverse(arr, d, arr.length - 1);
    }

    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    // 08

    // 08.1 arrays have the same size
    public static int[] interpolateSameSizeArray(int[] arr1, int[] arr2) {
        int[] newArray = new int[arr1.length + arr2.length];

        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            newArray[j++] = arr1[i];
            newArray[j++] = arr2[i];
        }
        return newArray;
    }

    // 08.2 arrays have different size
    public static int[] interpolateDifferentSizeArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] newArray = new int[len1 + len2];

        int min = Math.min(len1, len2);
        int j = 0;
        for (int i = 0; i < min; i++) {
            newArray[j++] = arr1[i];
            newArray[j++] = arr2[i];
        }

        for (int i = min; i < len1; i++) {
            newArray[j++] = arr1[i];
        }

        for (int i = min; i < len2; i++) {
            newArray[j++] = arr2[i];
        }

        return newArray;
    }
}
