package com.shapedhorizon;

import java.util.List;

public interface Shape {
    public PointBasic getCenter();
    public void setCenter(PointBasic point);
    public List<VectorBasic> getVectors();
}
