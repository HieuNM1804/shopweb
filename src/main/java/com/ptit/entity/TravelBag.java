package com.ptit.entity;

public class TravelBag extends Product {
        @Override
        public String getName() {
            return super.getName() + " (TravelBag)";
        }
    private String size;
    private String material;
    // getter/setter
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
}
