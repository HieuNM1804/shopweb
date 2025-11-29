package com.ptit.entity;

public class Perfume extends Product {
        @Override
        public String getName() {
            return super.getName() + " (Perfume)";
        }
    private String fragrance;
    private String brand;
    // getter/setter
    public String getFragrance() { return fragrance; }
    public void setFragrance(String fragrance) { this.fragrance = fragrance; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
}
