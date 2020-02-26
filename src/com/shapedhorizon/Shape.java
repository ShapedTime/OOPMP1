package com.shapedhorizon;

import java.util.List;

public interface Shape {
    public PointBasic getCenter();
    public List<VectorBasic> getVectors();
    public boolean isInside(PointBasic p);
}
