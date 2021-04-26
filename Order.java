import java.time.LocalDateTime;

public class Order {
    private String PID;
    private LocalDateTime utime;
    private Dish dishes;
    private int orderNumber;
    private String uId;
    private double Total;
    private int orderStatus;
    public Order() {
    }
    public Order(String pID, LocalDateTime utime, Dish dishes, int orderNumber, String uId, double total,
            int orderStatus) {
        PID = pID;
        this.utime = utime;
        this.dishes = dishes;
        this.orderNumber = orderNumber;
        this.uId = uId;
        Total = total;
        this.orderStatus = orderStatus;
    }
    public String getPID() {
        return PID;
    }
    public void setPID(String pID) {
        PID = pID;
    }
    public LocalDateTime getUtime() {
        return utime;
    }
    public void setUtime(LocalDateTime utime) {
        this.utime = utime;
    }
    public Dish getDishes() {
        return dishes;
    }
    public void setDishes(Dish dishes) {
        this.dishes = dishes;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public String getuId() {
        return uId;
    }
    public void setuId(String uId) {
        this.uId = uId;
    }
    public double getTotal() {
        return Total;
    }
    public void setTotal(double total) {
        Total = total;
    }
    public int getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
    @Override
    public String toString() {
        return "Order [PID=" + PID + ", Total=" + Total + ", dishes=" + dishes + ", orderNumber=" + orderNumber
                + ", orderStatus=" + orderStatus + ", uId=" + uId + ", utime=" + utime + "]";
    }
    
}
