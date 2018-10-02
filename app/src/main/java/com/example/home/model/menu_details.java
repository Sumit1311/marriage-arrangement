package com.example.home.model;

public class menu_details {
   int m_id;

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    public String getMenu_time() {
        return menu_time;
    }

    public void setMenu_time(String menu_time) {
        this.menu_time = menu_time;
    }

    public String getMenu_dt() {
        return menu_dt;
    }

    public void setMenu_dt(String menu_dt) {
        this.menu_dt = menu_dt;
    }

    String menu_type,menu_time,menu_dt;
}
