class primary {
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) { // Use array.length
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void sortArray(int[] array) {
        int temporary = 0;
        for (int i = 0; i < array.length; i++) { // Use array.length
            for (int j = i + 1; j < array.length; j++) { // Use array.length
                if (array[i] > array[j]) {
                    // Swap elements
                    temporary = array[i];
                    array[i] = array[j];
                    array[j] = temporary;
                }
            }
        }
        System.out.println("Elements of array sorted in ascending order: ");
        printArray(array); // Print the sorted array
    }

    public static void main(String[] args) {
        int[] array = { -5, -9, 8, 12, 1, 3 }; // Initialize the array
        System.out.println("Original Array: ");
        printArray(array); // Print the original array
        sortArray(array); // Sort the array and print it
    }
}
