package inventoryManagment;
//
import java.util.HashMap;
import java.util.Map;

public class IngredientList {

    private final HashMap<String, Ingredient> list;

    public IngredientList() {
        this.list = new HashMap<>();
    }

    public void addIngredient(Ingredient item){
       this.list.put(item.getName(),item);
    }

    public void getIngredient(String item){
        this.list.get(item);
    }

    public void printQuantity(String name){
        Ingredient item = list.get(name);
        System.out.println(this.list.get(item.getName()).getQuantity());
    }

    public void printAll(){
        for(Map.Entry<String, Ingredient> item : this.list.entrySet())
            System.out.println(item.getValue().getName() + ": " + item.getValue().getQuantity());
    }

    public void lowStock () {
        for(Map.Entry<String, Ingredient> item : this.list.entrySet())
            if (item.getValue().getQuantity() <= 10)
                System.out.println(item.getKey() + " is low. " + item.getValue().getQuantity() + " remaining.");
    }

    public void useStock(String name){
        Ingredient item = list.get(name);
        item.use();
        this.list.put(item.getName(), item);

    }

    public void useStock(String name, int amount){
        Ingredient item = list.get(name);
        item.use(amount);
        this.list.put(item.getName(), item);

    }

    public void addStock(String name){
        Ingredient item = list.get(name);
        item.add();
        this.list.put(item.getName(), item);

    }

    public void addStock(String name, int amount){
        Ingredient item = list.get(name);
        item.add(amount);
        this.list.put(item.getName(), item);

    }


}
