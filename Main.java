package les_9;

/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
и вывести результат расчета.
 */


public class Main {

    public static void main(String[] args) {
        String array[][] = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "a", "4"}};

        checkArraySize(array);
        arrayElementsSum(array);
    }

    static void arrayElementsSum(String[][] array) {
        int sum = 0;
        int row = 0;
        int col = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j ++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                    row = i;
                    col = j;
                }catch (NumberFormatException e) {
                    System.out.printf("Sum before program crash is %s %n" +
                            "Non-integer element position is [%s][%s] %n%n", sum, row, col + 1);
                    throw new MyArrayDataException("Element is not an integer");
                }
            }
        }
    }
    static void checkArraySize(String[][] array) {
        if (array.length != 4) {
            throw new MyArraySizeException("Size is not 4");
        }

        for (int i = 0; i < array.length; i++)
            if (array[i].length != 4) {
                throw new MyArraySizeException("Size is not 4");
        }
    }
}
