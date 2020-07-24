package ug.global.glofarmadmin;

public class FarmerObjects {
    private String name, contact, location;

    public FarmerObjects(String name, String contact, String location) {
        this.name = name;
        this.contact = contact;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getLocation() {
        return location;
    }


}
