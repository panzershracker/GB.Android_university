package les_8;

public class Cat implements Pass{
    private int runDistance = 8;
    private int jumpHeight = 3;

    public void passTreadmill(int runDistance) {
    }

    public void passWall(int jumpHeight) {
    }

    public int getRunDistance() {
        return runDistance;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
