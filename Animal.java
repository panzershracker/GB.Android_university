package les_6;

public abstract class Animal {
    private final int maxRunDistance;
    private final int maxSwimDistance;

    public Animal(int maxRunDistance, int maxSwimDistance) {
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    protected abstract String getName();

    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.printf("%s пробежал %s метров %n", getName(), distance);
        }else {
            System.out.printf("%s НЕ пробежал %s метров, так как столько бегать он не умеет %n", getName(), distance);
        }
    }

    public void swim (int distance) {
        if (distance <= maxSwimDistance) {
            System.out.printf("%s проплыл %s метров %n", getName(), distance);
        }else if (getName() == "Кот"){
            System.out.printf("%s убежал от воды подальше, так как клавать он не умеет вообще. %n", getName());
        }else {
            System.out.printf("%s НЕ проплыл %s метров, так как столько плавать он не умеет %n", getName(), distance);
        }
    }
}
