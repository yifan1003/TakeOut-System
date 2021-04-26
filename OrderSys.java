import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderSys implements DAO<Order>{
    static Map<String, Order> ordermap = new HashMap<>();
    static List<Order> orderlist = new ArrayList<>();
    @Override
    public void insert(Order t) {
        // TODO Auto-generated method stub
        ordermap.put(t.getuId(),t);
        
    }
    @Override
    public Order findById(String id) {
        // TODO Auto-generated method stub

        if(ordermap.get(id) == null){
            System.out.println("order not exist");
            return null;
        }else {
            return ordermap.get(id);
        }
    }
    @Override
    public List<Order> findAll() {
        // TODO Auto-generated method stub
        for(String key : ordermap.keySet()){
            orderlist.add(ordermap.get(key));
        }
        return orderlist;
    }
    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        if(ordermap.get(id) == null){
            System.out.println("no such order");
        } else {
            ordermap.remove(id);
        }
    }
    // use UserId find the user all orders, return a order list
    public List<Order> findByuId(String uId) {
        List<Order> list = new ArrayList<>();
        for(String key : ordermap.keySet()){
            if(ordermap.get(key).getuId().equals(uId)){
                list.add(ordermap.get(key));
            }
        }
        return list;
    }
    

    
}
