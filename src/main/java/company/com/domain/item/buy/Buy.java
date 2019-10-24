package company.com.domain.item.buy;

public class Buy {
    private String itemName;
    private String size;
    private int quantity;
    private String flovor;
    private String color;
    private String description;
    private String customer;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFlovor() {
        return flovor;
    }

    public void setFlovor(String flovor) {
        this.flovor = flovor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "itemName='" + itemName + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                ", flovor='" + flovor + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}
