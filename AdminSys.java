import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdminSys implements DAO<Admin>{

    static Map<String, Admin> adminMap = new HashMap<>();

    UserSys u = new UserSys();
    OrderSys o = new OrderSys();
    DishSys d = new DishSys();
    Scanner sc = new Scanner(System.in);

    @Override
    public void insert(Admin t) {
        // TODO Auto-generated method stub
        adminMap.put(t.getId(), t);
        
    }

    @Override
    public Admin findById(String id) {
        // TODO Auto-generated method stub
        if(adminMap.get(id) == null) {
            System.out.println("No such admin");
            return null;
        } else {
            return adminMap.get(id);
        }
        
    }

    @Override
    public List<Admin> findAll() {
        // TODO Auto-generated method stub
        return new ArrayList<>(adminMap.values());
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        adminMap.remove(id);
        
    }

    public void addDish() {
        System.out.println("Please enter dish");
        String str = sc.next();
        String[] info = str.split("/");
        if(info.length < 6) {
            System.out.println("Type error, please enter again");
            addDish();
        } else {
            LocalDateTime dtime = LocalDateTime.now();
            Dish t = new Dish(info[0], info[1], info[2], dtime, Double.parseDouble(info[3]),
            Integer.parseInt(info[4]), Integer.parseInt(info[5]));
            d.insert(t);
            System.out.println("Con! Add dish succeed");
        }
    }

    public void showAllDishes(int pageSize) {
        List<Dish> list = d.findAll();
        System.out.println(list);
    }

    public void selectBytypeOfAdmin() {
        System.out.println("Please enter the type of dish");
        String typeName = sc.next();
        d.selectBytype(typeName);
    }
    
    /*
     change dish price based on id
    */
    public void updateDishPrice() {
        System.out.println("please enter the dish you want to change price");
        String id = sc.next();
        Dish dish = d.findById(id);
        if(dish != null) {
            System.out.println("Please enter new price for this dish");
            double newprice = sc.nextDouble();
            dish.setdPrice(newprice);
            d.insert(dish);
            System.out.println("update succeed " + d.findById(dish.getdID()));
        }
    }
    /*
     *
     * 
     * delete dish
     * 
     */
    public void deleteDish() {
        System.out.println("Please enter the dish ID you want to delete");
        String id = sc.next();
        d.delete(id);
        System.out.println("delete succeed!");
    }

    /*
     *
     * add new user
     */
    public void addUser() {
        System.out.println("Please enter the user that you want to added");
        String str = sc.next();
        String[] info = str.split("/");
    if (info.length < 6) {
        System.out.println("Information wrong, please enter again");
        addUser();
        } else {
        LocalDateTime utime = LocalDateTime.now();
        u.insert(new User(info[0], info[1], info[2], info[3], info[4], info[5], utime));
        System.out.println("Add user succeed");
        }
    }

    /*
     * check user list
     */
    public void findUser() {
        List<User> uList = u.findAll();
        for (User user : uList) {
            System.out.println(user);
        }
    }
    /*
     * find user
     */

    public User findUserById(String id) {
        return u.findById(id);
    }

    /*
     * delete user
     */

    public void deleteUserByAdmin() {
        System.out.println("Please insert user id");
        String id = sc.next();
        u.delete(id);
    }

    /*
    *show orders
    */
    public void showAllOrder() {
        for (Order order : o.findAll()) {
            System.out.println(order);
        }
    }

    /*
     * change order status based on order id
     */
    public void changeOrderStatus() {
        System.out.println("Please enter order id");
        String id = sc.next();
        Order order = o.findById(id);
        if(order != null) {
            System.out.println("Please enter the status: 0: unpaid 1 : paid 2: on the way 3 : completed");
            int newStatus = sc.nextInt();
            order.setOrderStatus(newStatus);
            o.insert(order);
            System.out.println("Update succeed!");
        }
    }

    /*
     * show all dish (sort by sales value from high to low)
     */
    public void showAllDishesByUser() {
        List<Dish> dishList = d.findAll();
        // Use Collections and lambda expression
        Collections.sort(dishList,(p1, p2) -> p1.getDsales() - p2.getDsales());
        System.out.println(dishList);
    }

    /*
     * shop (enter dish id and value)
     */
    public void shopDishes(User user) {
        showAllDishesByUser();
        //Use id/value format
        System.out.println("Please enter the dish id and value");
        String str = sc.next();
        String[] info = str.split("/");
        // judge if the format is correct
        if (info.length < 2) {
            System.out.println("Format is wrong, please enter again");
            shopDishes(user);
        } else {
            LocalDateTime localDateTime = LocalDateTime.now();
            Order t = new Order(info[0], localDateTime, d.findById(info[0]),Integer.parseInt(info[1]), user.getuId(),o.findById(info[0]).getTotal(), o.findById(info[0]).getOrderStatus());
            o.insert(t);
            System.out.println("Place order succeed!");
        }
    }

    /*
     * show all dishes based on dish type
     */
    public void showDishOfType() {
        System.out.println("please enter the dish type");
        String str = sc.next();
        System.out.println(d.findByTypes(str));
    }

    /*
     * show all orders for one user
     */
    public void showAllOrderByUser(User user) {
        for (Order order : o.findByuId(user.getuId())) {
            System.out.println(order);
        }
    }
    public void showByUser(User user) {
        User userInfo = u.findById(user.getuId());
        System.out.println(userInfo);
    }

    /* 
     * change password for current user
     */
    public void changePwdByUser(User user) {
        u.changePass(user.getuId());
        System.out.println("Change succeed!");
    }

    public void addMessage() {
        adminMap.put("qwl", new Admin("10086", "qwl", "123456"));
        LocalDateTime time = LocalDateTime.now();
        Dish d1 = new Dish("1", "红烧猪蹄", "肉类", time, 12.5, 20, 30);
        d.insert(d1);
        Dish d2 = new Dish("2", "鸡公煲", "肉类", time, 21.5, 30, 20);
        d.insert(d2);
        Dish d3 = new Dish("3", "麻辣香锅", "火锅类", time, 30, 5, 10);
        d.insert(d3);
        Dish d4 = new Dish("4", "水煮肉片", "肉类", time, 15, 12, 15);
        d.insert(d4);
        Dish d5 = new Dish("5", "水果沙拉", "水果类", time, 6, 70, 60);
        d.insert(d5);
        // String orderID, LocalDateTime utime, Dishes dishes, int ordernum, String uID,
        // Double orderprice,int orderValue
        LocalDateTime localdatetime = LocalDateTime.now();
        Order o1 = new Order("1", localdatetime, d1, 10, "1001", 60.0, 1);
        o.insert(o1);
        Order o2 = new Order("2", localdatetime, d2, 5, "1002", 50.0, 10);
        o.insert(o2);
        Order o3 = new Order("3", localdatetime, d3, 5, "1003", 40.0, 5);
        o.insert(o3);
        Order o4 = new Order("4", localdatetime, d4, 5, "1004", 30.0, 6);
        o.insert(o4);
        Order o5 = new Order("5", localdatetime, d5, 5, "1005", 20.0, 8);
        o.insert(o5);
        // String uID, String uname, String usex, String upwd, String uadress, String
        // utel, LocalDateTime utime
        User u1 = new User("1001", "张三", "男", "123456", "湖北", "13545286487", localdatetime);
        u.insert(u1);
        User u2 = new User("1002", "李四", "男", "234567", "湖南", "15927948976", localdatetime);
        u.insert(u2);
        User u3 = new User("1003", "王五", "男", "345678", "江苏", "15927986854", localdatetime);
        u.insert(u3);
        User u4 = new User("1004", "刘柳", "女", "456789", "浙江", "18771580860", localdatetime);
        u.insert(u4);
        User u5 = new User("1005", "赵琦", "女", "567890", "新疆", "18771580750", localdatetime);
        u.insert(u5);
      }
    



    




    
}
