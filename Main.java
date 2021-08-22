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

// На данный момент игра универсальна для всех размеров поля (параметр fieldSize).
// бот блокирует ряд игрока, если до выигрыша игроку не хватает одного крестика.
// Добавлено сообщение о том какую ячейку заблокировал бот.

public class Main {

    public static void main(String[] args) {
        int fieldSize = 3;
        createField(fieldSize);
        play(fieldSize);


    }

    static void play(int fieldSize) {
        char[][] field = createField(fieldSize);

        do {
            playerTurn(field, fieldSize);
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

    static boolean isNeedToBlock (char[] array) {
        /*
        Блокировка осуществляется только если игроку не хватает в ряду одного крестика для победы.
        По сути повторяем логику работы функции проверки на однородность массива,
        но теперь будем проверять массив на однородность и если в ряду все крестики кроме одного элемента "-".
        Если игрок поставил крестик во всем ряду кроме одной клетки - этот ряд блокируем ноликом.
         */

        int emptyCell = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 'X' && array[i] != '-') {
                return false;
            }else if (array[i] == '-') {
                emptyCell = emptyCell + 1;
            }
        }

        if (emptyCell == 1) {
            return true;
        }return false;
    }

    static int[] findCellToBlock (char[][] field) {
        /*
        Ищем строки, колонки и диагонали для блокировки.
        Принимает одномерный массив.
        Возвращает массив из двух цифр, обозначающий индексы ячейки которую необходимо заблокировать..
         */

        int row = -1;
        int col = -1;


        // horizontal win check
        for (int i = 0; i < field.length; i++) {
            if (isNeedToBlock(field[i])) {
                row = i;
                col = indexToBlock(field[i]);
            }
        }

        //vertical win check
        char[] tempArray = new char[field.length];

        for (int i = 0; i < field.length; i++) {

            for (int j = 0; j < field.length; j++) {
                tempArray[j] = field[j][i];
            }

            if (isNeedToBlock(tempArray)) {
                col = i;
                row = indexToBlock(tempArray);
            }
        }

        //diagonal win check
        for (int i = 0; i < field.length; i++) {
            tempArray[i] = field[i][i];
        }

        if (isNeedToBlock(tempArray)) {
            row = indexToBlock(tempArray);
            col = indexToBlock(tempArray);
        }

        //side diagonal win check
        for (int i = 0; i < field.length; i++) {
            tempArray[i] = field[i][field.length - 1 - i];
        }

        if (isNeedToBlock(tempArray)) {
            row = indexToBlock(tempArray);
            col = field.length - indexToBlock(tempArray) - 1;
        }
        return new int[] {row,col};
    }

    static int indexToBlock (char[] array) {
        int idx = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '-') {
                idx = i;
            }
        }
        return idx;
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

    static void playerTurn (char[][] field, int fieldSize) {
        int h, v;

        do{
            h = getCoord(field.length - 1, 'h', fieldSize);
            v = getCoord(field.length - 1, 'v', fieldSize);
        }while (isNotFreeCell(field, h, v));

        field[h][v] = 'X';
        System.out.print("Ход игрока: \n");
        System.out.println(" ");
    }

    static void randomAimove (char[][] field) {
        Random random = new Random();
        int h, v;

        do {
            h = random.nextInt(field.length);
            v = random.nextInt(field.length);
        } while (isNotFreeCell(field, h, v));

        field[h][v] = 'O';
        System.out.print("Ход соперника: \n");
        System.out.println(" ");
    }

    static void blockAiMove (char[][] field) {
        int h = findCellToBlock(field)[0];
        int v = findCellToBlock(field)[1];

        field[h][v] = 'O';
        System.out.printf("ИИ заблокировал ячейку [%s,%s]: \n", h + 1, v + 1);
        System.out.println(" ");
    }

    static void aiTurn (char[][] field) {
        int h,v;

        if (findCellToBlock(field)[0] != -1 && findCellToBlock(field)[1] != -1) {
            blockAiMove(field);
    }   randomAimove(field);

    }

    static boolean isFreeCell (char[][] field, int h, int v) {
        return field[h][v] == '-';
    }

    static boolean isNotFreeCell(char[][] field, int h, int v) {
        return !isFreeCell(field, h, v);
    }

    static int getCoord(int lastIndex, char coordName, int fieldSize) {
        Scanner scanner = new Scanner(System.in);
        int coord;

        do {
            System.out.printf("Введите %s-координату [1-%s]%n", coordName, fieldSize);
            coord = scanner.nextInt() - 1;
        } while (coord < 0 || coord > lastIndex);
        return coord;
    }

    static char[][] createField(int size) {
        char[][] field = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = '-';
            }
        }
        return field;
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }
    }
}

