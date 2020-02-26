package com.shapedhorizon;

import java.util.ArrayList;
import java.util.List;

public class RectangleShape implements Shape {
    private PointBasic center;
    private PointBasic p1, p2, p3, p4;

    public RectangleShape(PointBasic p1, PointBasic p2, PointBasic p3, PointBasic p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.center = new PointBasic((this.p1.getX() + this.p2.getX() + this.p3.getX() + this.p4.getX())/4, (this.p1.getY() + this.p2.getY() + this.p3.getY() + this.p4.getY())/4, this.p1.getColor());
    }

    public RectangleShape(VectorBasic l1, VectorBasic l2, VectorBasic l3, VectorBasic l4){
        if(RectangleShape.isValid(l1, l2, l3, l4)){
            this.p1 = l1.getP1();
            this.p2 = l1.getP2();
            if (l2.getP1().equals(this.p1) || l2.getP1().equals(this.p2)) this.p3 = l2.getP2();
            else this.p3 = l2.getP1();
            if (l3.getP1().equals(this.p1) || l3.getP1().equals(this.p2) || l3.getP1().equals(this.p3)) this.p4 = l3.getP2();
            else this.p4 = l3.getP1();
            this.center = new PointBasic((this.p1.getX() + this.p2.getX() + this.p3.getX() + this.p4.getX())/4, (this.p1.getY() + this.p2.getY() + this.p3.getY() + this.p4.getY())/4, this.p1.getColor());
        }else{
            throw new RuntimeException("Invalid Rectangle Params!");
        }
    }

    public static boolean isValid(VectorBasic l1, VectorBasic l2, VectorBasic l3, VectorBasic l4){
        if( l1.hasCommonPoint(l2) && l1.hasCommonPoint(l3) ) {
            return ( l4.hasCommonPoint(l2) && l4.hasCommonPoint(l3) );
        }else if( l1.hasCommonPoint(l3) && l1.hasCommonPoint(l4) ){
            return ( l2.hasCommonPoint(l3) && l2.hasCommonPoint(l4) );
        }else if( l1.hasCommonPoint(l4) && l1.hasCommonPoint(l2) ){
            return ( l3.hasCommonPoint(l4) && l3.hasCommonPoint(l2) );
        }else return false;
    }

    @Override
    public PointBasic getCenter() {
        return this.center;
    }

/*

        p1----------p2
        |           |
        |           |
        |           |
        p4----------p3
  -------------------------
                            1st case
        p1__________p3
        x x         |
        x     x     |
        x         x |
        p4----------p2

  --------------------------
                            2nd case
        p1xxxxxxxxxxp2
        x _         |
        x     _     |
        x         _ |
        p4----------p3

  ---------------------------
                            3rd case
        p1xxxxxxxxxxp2
        _ x         |
        _     x     |
        _         x |
        p3----------p4


 */

    @Override
    public List<VectorBasic> getVectors() {
        List<VectorBasic> ret = new ArrayList<>();

        if (this.p1.getDistance(this.p2) > this.p1.getDistance(this.p3) && this.p1.getDistance(this.p2) > this.p1.getDistance(this.p4)){
            ret.add(new VectorBasic(this.p1, this.p3));
            ret.add(new VectorBasic(this.p3, this.p2));
            ret.add(new VectorBasic(this.p2, this.p4));
            ret.add(new VectorBasic(this.p4, this.p1));
        }else if (this.p1.getDistance(this.p3) > this.p1.getDistance(this.p2) && this.p1.getDistance(this.p3) > this.p1.getDistance(this.p4)){
            ret.add(new VectorBasic(this.p1, this.p2));
            ret.add(new VectorBasic(this.p2, this.p3));
            ret.add(new VectorBasic(this.p3, this.p4));
            ret.add(new VectorBasic(this.p4, this.p1));
        }else{
            ret.add(new VectorBasic(this.p1, this.p2));
            ret.add(new VectorBasic(this.p2, this.p4));
            ret.add(new VectorBasic(this.p4, this.p3));
            ret.add(new VectorBasic(this.p3, this.p1));
        }
        return ret;
    }

    @Override
    public boolean isInside(PointBasic p) {
        /* Calculate area of rectangle ABCD */

        double A = TriangleShape.area(this.p1, this.p2, this.p3) + TriangleShape.area(this.p1, this.p4, this.p3);

        double A1 = TriangleShape.area(p, this.p1, this.p2);

        /* Calculate area of triangle PBC */
        double A2 = TriangleShape.area(p, this.p2, this.p3);

        /* Calculate area of triangle PCD */
        double A3 = TriangleShape.area(p, this.p3, this.p4);

        /* Calculate area of triangle PAD */
        double A4 = TriangleShape.area(p, this.p1, this.p4);

        double diff = A - (A1 + A2 + A3 + A4);

        return diff < 0.01;
    }
}
