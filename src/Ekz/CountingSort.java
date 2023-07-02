package Ekz;
//  Сортировки «без сравнений»: сортировка подсчетом (counting sort), блочная сортировка (bucket sort)

import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] array, int range) {
        if (array == null || array.length <= 1) {
            return; // Если массив пустой или содержит только один элемент, сортировка не требуется
        }

        // Шаг 1: Создаем массив счетчиков countArray
        int[] countArray = new int[range + 1]; // Создаем массив размером, равным диапазону значений + 1

        // Шаг 2: Подсчитываем количество вхождений каждого значения
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            countArray[value]++; // Увеличиваем счетчик для текущего значения
        }

        // Шаг 3: Вычисляем префиксные суммы массива countArray
        // выполняется для того, чтобы определить позицию каждого элемента в отсортированном массиве.
        for (int i = 1; i <= range; i++) {
            countArray[i] += countArray[i - 1]; // Добавляем предыдущую сумму к текущему значению
        }

        // Шаг 4: Создаем массив для отсортированных элементов
        int[] sortedArray = new int[array.length];

        // Шаг 5: Распределяем элементы в отсортированный массив с использованием информации из countArray
        for (int i = array.length - 1; i >= 0; i--) {
            int value = array[i];
            int index = countArray[value] - 1; // Определяем позицию элемента в отсортированном массиве
            sortedArray[index] = value; // Помещаем элемент в отсортированный массив
            countArray[value]--; // Уменьшаем счетчик для текущего значения
        }

        // Шаг 6: Копируем отсортированный массив обратно в исходный массив
        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 4};
        int range = 9;

        System.out.println("Исходный массив: " + Arrays.toString(array));

        countingSort(array, range);

        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}


