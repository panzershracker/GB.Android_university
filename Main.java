package les_8;

/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
участники должны выполнять соответствующие действия (бежать или прыгать),
результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
4. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
5.* У препятствий есть длина (для дорожки) или высота (для стены),
а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий,
то дальше по списку он препятствий не идет.

 */
public class Main {

    public static void main(String[] args) {
        Pass[] subjects = {new Cat(), new Bot(), new Human()};

        int wallHeight = 1;
        int treadmillDistance = 10;

        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].getRunDistance() >= treadmillDistance) {
                System.out.printf("%s pass treadmill %n", subjects[i].getName());
            }else {
                System.out.printf("%s Didn't pass treadmill %n", subjects[i].getName());
            }
        }
    }
}
