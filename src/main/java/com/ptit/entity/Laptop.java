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
}
