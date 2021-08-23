package les_5;

/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.
Пример: Person[] persArray = new Person[5];
// Вначале объявляем массив объектов persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
// потом для каждой ячейки массива задаем объект persArray[1] = new Person(...); ... persArray[4] = new Person(...);
5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */
public class Main {

    public static void main(String[] args) {
	Employee[] employees = {
	        new Employee("Ivan", "Porter", "i.porter@gmail.com", "+7123", 10000, 23),
            new Employee("Pavel", "Driver", "p.driver@gmail.com", "+7124", 15000, 46),
            new Employee("Alex", "Owner", "a.owner@gmail.com", "+7111", 100000, 31),
            new Employee("Kate", "lawyer", "k.lawyer@gmail.com", "+7432", 70000, 54),
            new Employee("Oleg", "Manager", "o.manager@gmail.com", "+7231", 80000, 29)};

	printFilteredEmployees(employees, 40);
	
    }

    static void printFilteredEmployees(Employee[] employees, int age) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].printEmployeeInfo();
            }
        }
    }
}
