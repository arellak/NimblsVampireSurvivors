package de.nimbl.vampiresurvivors.maths;

public class Vec2 {

    private float x;
    private float y;
    private float limit;

    public Vec2() {
        setLimit(0);
        setX(0);
        setY(0);
    }

    public Vec2(float x, float y) {
        setLimit(0);
        setX(x);
        setY(y);
    }

    public Vec2(float x, float y, float limit) {
        setLimit(limit);
        setX(x);
        setY(y);
    }

    public Vec2(Vec2 vec) {
        setLimit(0);
        setX(vec.getX());
        setY(vec.getY());
    }

    public boolean hasLimit() {
        return limit != 0;
    }

    public void set(float x, float y) {
        setX(x);
        setY(y);
    }

    public void setX(float x) {
        if(hasLimit()) {
            this.x = Math.min(x, this.limit);
            this.x = Math.max(this.x, -this.limit);
        } else {
            this.x = x;
        }
    }

    public float getX() {
        return this.x;
    }

    public void setY(float y) {
        if(hasLimit()) {
            this.y = Math.min(y, this.limit);
            this.y = Math.max(this.y, -this.limit);
        } else {
            this.y = y;
        }
    }

    public float getY() {
        return this.y;
    }

    public void setLimit(float limit) {
        this.limit = limit;
    }

    public float getLimit() {
        return this.limit;
    }

    public void setMagnitude(float amount) {
        normalize();
        mult(amount);
    }

    public float getLength() {
        return (float) Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2));
    }

    public void normalize() {
        float length = getLength() == 0 ? 1 : getLength();

        float newX = getX() / length;
        setX(newX);

        float newY = getY() / length;
        setY(newY);
    }

    public void add(Vec2 toAdd) {
        set(getX() + toAdd.getX(), getY() + toAdd.getY());
    }

    public void sub(Vec2 toSub) {
        set(getX() - toSub.getX(), getY() - toSub.getY());
    }

    public Vec2 subtract(Vec2 toSub) {
        return new Vec2(getX() - toSub.getX(), getY() - toSub.getY());
    }

    public void mult(float toMult) {
        set(getX() * toMult, getY() * toMult);
    }

    public Vec2 multiplicate(float toMult) {
        return new Vec2(getX() * toMult, getY() * toMult);
    }

    @Override
    public String toString() {
        return "Vec2{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", limit=" + getLimit() +
                '}';
    }

}