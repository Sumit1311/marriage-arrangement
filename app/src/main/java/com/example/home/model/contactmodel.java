package com.example.home.model;

public class contactmodel {
    private boolean isSelected;
    String cname;

    public String getType_of_guest() {
        return type_of_guest;
    }

    public void setType_of_guest(String type_of_guest) {
        this.type_of_guest = type_of_guest;
    }

    String type_of_guest;
    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    String cno;
}
