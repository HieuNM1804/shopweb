package com.ptit.entity;

public class Laptop extends Product {
        @Override
        public String getProductType() {
            return "Laptop";
        }
    private String cpu;
    private String ram;
    // getter/setter
    public String getCpu() { return cpu; }
    public void setCpu(String cpu) { this.cpu = cpu; }
    public String getRam() { return ram; }
    public void setRam(String ram) { this.ram = ram; }

    // --- POLYMORPHISM OVERRIDES ---

    @Override
    public Double calculateShippingFee() {
        // Laptop nặng và cồng kềnh, phí ship cao hơn + bảo hiểm
        return 100000.0; 
    }

    @Override
    public String getWarrantyPeriod() {
        // Laptop thường bảo hành lâu hơn
        return "24 Tháng (Chính hãng)";
    }
}
