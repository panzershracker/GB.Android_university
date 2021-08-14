package les_3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        guessTheNumber();
    }

    /*
    1. Написать программу, которая загадывает случайное число от 0 до 9 и
    пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить,
    больше ли указанное пользователем число, чем загаданное, или меньше.
    После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */

    static void guessTheNumber() {
        Scanner scanner = new Scanner((System.in));
        System.out.println("Сыграть еще раз? Да - 1, Нет - 2: \n");
        int playAgain = scanner.nextInt();

        do {
            System.out.println("Игра началась, у вас 3 попытки чтобы отгадать число в диапазоне 0-9: \n");
            Random random = new Random();
            int randNum = random.nextInt(3);

            for (int i = 0; i < 3; i++) {
                System.out.println("Попытка № " + (i + 1) + ", введите число: \n");
                int answer = scanner.nextInt();

                if (answer == randNum) {
                    System.out.println("Победа! \n");
                    break;
                } else if (answer > randNum) {
                    System.out.println("Введенное число больше загаданного!");
                } else {
                    System.out.println("Введенное число меньше загаданного!");
                }

            }
        }while (playAgain == 1);
    }
}
