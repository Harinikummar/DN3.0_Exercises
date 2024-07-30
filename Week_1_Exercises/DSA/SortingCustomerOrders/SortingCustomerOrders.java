package SortingCustomerOrders;

import java.util.Arrays;

public class SortingCustomerOrders {
    public static void main(String[] args) {
        Order[] orders = {
                new Order(101, "User2", 250.0),
                new Order(102, "User4", 150.0),
                new Order(103, "User3", 300.0),
                new Order(104, "User1", 100.0)
        };

        // Bubble Sort
        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        BubbleSort.bubbleSort(bubbleSortedOrders);
        System.out.println("Bubble Sort : " + Arrays.toString(bubbleSortedOrders));

        // Quick Sort
        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        QuickSort.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("\nQuick Sort : " + Arrays.toString(quickSortedOrders));
    }
}
