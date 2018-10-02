package com.example.home.model;

public class room {
    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    String roomno;
    private boolean isSelected;
    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public String getGuest_nm() {
        return guest_nm;
    }

    public void setGuest_nm(String guest_nm) {
        this.guest_nm = guest_nm;
    }

    public String getGuest_mob() {
        return guest_mob;
    }

    public void setGuest_mob(String guest_mob) {
        this.guest_mob = guest_mob;
    }

    String guest_nm;
    String guest_mob;
}
