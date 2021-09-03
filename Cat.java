package les_7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean bellyful = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    protected String getName() {
        return this.name;
    }

    protected int getAppetite() {
        return this.appetite;
    }

    protected boolean getBellyful() {return this.bellyful;}

    public void eat (Plate plate) {
        if (appetite > plate.getFoodQuantity()) {
            System.out.println("В тарелке меньше еды чем нужно " + name + "у и он НЕ поел!\n");
        }else {plate.decreaseFood(appetite, name);
                bellyful = true;
                System.out.println(name + " Поел\n");};
    }

    public void status() {
        System.out.printf("Статус:%n" +
                "Имя = %s%n" +
                "Аппетит = %s%n" +
                "Сытый = %s%n%n", name, appetite, bellyful);
    }


}
