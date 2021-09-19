package les_10;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.

2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
взаимодействие с пользователем через консоль и т.д).
Консоль использовать только для вывода результатов проверки телефонного справочника
 */

import java.util.*;


public class Main {

    public static void main(String[] args) {

        String[] arr = {
                "один", "два", "три", "три",
                "один", "два", "три", "три",
                "один", "два", "три", "три"};


        Set<String> unique = new HashSet<String>(List.of(arr));
        String[] unique2 = unique.toArray(new String[unique.size()]);
        System.out.printf("Unique elements list: %s %n", unique);


        Dictionary<String, Integer> mostCommon = new Hashtable<>();

        for (int i = 0; i < unique2.length; i++) {
            mostCommon.put(unique2[i], 0);
        }

        for (int i = 0; i < arr.length; i++) {
            mostCommon.put(arr[i], mostCommon.get(arr[i]) + 1);
        }

        System.out.printf("Elements quantity is: %s %n%n%n", mostCommon);


        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Ivan", 123, false);
        phoneBook.add("Ivan", 648, false);
        phoneBook.add("Pavel", 157, false);
        phoneBook.add("Sergey", 878, false);
        phoneBook.add("Sergey", 547, false);
        phoneBook.add("Maria", 101, false);
        phoneBook.add("Sara", 555, false);



        phoneBook.get("Sergey");
//        phoneBook.printBook();
    }
}

/*
Unique elements list: [два, один, три]
Elements quantity is: {три=6, один=3, два=3}


Name = Sergey, phone number = 547
Name = Sergey, phone number = 878
 */