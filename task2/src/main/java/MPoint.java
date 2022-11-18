public class MPoint {
    private float x;
    private float y;

    public MPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "MPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
