package Ekz;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {

    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(T[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);

            merge(array, start, mid, end);
        }
    }

    //сливает две отсортированные половины в одну отсортированную последовательность.
    /*сначала создаются временные массивы leftArray и rightArray, куда копируются элементы левой и правой половин
    массива соответственно. Затем происходит слияние элементов из leftArray и rightArray в исходный массив array,
    сравнивая элементы на каждой позиции и записывая наименьший элемент.
     */
    private void merge(T[] array, int start, int mid, int end) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        T[] leftArray = Arrays.copyOfRange(array, start, mid + 1);
        T[] rightArray = Arrays.copyOfRange(array, mid + 1, end + 1);

        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = start;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0) {
                array[mergedIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[mergedIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        while (leftIndex < leftSize) {
            array[mergedIndex] = leftArray[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        while (rightIndex < rightSize) {
            array[mergedIndex] = rightArray[rightIndex];
            rightIndex++;
            mergedIndex++;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {5, 2, 8, 1, 9, 4};

        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}


