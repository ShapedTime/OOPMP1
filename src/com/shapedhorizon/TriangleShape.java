package com.shapedhorizon;

import java.util.ArrayList;
import java.util.List;

public class TriangleShape implements Shape {
    private PointBasic center;
    private PointBasic p1, p2, p3;

    public TriangleShape(PointBasic p1, PointBasic p2, PointBasic p3) {
        if(TriangleShape.isValid(p1, p2, p3)){
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.center = new PointBasic((p1.getX() + p2.getX() + p3.getX())/3, (p1.getY() + p2.getY() + p3.getY())/3, p1.getColor());
        }else{
            throw new RuntimeException("Invalid Triangle Params");
        }
    }

    public TriangleShape(VectorBasic l1, VectorBasic l2, VectorBasic l3){
        if(TriangleShape.isValid(l1, l2, l3)){
            this.p1 = l1.getP1();
            this.p2 = l1.getP2();
            if(l2.getP1().equals(this.p1) || l2.getP1().equals(this.p2)) this.p3 = l2.getP2();
            else this.p3 = l2.getP1();
            this.center = new PointBasic((this.p1.getX() + this.p2.getX() + this.p3.getX())/3, (this.p1.getY() + this.p2.getY() + this.p3.getY())/3, this.p1.getColor());
        }else{
            throw new RuntimeException("Invalid Triangle Params");
        }
    }

    private static boolean isValid(PointBasic p1, PointBasic p2, PointBasic p3){
        VectorBasic l1 = new VectorBasic(p1, p2);
        VectorBasic l2 = new VectorBasic(p2, p3);
        VectorBasic l3 = new VectorBasic(p3, p1);
        return TriangleShape.isValid(l1, l2, l3);
    }

    private static boolean isValid(VectorBasic l1, VectorBasic l2, VectorBasic l3){
        if ( !( l1.hasCommonPoint(l2) && l1.hasCommonPoint(l3) && l2.hasCommonPoint(l3) ) ) return false;
        return ((l1.getLength() + l2.getLength() > l3.getLength()) && (l2.getLength() + l3.getLength() > l1.getLength()) && (l3.getLength() + l1.getLength() > l2.getLength()));
    }


    @Override
    public PointBasic getCenter() {
        return this.center;
    }


    @Override
    public List<VectorBasic> getVectors() {
        List<VectorBasic> ret = new ArrayList<>();
        ret.add(new VectorBasic(p1, p2));
        ret.add(new VectorBasic(p2, p3));
        ret.add(new VectorBasic(p3, p1));
        return ret;
    }
}
