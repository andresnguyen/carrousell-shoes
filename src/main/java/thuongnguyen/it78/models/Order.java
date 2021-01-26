package thuongnguyen.it78.models;


import java.util.ArrayList;


public class Order {
    private int id;
    private int status;
    private ArrayList<OrderDetail> listOrderDetail;
    private Account account;
    private String orderDate;
    private String orderNote;

    public Order() {
        listOrderDetail = new ArrayList<>();
    }

    public void addDetail(OrderDetail or) {
        listOrderDetail.add(or);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<OrderDetail> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(ArrayList<OrderDetail> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", orderDetail=" + listOrderDetail.toString() +
                ", account=" + account +
                ", orderDate='" + orderDate + '\'' +
                ", orderNote='" + orderNote + '\'' +
                '}';
    }
}
