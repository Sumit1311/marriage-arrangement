package com.example.home.model;

public class transport {
    int v_id;
    String driver_nm;

    public String getVehicle_path() {
        return vehicle_path;
    }

    public void setVehicle_path(String vehicle_path) {
        this.vehicle_path = vehicle_path;
    }

    String vehicle_path;

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public String getDriver_nm() {
        return driver_nm;
    }

    public void setDriver_nm(String driver_nm) {
        this.driver_nm = driver_nm;
    }

    public String getDriver_mob() {
        return driver_mob;
    }

    public void setDriver_mob(String driver_mob) {
        this.driver_mob = driver_mob;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getVehicle_imgpath() {
        return vehicle_imgpath;
    }

    public void setVehicle_imgpath(String vehicle_imgpath) {
        this.vehicle_imgpath = vehicle_imgpath;
    }

    String driver_mob;
    String vehicle_no;
    String vehicle_imgpath;

}
