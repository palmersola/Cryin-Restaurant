package inventoryManagment;

public class Ingredient {
    private String name;
    private int quantity;

    public Ingredient(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void use(){
        this.quantity--;
    }

    public void use(int amount){
        this.quantity -= amount;
    }

    public void add(){
        this.quantity++;
    }

    public void add(int amount){
        this.quantity += amount;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
