import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DSATest {

    @Test
    void testBinarySearchFound() {
        // Arrange
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 5;

        // Act
        int result = DSA.binarySearch(arr, target);

        // Assert
        assertEquals(2, result); // 5 is at index 2
    }

    @Test
    void testBinarySearchNotFound() {
        // Arrange
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 6;

        // Act
        int result = DSA.binarySearch(arr, target);

        // Assert
        assertEquals(-1, result); // 6 is not in the array
    }

    @Test
    void testBinarySearchFirstElement() {
        // Arrange
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 1;

        // Act
        int result = DSA.binarySearch(arr, target);

        // Assert
        assertEquals(0, result); // 1 is at index 0
    }

    @Test
    void testBinarySearchLastElement() {
        // Arrange
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 11;

        // Act
        int result = DSA.binarySearch(arr, target);

        // Assert
        assertEquals(5, result); // 11 is at index 5
    }

    @Test
    void testBinarySearchEmptyArray() {
        // Arrange
        int[] arr = {};
        int target = 5;

        // Act
        int result = DSA.binarySearch(arr, target);

        // Assert
        assertEquals(-1, result); // Empty array should return -1
    }

    @Test
    void testBinarySearchOneElement() {
        // Arrange
        int[] arr = {5};

        // Act & Assert
        assertEquals(0, DSA.binarySearch(arr, 5)); // Found
        assertEquals(-1, DSA.binarySearch(arr, 4)); // Not found
    }

    @Test
    void testFindModeSingleMode() {
        // Arrange
        int[] arr = {1, 2, 2, 3, 4, 2};

        // Act
        int mode = DSA.findMode(arr);

        // Assert
        assertEquals(2, mode); // 2 appears three times, which is most frequent
    }

    @Test
    void testFindModeAllSameValues() {
        // Arrange
        int[] arr = {7, 7, 7, 7};

        // Act
        int mode = DSA.findMode(arr);

        // Assert
        assertEquals(7, mode); // All values are 7
    }

    @Test
    void testFindModeTwoModes() {
        // Arrange - in case of tie, should return first encountered
        int[] arr = {1, 2, 2, 3, 3, 4};

        // Act
        int mode = DSA.findMode(arr);

        // Assert
        // Both 2 and 3 appear twice, but 2 is encountered first
        assertEquals(2, mode);
    }

    @Test
    void testFindModeSingleElement() {
        // Arrange
        int[] arr = {5};

        // Act
        int mode = DSA.findMode(arr);

        // Assert
        assertEquals(5, mode); // Only one element
    }

    @Test
    void testFindModeNegativeNumbers() {
        // Arrange
        int[] arr = {-1, -2, -1, -3, -4, -1};

        // Act
        int mode = DSA.findMode(arr);

        // Assert
        assertEquals(-1, mode); // -1 appears three times
    }
}