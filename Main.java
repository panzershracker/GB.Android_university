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
        Random random = new Random();
        Scanner scanner = new Scanner((System.in));
        int counter = 0;
        int playAgain;

        do {
            System.out.println("Игра началась, у вас 3 попытки чтобы отгадать число в диапазоне 0-9: \n");
            
            do {
                int randNum = random.nextInt(3);

                System.out.println("Попытка № " + (counter + 1) + ", введите число: \n");
                int answer = scanner.nextInt();

                if (answer == randNum) {
                    System.out.println("Победа! \n");
                    break;
                } else if (answer > randNum) {
                    System.out.println("Введенное число больше загаданного!");
                    counter++;
                } else {
                    System.out.println("Введенное число меньше загаданного!");
                    counter++;
                }

            } while (counter < 3);

            System.out.println("Сыграть еще раз? Да - 1, Нет - 2: \n");
            playAgain = scanner.nextInt();

        }while(playAgain == 1);
    }
}
