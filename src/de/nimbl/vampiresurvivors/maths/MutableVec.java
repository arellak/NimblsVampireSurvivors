package de.nimbl.vampiresurvivors.maths;

public class MutableVec {
    private  float x;
    private  float y;
    private float limit;

    public MutableVec(float x, float y) {
        setLimit(0);
        this.x = x;
        this.y = y;
    }

    public MutableVec(float x, float y, float limit) {
        setLimit(limit);
        this.x = x;
        this.y = y;
    }

    public boolean hasLimit() {
        return limit != 0;
    }

    public void set(float x, float y) {
        if (Math.abs(x) != limit && Math.abs(y) != limit) {
            this.x = x;
            this.y = y;
        } else {
            this.x = this.limit;
            this.y = this.limit;
        }
    }

    public void setLimit(float limit) {
        this.limit = limit;
    }

    public float getLimit() {
        return this.limit;
    }

    public void setMagnitude(final MutableVec vec, float amount) {
        float[] newV = normalize(vec);
        this.x = newV[0] * amount;
        this.y = newV[1] * amount;
    }

    public float getLength() {
        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    private float[] normalize(MutableVec vec) {
        float length = vec.getLength() == 0 ? 1 : vec.getLength();

        float newX = vec.x / length;
        float newY = vec.y / length;

        return new float[]{newX, newY};
    }

    public void add(MutableVec add) {
        this.x += add.x;
        this.y += add.y;
    }

    public void subtract(MutableVec sub){
       this.x -= sub.x;
       this.y -= sub.y;
    }

}
