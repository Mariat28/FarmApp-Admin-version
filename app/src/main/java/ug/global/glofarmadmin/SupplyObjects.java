package ug.global.glofarmadmin;

public class SupplyObjects {
    private String supplyname;
    private String brand;
    private String availablesupply;
    private String supplytype;
    private String supplyprice;

    public SupplyObjects(String supplyname, String brand, String availablesupply, String supplytype, String supplyprice) {
        this.supplyname = supplyname;
        this.brand = brand;
        this.availablesupply = availablesupply;
        this.supplytype = supplytype;
        this.supplyprice = supplyprice;
    }

    public String getSupplyname() {
        return supplyname;
    }

    public String getBrand() {
        return brand;
    }


    public String getAvailablesupply() {
        return availablesupply;
    }

    public String getSupplytype() {
        return supplytype;
    }

    public String getSupplyprice() {
        return supplyprice;
    }
}
