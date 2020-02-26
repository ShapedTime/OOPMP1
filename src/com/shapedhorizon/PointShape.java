package com.shapedhorizon;

import java.util.ArrayList;
import java.util.List;

public class PointShape implements Shape {
    private PointBasic center;

    public PointShape(PointBasic center) {
        this.center = center;
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
        List<VectorBasic> ret = new ArrayList<>();
        ret.add(new VectorBasic(center));
        return ret;
    }
}
