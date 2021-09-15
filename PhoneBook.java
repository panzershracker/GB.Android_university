package les_10;

import java.util.*;

public class PhoneBook {

    String name;
    int phone;

    // Выбрал именно такой порядок элементов ключ = номер, значение = иня, т.к. при итерации с помощью keySet() выводятся
    // только уникальные значения => не получится вывести одинаковые имена являющиеся ключами.

    Map<Integer,String> phonebook = new HashMap<>();


    public void add(String name, Integer phone, boolean print){
        phonebook.put(phone, name);
        if (print){
            System.out.printf("Name %s, phone %s was added to phonebook %n", name, phone);
        }
    }

    public void get(String contactName) {
        for (Integer phone : phonebook.keySet()) {
            name = phonebook.get(phone);
            if (contactName == name) {
                System.out.printf("Name = %s, phone number = %s %n", name, phone);
            }
        }
    }

    public void printBook() {
        for (Integer phone : phonebook.keySet()) {
            name = phonebook.get(phone);
            System.out.printf("Name = %s, number = %s %n", name, phone);
        }
//        System.out.println(phonebook);
    }
}
