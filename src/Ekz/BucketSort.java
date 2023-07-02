package Ekz;
import java.util.ArrayList;
import java.util.Collections;
/*
Блочная сортировка (bucket sort) - это алгоритм сортировки, основанный на разбиении элементов входного массива на "ведра"
(buckets) и последующей сортировке каждого ведра отдельно. Этот метод особенно полезен, когда значения элементов входного
массива равномерно распределены в заданном диапазоне.

Алгоритм блочной сортировки:

Создать массив ведер (buckets), каждое ведро представляет собой контейнер для хранения элементов.
Пройтись по входному массиву и поместить каждый элемент в соответствующее ведро на основе определенного критерия.
Отсортировать каждое ведро по отдельности. Для этого можно использовать другой алгоритм сортировки, например, сортировку вставками.
Собрать элементы из каждого ведра в итоговый отсортированный массив.
 */

public class BucketSort {

    public static void bucketSort(int[] array, int numBuckets) {
        // Создаем ведра (buckets) в виде списка списков
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Распределяем элементы входного массива по ведрам
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = array[i] / numBuckets;
            buckets.get(bucketIndex).add(array[i]);
        }

        // Сортируем каждое ведро по отдельности (можно использовать любой другой алгоритм сортировки)
        for (int i = 0; i < numBuckets; i++) {
            Collections.sort(buckets.get(i));
        }

        // Собираем элементы из ведер в итоговый отсортированный массив
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                array[index++] = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {29, 25, 37, 49, 33, 21, 45, 9, 15, 8};
        int numBuckets = 5;

        bucketSort(array, numBuckets);

        // Вывод отсортированного массива
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}

