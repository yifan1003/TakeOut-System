import java.time.LocalDateTime;

public class User {
    private String uId;
    private String uName;
    private String gender;
    private String password;
    private String address;
    private String phone;
    private LocalDateTime utime;
    public User() {
    }
    public User(String uId, String uName, String gender, String password, String address, String phone,
            LocalDateTime utime) {
        this.uId = uId;
        this.uName = uName;
        this.gender = gender;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.utime = utime;
    }
    public String getuId() {
        return uId;
    }
    public void setuId(String uId) {
        this.uId = uId;
    }
    public String getuName() {
        return uName;
    }
    public void setuName(String uName) {
        this.uName = uName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public LocalDateTime getUtime() {
        return utime;
    }
    public void setUtime(LocalDateTime utime) {
        this.utime = utime;
    }
    @Override
    public String toString() {
        return "User [address=" + address + ", gender=" + gender + ", password=" + password + ", phone=" + phone
                + ", uId=" + uId + ", uName=" + uName + ", utime=" + utime + "]";
    }
    
}
