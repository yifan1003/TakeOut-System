public class Admin {
    private String id;
    private String name;
    private String password;
    public Admin(){

    }
    public Admin(String aId, String aName, String aPassword){
        super();
        this.id = aId;
        this.name = aName;
        this.password = aPassword;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Admin [id=" + id + ", name=" + name + ", password=" + password + "]";
    }
    
}
