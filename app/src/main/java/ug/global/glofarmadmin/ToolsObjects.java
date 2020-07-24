package ug.global.glofarmadmin;

public class ToolsObjects {
    private String name;
    private String available;
    private String price;

    public ToolsObjects(String price, String name, String available) {
        this.price = price;
        this.name = name;
        this.available = available;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getAvailable() {
        return available;
    }


}
