
import java.util.Arrays;

/**
 * Demonstrates different sorting algorithms, including Quick Sort
 * and Merge Sort.
 *
 * @author Lara Shihadeh
 * @version 1.0
 */
public class SortExample {

    /**
 * Creates a new SortExample instance.
 */
public SortExample() {
}

    /**
     * The main method demonstrates the Quick Sort and Merge Sort
     * algorithms using sample arrays.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // Unsorted Integer array
        Integer[] array1 = {12, 13, 24, 10, 3, 6, 90, 70};

        // Unsorted integer array
        int[] array2 = {2, 6, 3, 5, 1};

        // Sort using Quick Sort
        quickSort(array1, 0, array1.length - 1);

        // Display the sorted array
        System.out.println(Arrays.toString(array1));

        // Sort using Merge Sort
        mergeSort(array2, array2.length);

        // Display the sorted array
        System.out.println(Arrays.toString(array2));
    }

    /**
     * Sorts an Integer array using the Quick Sort algorithm.
     *
     * @param arr the array to be sorted
     * @param low the starting index of the sorting range
     * @param high the ending index of the sorting range
     */
    public static void quickSort(Integer[] arr, int low, int high) {

        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low;
        int j = high;

        while (i <= j) {

            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(arr, low, j);
        }

        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * Swaps two elements in an Integer array.
     *
     * @param array the array containing the elements
     * @param x the index of the first element
     * @param y the index of the second element
     */
    public static void swap(Integer[] array, int x, int y) {

        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Sorts an integer array using the Merge Sort algorithm.
     *
     * @param a the array to be sorted
     * @param n the number of elements to be sorted
     */
    public static void mergeSort(int[] a, int n) {

        if (n < 2) {
            return;
        }

        int mid = n / 2;

        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }

        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    /**
     * Merges two sorted subarrays into one sorted array.
     *
     * @param a the original array that stores the merged result
     * @param l the left sorted subarray
     * @param r the right sorted subarray
     * @param left the number of elements in the left subarray
     * @param right the number of elements in the right subarray
     */
    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right) {

            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        while (i < left) {
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /**
     * Checks whether an integer array is sorted in ascending order.
     *
     * @param x the array to be checked
     * @return true if the array is sorted, otherwise false
     */
    private static boolean isSorted(int[] x) {

        for (int i = 0; i < x.length - 1; i++) {

            if (x[i] > x[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
