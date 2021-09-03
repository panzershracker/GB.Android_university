package les_7;

/*
1. Расширить задачу про котов и тарелки с едой. (см. методичку)
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт
(это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */

public class Main {

    public static void main(String[] args) {

        Plate plate = new Plate(15);

        Cat[] cat = {new Cat("Гарфилд", 10),
                    new Cat("Матроскин", 5),
                    new Cat("Том", 7)};

        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(plate);
        }

        for (int i = 0; i < cat.length; i++) {
            if(cat[i].getBellyful() == false) {
                plate.fillPlate(cat[i].getAppetite());
                cat[i].eat(plate);
            }
        }

        for (int i = 0; i < cat.length; i++) {
            cat[i].status();
        }
    }
}
