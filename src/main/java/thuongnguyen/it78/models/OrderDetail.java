package thuongnguyen.it78.models;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private int ShoesID;
    private int OrderID;
    private int quantity;
    private Shoes shoes;

    public OrderDetail() {

    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public int getShoesID() {
        return ShoesID;
    }

    public void setShoesID(int shoesID) {
        ShoesID = shoesID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "ShoesID=" + ShoesID +
                ", OrderID=" + OrderID +
                ", quantity=" + quantity +
                ", shoes=" + shoes +
                '}';
    }
}
