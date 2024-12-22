package ru.matthewyurkevich.antiLaaksonenBook;

import java.util.Arrays;

/**
 * Реализация сортировки слияниям.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 5, 3, 2, 6, 7, 4, 3};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(array, l, mid);
            mergeSort(array, mid + 1, r);
            merge(array, l, mid, r);
        }
    }

    public static void merge(int[] array, int l, int mid, int r) {
        int ind1 = l;          // Начало левой части
        int ind2 = mid + 1;    // Начало правой части
        int resInd = 0;        // Индекс для временного массива
        int[] result = new int[r - l + 1]; // Временный массив для слияния

        // Слияние двух частей
        while (ind1 <= mid && ind2 <= r) {
            if (array[ind1] < array[ind2]) {
                result[resInd] = array[ind1];
                ind1++;
            } else {
                result[resInd] = array[ind2];
                ind2++;
            }
            resInd++;
        }

        // Копируем оставшиеся элементы из левой части (если есть)
        while (ind1 <= mid) {
            result[resInd] = array[ind1];
            ind1++;
            resInd++;
        }

        // Копируем оставшиеся элементы из правой части (если есть)
        while (ind2 <= r) {
            result[resInd] = array[ind2];
            ind2++;
            resInd++;
        }

        // Копируем результат обратно в исходный массив
        if (r + 1 - l >= 0) System.arraycopy(result, 0, array, l, r + 1 - l);
    }
}