package com.shapedhorizon;

import java.util.ArrayList;
import java.util.List;

public class LineShape implements Shape {
    private PointBasic center;
    private VectorBasic line;

    public LineShape(VectorBasic line) {
        this.line = line;
        this.center = line.getCenter();
    }

    public LineShape(PointBasic p1, PointBasic p2){
        this.line = new VectorBasic(p1, p2);
        this.center = this.line.getCenter();
    }

    public LineShape(PointBasic p1, PointBasic p2, int color){
        this.line = new VectorBasic(p1, p2, color);
        this.center = this.line.getCenter();
    }

    @Override
    public PointBasic getCenter() {
        return this.center;
    }

    @Override
    public void setCenter(PointBasic point) {
        this.center = point;
    }

    @Override
    public List<VectorBasic> getVectors() {
        ArrayList<VectorBasic> ret = new ArrayList<VectorBasic>();
        ret.add(line);
        return ret;
    }
}
