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
        }else{
            throw new RuntimeException("Invalid Triangle Params");
        }
    }

    private static boolean isValid(PointBasic p1, PointBasic p2, PointBasic p3){
        VectorBasic l1 = new VectorBasic(p1, p2);
        VectorBasic l2 = new VectorBasic(p2, p3);
        VectorBasic l3 = new VectorBasic(p3, p1);
        return ((l1.getLength() + l2.getLength() > l3.getLength()) && (l2.getLength() + l3.getLength() > l1.getLength()) && (l3.getLength() + l1.getLength() > l2.getLength()));
    }

    private static boolean isValid(VectorBasic l1, VectorBasic l2, VectorBasic l3){
        return ((l1.getLength() + l2.getLength() > l3.getLength()) && (l2.getLength() + l3.getLength() > l1.getLength()) && (l3.getLength() + l1.getLength() > l2.getLength()));
    }

    @Override
    public PointBasic getCenter() {
        return null;
    }

    @Override
    public void setCenter(PointBasic point) {

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
