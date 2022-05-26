package de.nimbl.vampiresurvivors.maths;

public class ImmutableVec {

    private final float x = 0;
    private final float y = 0;
    private float limit;

    public ImmutableVec(float x, float y) {
        setLimit(0);
        x = x;
        y = y;
    }

    public ImmutableVec(float x, float y, float limit) {
        setLimit(limit);
        x = x;
        y = y;
    }



    public boolean hasLimit() {
        return limit != 0;
    }

    public ImmutableVec set(float x, float y) {
        if (Math.abs(x) != limit && Math.abs(y) != limit) {
            return new ImmutableVec(x, y, this.limit);
        } else {
            return new ImmutableVec(this.limit, this.limit, this.limit); //TODO: This line will result in errors.
        }
    }

    public void setLimit(float limit) {
        this.limit = limit;
    }

    public float getLimit() {
        return this.limit;
    }

    public static ImmutableVec setMagnitude(final ImmutableVec vec, float amount) {

        float[] newV = normalize(vec);
        return new ImmutableVec(newV[0] * amount, newV[1] * amount);
    }

    public float getLength() {
        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    private static float[] normalize(ImmutableVec vec) {
        float length = vec.getLength() == 0 ? 1 : vec.getLength();

        float newX = vec.x / length;

        float newY = vec.y / length;
        return new float[]{newX, newY};
    }

    public static ImmutableVec add(ImmutableVec add, ImmutableVec adds) {
        return new ImmutableVec(add.x + adds.x, add.y + adds.y);
    }

    public static ImmutableVec subtract(ImmutableVec sub, ImmutableVec subs){
        return new ImmutableVec(sub.x - subs.x, sub.y - subs.y);
    }

   /* [...] */

}
