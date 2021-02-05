package com.epam.third.task.entities;

public class SphereParams {

    private double volume;
    private double area;

    public SphereParams(double volume, double area) {
        this.volume = volume;
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SphereParams)) return false;

        SphereParams params = (SphereParams) o;

        if (Double.compare(params.volume, volume) != 0) return false;
        return Double.compare(params.area, area) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(volume);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(area);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
