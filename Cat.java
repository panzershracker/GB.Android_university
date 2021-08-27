package les_6;

public class Cat extends Animal{

    public Cat() {
        super(200, 0);
    }

    @Override
    protected String getName() {
        return "Кот";
    }
}
