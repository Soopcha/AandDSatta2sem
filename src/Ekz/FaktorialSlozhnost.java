package Ekz;

import java.util.Arrays;

public class FaktorialSlozhnost {


    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        permute(array, 0);
    }

    public static void permute(int[] array, int start) {
        if (start == array.length - 1) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = start; i < array.length; i++) {
                swap(array, start, i);
                permute(array, start + 1);
                swap(array, start, i); // Восстанавливаем исходный порядок элементов
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

