package com.ptit.dto;
import com.ptit.entity.Product;

public class LaptopDTO extends Product {
    private String cpu;
    private String ram;
    public String getCpu() { return cpu; }
    public void setCpu(String cpu) { this.cpu = cpu; }
    public String getRam() { return ram; }
    public void setRam(String ram) { this.ram = ram; }
}
