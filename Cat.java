package les_8;

public class Cat implements Pass{
    public String name;
    private int runDistance = 10;
    private int jumpHeight = 2;

    public Cat(String tom) {
    }

    @Override
    public void passTreadmill(int runDistance) {
        System.out.printf("%s pass treadmill", this.name);
    }

    @Override
    public void passWall(int jumpHeight) {
    }

    @Override
    public int getRunDistance() {
        return runDistance;
    }

    @Override
    public int getJumpHeight() {
        return jumpHeight;
    }
}
