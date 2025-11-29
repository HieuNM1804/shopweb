package com.ptit.entity;

public class Camera extends Product {
        @Override
        public String getName() {
            return super.getName() + " (Camera)";
        }
    private String resolution;
    private String sensorType;
    // getter/setter
    public String getResolution() { return resolution; }
    public void setResolution(String resolution) { this.resolution = resolution; }
    public String getSensorType() { return sensorType; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }
}
