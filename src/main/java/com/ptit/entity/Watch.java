package com.ptit.entity;

public class Watch extends Product {
            @Override
            public String getName() {
                return super.getName() + " (Watch)";
            }
        @Override
        public String getProductType() {
            return "Watch";
        }
    private String brand;
    private String strapMaterial;
    // getter/setter
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getStrapMaterial() { return strapMaterial; }
    public void setStrapMaterial(String strapMaterial) { this.strapMaterial = strapMaterial; }

    // --- POLYMORPHISM OVERRIDES ---

    @Override
    public Double calculateShippingFee() {
        // Đồng hồ nhẹ, phí ship rẻ
        return 15000.0; 
    }

    @Override
    public String getWarrantyPeriod() {
        return "36 Tháng (Bảo hành máy)";
    }
}
