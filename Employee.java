package les_5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String name,
                    String position,
                    String email,
                    String phoneNumber,
                    int salary,
                    int age) {

        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printEmployeeInfo() {
        System.out.printf(
                "Employee info: %n" +
                "Name: %s%n" +
                "Position: %s%n" +
                "email: %s%n" +
                "Phone number: %s%n" +
                "Salary: %s%n" +
                "Age: %s%n%n",
                name, position, email, phoneNumber, salary, age);
    }
}
