package com.epam.third.task.entities;

public class Point {

    private final double X;
    private final double Y;
    private final double Z;

    public Point(double x, double y, double z) {
        this.X = x;
        this.Y = y;
        this.Z = z;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getZ() {
        return Z;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(X);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(Y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(Z);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj.getClass() != Point.class){
            return false;
        }
        Point other = (Point)obj;
        return other.X == X && other.Y == Y && other.Z == Z;
    }
}
