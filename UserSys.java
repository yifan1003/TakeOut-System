import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserSys implements DAO<User>{
    static Map<String, User> usermap = new HashMap<>();
    List<User> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    @Override
    public void insert(User t) {
        // TODO Auto-generated method stub
        usermap.put(t.getuId(), t);
        
    }
    @Override
    public User findById(String id) {
        // TODO Auto-generated method stub
        if(usermap.get(id) == null){
            return null;
        } else {
            return usermap.get(id);
        }
    }
    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        for(String key : usermap.keySet()) {
            list.add(usermap.get(key));
        }
        return list;
    }
    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        if(usermap.get(id) == null){
            System.out.println("user does not exist");
        } else {
            usermap.remove(id);
            System.out.println(usermap.get(id) + "has deleted!");
        }
    }

    public void changePass(String id){
        User user = usermap.get(id);
        System.out.println("Please enter new password");
        String newPass = sc.next();
        String oldPass = user.getPassword();
        while(newPass.equals(oldPass)){
            System.out.println("Please enter new password");
            newPass = sc.next();
        }
        user.setPassword(newPass);
        usermap.put(id, user);
    }
    

}
