package les_5;

import java.util.Random;
import java.util.Scanner;

/*
1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать.
2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
например, с использованием циклов. Необходимо учесть,
что такая проверка должна быть универсальной для любого размера поля, 1х1, 5х5, 100х100 и так далее.
3.* Попробовать переписать логику проверки победы, чтобы она работала для поля 3х3 и 5х5.
Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
4.*** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */
public class Main {

    public static void main(String[] args) {
        createField();
        play();


    }
    static void play() {
        char[][] field = createField();

        do {
            playerTurn(field);
            drawField(field);
            if (isWin(field, 'X')) {
                System.out.println("Congrats!!! You are winner :)");
                break;
            }
            if (isDraw(field)) {
                System.out.println("This is draw.");
                break;
            }

            aiTurn(field);
            drawField(field);
            if (isWin(field, 'O')) {
                System.out.println("Sorry!!! You are looser :(");
                break;
            }
            if (isDraw(field)) {
                System.out.println("This is draw.");
                break;
            }
        } while (true);
    }

    static boolean isOneTypeArray(char[] array, char symbol) {
        /*
        Функция для проверки значений одномерного массива на одинаковость.
        Логика:
        За эталон берем первый элемент массива, и сравниваем с ним все последующие.
        Первое не соответствие свидетельствует о том что элементы массива не одинаковые
        и цикл прекращает работу, return false.

        Если каждый последующий элемент идентичен эталонному - возвращаем true.
         */

        char firstSymbol = symbol;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != firstSymbol) {
                return false;
            }
        }
        return true;
    }

    static boolean isWin(char[][] field, char symbol) {
        /*
        Проверка на победу.
        Для вертикали, горизонтали и диагоналей формируем одномерные массивы и передаем
        в функцию проверки однородности массива (isOneTypeArray) которая возвращает ответ типа boolean.
         */

        // horizontal win check
        for (int i = 0; i < field.length; i++) {
            if (isOneTypeArray(field[i], symbol)) {
                return true;
            }
        }

        //vertical win check
        char[] tempArray = new char[field.length];

        for (int i = 0; i < field.length; i++) {
            if (isOneTypeArray(tempArray, symbol)) {
                return true;
            }
            for (int j = 0; j < field.length; j++) {
                tempArray[j] = field[j][i];
            }
        }

        //diagonal win check
        for (int i = 0; i < field.length; i++) {
            tempArray[i] = field[i][i];
        }
        if (isOneTypeArray(tempArray, symbol)) {
            return true;
        }

        //side diagonal win check
        for (int i = 0; i < field.length; i++) {
            tempArray[i] = field[i][field.length - 1 - i];
        }
        if (isOneTypeArray(tempArray, symbol)) {
            return true;
        }

        return false;
    }


    static boolean isDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (isFreeCell(field, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

//    static boolean isWin2(char[][] field, char symbol) {
//    // horizontal
//        if (field[0][0] == symbol && field[0][1] == symbol && field[0][2] == symbol) {
//        return true;
//    }
//        if (field[1][0] == symbol && field[1][1] == symbol && field[1][2] == symbol) {
//        return true;
//    }
//        if (field[2][0] == symbol && field[2][1] == symbol && field[2][2] == symbol) {
//        return true;
//    }
//
//    // vertical
//        if (field[0][0] == symbol && field[1][0] == symbol && field[2][0] == symbol) {
//        return true;
//    }
//        if (field[0][1] == symbol && field[1][1] == symbol && field[2][1] == symbol) {
//        return true;
//    }
//        if (field[0][2] == symbol && field[1][2] == symbol && field[2][2] == symbol) {
//        return true;
//    }
//
//    // diagonals
//        if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) {
//        return true;
//    }
//        if (field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) {
//        return true;
//    }
//
//        return false;
//}

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
        System.out.println("\n");
        }
    }

    static void playerTurn (char[][] field) {
        int h, v;

        do{
            h = getCoord(field.length - 1, 'h');
            v = getCoord(field.length - 1, 'v');
        }while (isNotFreeCell(field, h, v));

        field[h][v] = 'X';
        System.out.print("Ход игрока: \n");
        System.out.println(" ");
    }

    static void aiTurn (char[][] field) {
        Random random = new Random();
        int h,v;

        do {
            h = random.nextInt(field.length);
            v = random.nextInt(field.length);
        }while (isNotFreeCell(field, h, v));

        field[h][v] = 'O';
        System.out.print("Ход соперника: \n");
        System.out.println(" ");
    }

    static boolean isFreeCell (char[][] field, int h, int v) {
        return field[h][v] == '-';
    }

    static boolean isNotFreeCell(char[][] field, int h, int v) {
        return !isFreeCell(field, h, v);
    }

    static int getCoord(int lastIndex, char coordName) {
        Scanner scanner = new Scanner(System.in);
        int coord;

        do {
            System.out.printf("Введите %s-координату [1-3]%n", coordName);
            coord = scanner.nextInt() - 1;
        } while (coord < 0 || coord > lastIndex);
        return coord;
    }


    static char[][] createField() {
        return new char[][]{
                {'-', '-', '-',},
                {'-', '-', '-',},
                {'-', '-', '-',}};

        }
}

