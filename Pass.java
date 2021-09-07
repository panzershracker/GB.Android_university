package les_8;

public interface Pass {


    void passTreadmill(int runDistance);
    void passWall(int jumpHeight);

    int getRunDistance();
    int getJumpHeight();

    String getName();
}
