package ejercicios;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortTheOdd {
    /*
     * Task
     * You will be given an array of numbers. You have to sort the odd numbers in
     * ascending order while leaving the even numbers at their original positions.
     * 
     * Examples
     * [7, 1] => [1, 7]
     * [5, 8, 6, 3, 4] => [3, 8, 6, 5, 4]
     * [9, 8, 7, 6, 5, 4, 3, 2, 1, 0] => [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
     */
    public static int[] sortArray(int[] array) {
        int[] impares = Arrays.stream(array).filter(s -> (s % 2 != 0)).toArray();
        Arrays.sort(impares);
        int[] solution = new int[array.length];
        int imparesIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                solution[i] = impares[imparesIndex];
                imparesIndex++;
            } else
                solution[i] = array[i];
        }

        return solution;
    }

    public static void main(String[] args) {

    }
}
