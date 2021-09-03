package les_7;

public class Plate {
    private static int foodQuantity;

    public Plate(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void decreaseFood(int n, String name) {
        if (foodQuantity >= n) {
            foodQuantity -= n;
        }
    }

    public void info() {
        System.out.println("Кол-во еды в тарелке = " + foodQuantity);
    }

    public void fillPlate(int fillQuantity) {
        System.out.println("Добавим еду в тарелку");
        System.out.println("Было в тарелке = " + foodQuantity);
        foodQuantity += fillQuantity;
        System.out.println("Стало в тарелке = " + foodQuantity + "\n\n");
    }
}
