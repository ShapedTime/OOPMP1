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

    public boolean hasCommonPoint(VectorBasic l){
        return this.p1.equals(l.getP1()) ||
                this.p1.equals(l.getP2()) ||
                this.p2.equals(l.getP2());
    }

    public static boolean hasCommonPoint(VectorBasic l1, VectorBasic l2){
        return l1.getP1().equals(l2.getP1()) ||
                l1.getP1().equals(l2.getP2()) ||
                l1.getP2().equals(l2.getP2());
    }

    public PointBasic commonPoint(VectorBasic l){
        if(!this.hasCommonPoint(l)) return null;
        if(this.p1.equals(l.getP1())) return this.p1;
        if(this.p1.equals(l.getP2())) return this.p1;
        return this.p2;
    }

    public static PointBasic commonPoint(VectorBasic l1, VectorBasic l2){
        if(!l1.hasCommonPoint(l2)) return null;
        if(l1.getP1().equals(l2.getP1())) return l1.getP1();
        if(l1.getP1().equals(l2.getP2())) return l1.getP1();
        return l1.getP2();
    }

}
