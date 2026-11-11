import java.util.Scanner;

public class Main {
    public static void bubbleSort(int[] parcels, int[] afterTwoPasses) {
        int n = parcels.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (parcels[j] < parcels[j + 1]) {
                    int temp = parcels[j];
                    parcels[j] = parcels[j + 1];
                    parcels[j + 1] = temp;
                }
            }

            if (i == 1) {
                for (int j = 0; j < n; j++) {
                    afterTwoPasses[j] = parcels[j];
                }
            }
        }
    }

    public static int binarySearch(int[] parcels, int target) {
        int low = 0;
        int high = parcels.length - 1;
        int steps = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            steps++;

            if (parcels[mid] == target) {
                return steps;
            } else if (target > parcels[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1; // Search in the right half
            }
        }

        return steps;
    }

    public static void displayArray(int[] parcels) {
        for (int i = 0; i < parcels.length; i++) {
            System.out.print(parcels[i]);

            if (i < parcels.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

        int n = sc.nextInt();
        int[] parcels = new int[n];

        for (int i = 0; i < n; i++) {
            parcels[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] targets = new int[m];

        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        sc.close();

        int[] afterTwoPasses = new int[n];
        bubbleSort(parcels, afterTwoPasses);

        System.out.println("==== After 2 Passes ====");
        displayArray(afterTwoPasses);

        System.out.println();

        System.out.println("==== Fully Sorted ====");
        displayArray(parcels);

        System.out.println();

        System.out.println("==== Search Results ====");
        for (int i = 0; i < m; i++) {
            int target = targets[i];
            int low = 0;
            int high = n - 1;
            int steps = 0;
            int foundIndex = -1;

            while (low <= high) {
                int mid = (low + high) / 2;
                steps++;

                if (parcels[mid] == target) {
                    foundIndex = mid;
                    break;
                } else if (target > parcels[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1; // Search in the right half
                }
            }

            if (foundIndex != -1) {
                System.out.println(target + ": FOUND at index " + foundIndex + " (steps: " + steps + ")");
            } else {
                System.out.println(target + ": NOT FOUND (steps: " + steps + ")");
            }
        }
    }
}