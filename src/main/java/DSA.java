import java.util.HashMap;
import java.util.Scanner;

public class DSA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a method to test:");
        System.out.println("1. Binary Search");
        System.out.println("2. Find Mode");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            // Test binarySearch
            System.out.print("Enter number of elements in array: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter " + n + " sorted integers:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.print("Enter target to search: ");
            int target = scanner.nextInt();
            int result = binarySearch(arr, target);
            System.out.println("Index of " + target + ": " + result);
        } else if (choice == 2) {
            // Test findMode
            System.out.print("Enter number of elements in array: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int mode = findMode(arr);
            System.out.println("Mode of the array: " + mode);
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    // This method performs a binary search on a sorted array.
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
        // The result is the index of the target element if found, otherwise -1.
    }

    // This method finds the mode of an array, which is the element that appears most frequently.
    public static int findMode(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int mode = arr[0];
        int maxCount = 0;

        for (int num : arr) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);

            if (count > maxCount) {
                maxCount = count;
                mode = num;
            }
        }
        return mode;
    }
}