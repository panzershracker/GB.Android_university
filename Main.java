package les_2;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

    }

    static void printBefore(int[] arr) {
        System.out.println("Before" + Arrays.toString(arr));
    }

    static void printAfter(int[] arr) {
        System.out.println("After" + Arrays.toString(arr) + "\n");
    }

    /*
    1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */

    public static void arrCreate() {
        int[] arr = {1, 0, 1};
        printBefore(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        printAfter(arr);
    }

    /*
    2. Задать пустой целочисленный массив размером 8.
    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
     */

    static void arrFill() {
        int[] arr = new int[8];
        printBefore(arr);

        int currentVal = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = currentVal + 3;
            currentVal = arr[i];
        }
        printAfter(arr);
    }

    /*
    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2
     */

    static void multiplyBy2() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printBefore(arr);

        for (int i = 0; i < arr.length; i++) {
            boolean action = arr[i] < 6;

            if (action) {
                arr[i] = arr[i] * 2;
            }
        }
        printAfter(arr);
    }

    /*
    Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */

    static void makeUnitMatrix() {
        int[][] matrix = new int[3][3];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
        }
    }

    /*
    5.** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
     */

    static void findMinMax() {
        int[] arr = {3, 5, 1, 0, 7, 5, 9};

        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Min = " + min + "\n" + "Max = " + max);
    }

    /*
    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место,
    в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    граница показана символами ||, эти символы в массив не входят.
     */

    static void findMassCenter() {
        int[] arr = {1, 2, 1, 2};

        for (int i = 1; i < arr.length; i++) {
            int[] left = Arrays.copyOfRange(arr, 0, i);
            int[] right = Arrays.copyOfRange(arr, i, arr.length);
            int leftSum = Arrays.stream(left).sum();
            int rightSum = Arrays.stream(right).sum();

            if (leftSum == rightSum) {
                System.out.println("Left " + Arrays.toString(left) + ", Right " + Arrays.toString(right) + "\n");
                System.out.println(leftSum + "=" + rightSum);
                return;
            }
        }
    }

    /*
     **** Написать метод, которому на вход подается одномерный массив и число n
     * (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
     *  Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     * Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2
     * (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
     */

    static void shiftByN(int n) {
        Integer[] arr = {1, 2, 3, 4};
        System.out.println("Before" + Arrays.toString(arr));

        Collections.rotate(Arrays.asList(arr), n);
        System.out.println("After" + Arrays.toString(arr) + "\n");
    }
}