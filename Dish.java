import java.time.LocalDateTime;

public class Dish {
    private String dID;
    private String dName;
    private String dType;
    private LocalDateTime time;
    private double dPrice;
    private int dsales;
    private int dstocks;
    
    public Dish() {
    }
    
    public Dish(String dID, String dName, String dType, LocalDateTime time, double dPrice, int dsales, int dstocks) {
        this.dID = dID;
        this.dName = dName;
        this.dType = dType;
        this.time = time;
        this.dPrice = dPrice;
        this.dsales = dsales;
        this.dstocks = dstocks;
    }

    public String getdID() {
        return dID;
    }
    public void setdID(String dID) {
        this.dID = dID;
    }
    public String getdName() {
        return dName;
    }
    public void setdName(String dName) {
        this.dName = dName;
    }
    public String getdType() {
        return dType;
    }
    public void setdType(String dType) {
        this.dType = dType;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public double getdPrice() {
        return dPrice;
    }
    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }
    public int getDsales() {
        return dsales;
    }
    public void setDsales(int dsales) {
        this.dsales = dsales;
    }
    public int getDstocks() {
        return dstocks;
    }
    public void setDstocks(int dstocks) {
        this.dstocks = dstocks;
    }

    @Override
    public String toString() {
        return "Dish [dID=" + dID + ", dName=" + dName + ", dPrice=" + dPrice + ", dType=" + dType + ", dsales="
                + dsales + ", dstocks=" + dstocks + ", time=" + time + "]";
    }
    
    
}
