package les_8;

public class Human implements Pass{
    private int runDistance = 12;
    private int jumpHeight = 1;

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
