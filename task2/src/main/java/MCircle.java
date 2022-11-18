public class MCircle {
    private final float r;
    private final MPoint pivot;

    public MCircle(float r, MPoint pivot) {
        this.r = r;
        this.pivot = pivot;
    }

    public float getR() {
        return r;
    }

    public MPoint getPivot() {
        return pivot;
    }

    @Override
    public String toString() {
        return "MCircle{" +
                "r=" + r +
                ", pivot=" + pivot +
                '}';
    }
}
