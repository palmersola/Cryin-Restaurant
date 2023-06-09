package inventoryManagment;

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

    public Ingredient getIngredient(String item){
        return this.list.get(item);
    }

    public int printQuantity(String name){
        Ingredient item = list.get(name);
        System.out.println(this.list.get(item.getName()).getQuantity());
        return this.list.get(item.getName()).getQuantity();
    }

    public String printName(String name){
        Ingredient item = list.get(name);
        System.out.println(this.list.get(item.getName()).getName());
        return this.list.get(item.getName()).getName();
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
        Ingredient ingredient = list.get(name);
        ingredient.add();
        this.list.put(ingredient.getName(), ingredient);

    }

    public void addStock(String name, int amount){
        Ingredient item = list.get(name);
        item.add(amount);
        this.list.put(item.getName(), item);

    }
}
