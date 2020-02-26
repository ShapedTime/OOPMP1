package com.shapedhorizon;

public class VectorBasic {
    private PointBasic p1,p2;
    private int color;

    public VectorBasic(PointBasic p1, PointBasic p2, int color) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
    }

    public VectorBasic(PointBasic p1, PointBasic p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = p1.getColor();
    }

    public VectorBasic(PointBasic p1) {
        this.p1 = p1;
        this.p2 = p1;
        this.color = p1.getColor();
    }

    public PointBasic getP1() {
        return p1;
    }

    public void setP1(PointBasic p1) {
        this.p1 = p1;
    }

    public PointBasic getP2() {
        return p2;
    }

    public void setP2(PointBasic p2) {
        this.p2 = p2;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public PointBasic getCenter(){
        return new PointBasic((p1.getX() + p2.getX())/2, (p1.getY() + p2.getY())/2, this.color);
    }

    public double getLength(){
        return p1.getDistance(p2);
    }

}
