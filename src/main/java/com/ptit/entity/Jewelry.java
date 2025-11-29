package com.ptit.entity;

public class Jewelry extends Product {
        @Override
        public String getName() {
            return super.getName() + " (Jewelry)";
        }
    private String material;
    private String gemstone;
    // getter/setter
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public String getGemstone() { return gemstone; }
    public void setGemstone(String gemstone) { this.gemstone = gemstone; }
}
