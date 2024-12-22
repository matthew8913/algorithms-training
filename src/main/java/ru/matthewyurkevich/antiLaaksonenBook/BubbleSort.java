package ru.matthewyurkevich.antiLaaksonenBook;

import java.util.Arrays;

/**
 * Реализация пузырьковой сортировки.
 */
public class BubbleSort {

    public static void main(String[] args) {
        Integer[] arr = {5, 1, 5, 3, 2, 6, 7, 4, 3};
        bubbleSort(arr);
        System.out.println(Arrays.asList(arr));
    }

    public static void bubbleSort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    Integer temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

}