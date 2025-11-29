package com.ptit.dto;
import com.ptit.entity.Product;

public class JewelryDTO extends Product {
    private String material;
    private String gemstone;
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public String getGemstone() { return gemstone; }
    public void setGemstone(String gemstone) { this.gemstone = gemstone; }
}
