package Problems;

public class FindSecondLargestFromEvenIndex {
    public static int findSecondLargestFromEvenIndex(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }

        Integer largest = null;
        Integer secondLargest = null;

        for (int i = 0; i < arr.length; i += 2) { // Iterate over even indices
            int current = arr[i];

            if (largest == null || current > largest) {
                secondLargest = largest;
                largest = current;
            } else if ((secondLargest == null || current > secondLargest) && current != largest) {
                secondLargest = current;
            }
        }

        if (secondLargest == null) {
            throw new IllegalArgumentException("No second largest element found at even indices.");
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("Second largest from even indices: " + findSecondLargestFromEvenIndex(arr1)); // Output: 4

        int[] arr2 = {10, 20, 30, 40, 50};
        System.out.println("Second largest from even indices: " + findSecondLargestFromEvenIndex(arr2)); // Output: 30

        int[] arr3 = {5, 3, 5, 2, 5};
        System.out.println("Second largest from even indices: " + findSecondLargestFromEvenIndex(arr3)); // Output: Exception
    }
}
