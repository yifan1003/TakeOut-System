import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DishSys implements DAO<Dish>{
    static Map<String, Dish> dishmap = new HashMap<>();

    @Override
    public void insert(Dish t) {
        // TODO Auto-generated method stub
        dishmap.put(t.getdID(),t);
    }

    @Override
    public Dish findById(String id) {
        // TODO Auto-generated method stub
        if(dishmap.get(id) == null) {
            System.out.println("No such dish");
            return null;
        } else {
            return dishmap.get(id);
        }
        
    }

    @Override
    public List<Dish> findAll() {
        // TODO Auto-generated method stub
        List<Dish> dishList = new ArrayList<>();
        for(String key : dishmap.keySet()) {
            dishList.add(dishmap.get(key));
        }
        return dishList;
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        if(dishmap.get(id) == null) {
            System.out.println("no such dish");
        } else {
            dishmap.remove(id);
        }
        
    }
    
    public List<Dish> findByTypes(String type) {
        List<Dish> list= new ArrayList<>();
        for(String key : dishmap.keySet()) {
            if(dishmap.get(key).getdType().equals(type)){
                list.add(dishmap.get(key));
            }
        }
        return list;
    }

    public void selectBytype(String typename) {
        int count = 0;
        for (String key : dishmap.keySet()) {
            if(dishmap.get(key).getdType().equals(typename)) {
                System.out.println(dishmap.get(key));
                count++;
            }
        }
        if(count == 0) {
            System.out.println("No such type dish");
        }
    }

    
}
