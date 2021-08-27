package les_6;

public class Dog extends Animal{

    public Dog() {
        super(500, 10);
    }

    @Override
    protected String getName() {
        return "Собака";
    }
}
