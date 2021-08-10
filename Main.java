package les_1;

//     1. Создать пустой проект в IntelliJ IDEA и прописать метод main().

public class Main {


    public static void main(String[] args) {

    isLeapYear (2020);
    }

    // 2.Создать переменные всех пройденных типов данных и инициализировать их значения.

    static void doFunc1() {
        int var1 = 1;
        float var2 = 1.0f;
        double var3 = 1.0;
        long var4 = 1;
        short var5 = 1;
        boolean bool = true;
        char letter = 'A';

    }

    /*
    3.Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    где a, b, c, d – аргументы этого метода, имеющие тип float.
     */

    static float doFunc2(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    /*
    4. Написать метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно),
    если да – вернуть true, в противном случае – false.
     */

    static boolean checkIfInRange(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    /*
    5. Написать метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом.
     */

    static void negOrPos (int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    /*
    6. Написать метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     */

    static boolean negOrPos2 (int a) {
        return a < 0;
    }

    /*
    7. Написать метод, которому в качестве параметра передается строка,
    обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
     */

    static void printName (char name) {
        System.out.println("Привет, " + name);
    }

    /*
     *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */

    static void isLeapYear (int year) {
        boolean isLeap = year % 400 == 0 || year % 4 == 0 && year % 100 != 0;

        if (isLeap) {
            System.out.println("Год " + year + " - високосный.");
        } else {
            System.out.println("Год " + year + " - НЕвисокосный.");
        }
    }

}
